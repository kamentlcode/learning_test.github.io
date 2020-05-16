package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.BoorackNovelRel;

public interface BoorackNovelRelMapper {
    int deleteByPrimaryKey(Integer relId);

    int insert(BoorackNovelRel record);

    int insertSelective(BoorackNovelRel record);

    BoorackNovelRel selectByPrimaryKey(Integer relId);

    int updateByPrimaryKeySelective(BoorackNovelRel record);

    int updateByPrimaryKey(BoorackNovelRel record);
}