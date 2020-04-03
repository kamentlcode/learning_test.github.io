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

	public Novels insert(Novels novel){
		mapper.insert(novel);
		return novel;
	}

}
