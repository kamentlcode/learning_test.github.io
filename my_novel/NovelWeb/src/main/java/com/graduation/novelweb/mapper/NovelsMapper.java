package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Novels;

public interface NovelsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(Novels record);

    Novels selectByPrimaryKey(Integer nId);

    int updateByPrimaryKey(Novels record);
}