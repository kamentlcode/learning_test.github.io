package com.graduation.novelweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Chapters;
import com.graduation.novelweb.dto.Novels;
import com.graduation.novelweb.mapper.ChaptersMapper;
import com.graduation.novelweb.util.ParseBookContentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 小说章节业务处理层
 *
 * @author tanlin
 */
@Service
public class ChaptersService {
    @Autowired
    private ChaptersMapper chaptersMapper;

    @Autowired
    private ParseBookContentUtil bookContentUtil;

    /**
     * @param novel
     */
    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(Novels novel) {


        bookContentUtil.parse(novel);
    }

    /**
     * 小说id查询章节
     * @param page
     * @param nId
     * @return
     */
    public PageInfo<Chapters> page(PageInfo<Chapters> page, Integer nId) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Chapters> chapters = chaptersMapper.page(nId);
        page = ((Page<Chapters>)chapters).toPageInfo();
        return page;
    }

    /**
     * 查询最新章节
     * @param nId
     * @return
     */
    public Chapters selectNewest(Integer nId){
        Chapters chapters = chaptersMapper.selectNewest(nId);
        return chapters;

    }

    /**
     * id查询章节内容
     * @param cId
     * @return
     */
    public Chapters select(Integer cId){
        Chapters chapters = chaptersMapper.selectByPrimaryKey(cId);
        return chapters;

    }

}
