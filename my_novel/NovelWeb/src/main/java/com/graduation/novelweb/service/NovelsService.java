package com.graduation.novelweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.util.errorcode.MyErrorCode;
import com.graduation.novelweb.util.errorcode.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.novelweb.dto.Novels;
import com.graduation.novelweb.mapper.ChaptersMapper;
import com.graduation.novelweb.mapper.NovelsMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 小说主体业务处理层
 * @author tanlin
 *
 */
@Service
public class NovelsService {
	@Autowired
	private NovelsMapper mapper;
	@Autowired
	private ChaptersMapper chaptersMapper;


	public Novels getById(Integer id){
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 新增一本小说书籍
	 * @param novel
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public Novels insert(Novels novel){
		ParamUtil.checkNotNull(novel, MyErrorCode.NovelCode.NOVEL_NOT_EXIST);
		ParamUtil.checkNotBlank(novel.getnName(), MyErrorCode.NovelCode.NOVEL_NAME_NOTBLANK);
		ParamUtil.checkNotBlank(novel.getnAuthor(), MyErrorCode.NovelCode.NOVEL_AUTHOR_NOTBLANK);

		//根据txt文件名来做吧
		//文件上传完成后
		//点击入库，获取名称   设置类型，介绍
		Date now = new Date();
		novel.setnId(Integer.valueOf(String.valueOf(now.getTime()).substring(0, 10)));
		novel.setCreateTime(now);
		novel.setUpdateTime(now);
		mapper.insert(novel);
		return novel;
	}

	/**
	 * 查询小说列表
	 * @param
	 * @return
	 */
	public PageInfo<Novels> page(PageInfo<Novels> page, String keyword,String type){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Novels> novels = mapper.pageList(keyword,type);
		page =((Page<Novels>)novels).toPageInfo();
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return page;

	}

	/**
	 * 查询按收藏数排行的小说
	 * @param page
	 * @param keyword
	 * @return
	 */
	public PageInfo<Novels> pageCountBr(PageInfo<Novels> page, String keyword, String type){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Novels> novels = mapper.countBrList(keyword,type);
		//按收藏数从大到小排列排行
		Collections.sort(novels, new Comparator<Novels>() {
			@Override
			public int compare(Novels n0, Novels n1) {
				if (null==n0.getCount()){
					n0.setCount(0);
				}
				if (null==n1.getCount()){
					n1.setCount(0);
				}
				return n1.getCount()-n0.getCount();
			}
		});
		page =((Page<Novels>)novels).toPageInfo();
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return page;

	}

	/**
	 * 查询按总字数排行的小说
	 * @param page
	 * @param keyword
	 * @return
	 */
	public PageInfo<Novels> countWordsList(PageInfo<Novels> page, String keyword, String type){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Novels> novels = mapper.countWordsList(keyword,type);
		//按总字数从大到小排列排行
		Collections.sort(novels, new Comparator<Novels>() {
			@Override
			public int compare(Novels n0, Novels n1) {
				if (null==n0.getCount()){
					n0.setCount(0);
				}
				if (null==n1.getCount()){
					n1.setCount(0);
				}
				return n1.getCount()-n0.getCount();
			}
		});
		page =((Page<Novels>)novels).toPageInfo();
		return page;

	}

	/**
	 * 查询按书评数排行的小说
	 * @param page
	 * @param keyword
	 * @return
	 */
	public PageInfo<Novels> countReviewsList(PageInfo<Novels> page, String keyword, String type){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Novels> novels = mapper.countReviewsList(keyword,type);
		//按书评数从大到小排列排行
		Collections.sort(novels, new Comparator<Novels>() {
			@Override
			public int compare(Novels n0, Novels n1) {
				if (null==n0.getCount()){
					n0.setCount(0);
				}
				if (null==n1.getCount()){
					n1.setCount(0);
				}
				return n1.getCount()-n0.getCount();
			}
		});
		page =((Page<Novels>)novels).toPageInfo();
		return page;

	}

	/**
	 * 查询按热度排行的小说
	 * @param page
	 * @param keyword
	 * @return
	 */
	public PageInfo<Novels> countPopularityList(PageInfo<Novels> page, String keyword,String type){
		//获取收藏数和评论数排行的小说集合
		PageInfo<Novels> brNovels = pageCountBr(page, keyword,type);
		PageInfo<Novels> rNovels = countReviewsList(page,keyword,type);
		//计算热度
		List<Novels> novels = popularityUtil(brNovels, rNovels);
		//按热度从大到小排列排行
		Collections.sort(novels, new Comparator<Novels>() {
			@Override
			public int compare(Novels n0, Novels n1) {
				if (null==n0.getCount()){
					n0.setCount(0);
				}
				if (null==n1.getCount()){
					n1.setCount(0);
				}
				return n1.getCount()-n0.getCount();
			}
		});
		page =((Page<Novels>)novels).toPageInfo();
		return page;

	}

	/**
	 * 根据收藏数和评论数计算热度
	 * 热度=（收藏数*0.6+书评数*0.4）*100,没有收藏不计算热度
	 * @param brPage
	 * @param reviewsPage
	 * @return
	 */
	private List<Novels> popularityUtil(PageInfo<Novels> brPage,PageInfo<Novels> reviewsPage){
		List<Novels> br = brPage.getList();
		List<Novels> reviews = reviewsPage.getList();

		for (Novels bNovels : br) {
			Integer id = bNovels.getnId();
			bNovels.setCount(bNovels.getCount()*60);
			for (Novels rNovels : reviews) {
				System.out.println("-=-=-="+Objects.equals(id,rNovels.getnId()));
				//当一本小说被收藏和评论的小说时
				if (Objects.equals(id,rNovels.getnId())){
					bNovels.setCount((int) ( (rNovels.getCount()*40) + bNovels.getCount() ));
				}

			}
		}
		return br;
	}
}
