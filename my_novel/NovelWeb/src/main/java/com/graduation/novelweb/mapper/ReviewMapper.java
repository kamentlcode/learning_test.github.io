package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Review;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Review record);

    Review selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeyWithBLOBs(Review record);

    int updateByPrimaryKey(Review record);
}