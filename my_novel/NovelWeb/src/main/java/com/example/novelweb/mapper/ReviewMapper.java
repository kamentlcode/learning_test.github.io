package com.example.novelweb.mapper;

import com.example.novelweb.dto.Review;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Review record);

    Review selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeyWithBLOBs(Review record);

    int updateByPrimaryKey(Review record);
}