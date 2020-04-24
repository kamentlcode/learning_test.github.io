package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Novels;

public interface NovelsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Novels record);

    int insertSelective(Novels record);

    Novels selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Novels record);

    int updateByPrimaryKey(Novels record);
}