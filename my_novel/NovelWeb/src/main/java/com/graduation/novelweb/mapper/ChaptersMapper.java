package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Chapters;

import java.util.List;

public interface ChaptersMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Chapters record);

    int insertSelective(Chapters record);

    Chapters selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Chapters record);

    int updateByPrimaryKeyWithBLOBs(Chapters record);

    int updateByPrimaryKey(Chapters record);

    List<Chapters> page(Integer nId);

    Chapters selectNewest(Integer nId);
}