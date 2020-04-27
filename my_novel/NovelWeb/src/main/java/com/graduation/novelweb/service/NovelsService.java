package com.graduation.novelweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.novelweb.dto.Novels;
import com.graduation.novelweb.mapper.ChaptersMapper;
import com.graduation.novelweb.mapper.NovelsMapper;

/**
 * 小说主题业务处理层
 * @author tanlin
 *
 */
@Service
public class NovelsService {
	@Autowired
	private NovelsMapper mapper;
	@Autowired
	private ChaptersMapper chaptersMapper;

	/**
	 * 新增一本小说书籍
	 * @param novel
	 * @return
	 */
	public Novels insert(Novels novel){
		//根据txt文件名来做吧
		//文件上传完成后
		//点击入库，获取名称   设置类型，介绍
		mapper.insert(novel);
		return novel;
	}

}
