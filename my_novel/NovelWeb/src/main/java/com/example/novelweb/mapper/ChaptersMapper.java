package com.example.novelweb.mapper;

import com.example.novelweb.dto.Chapters;

public interface ChaptersMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Chapters record);

    Chapters selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeyWithBLOBs(Chapters record);

    int updateByPrimaryKey(Chapters record);
}