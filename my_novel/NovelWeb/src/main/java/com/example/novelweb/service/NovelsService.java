package com.example.novelweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novelweb.dto.Novels;
import com.example.novelweb.mapper.ChaptersMapper;
import com.example.novelweb.mapper.NovelsMapper;

/**
 * 小说主题业务处理层
 * @author lexed
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
