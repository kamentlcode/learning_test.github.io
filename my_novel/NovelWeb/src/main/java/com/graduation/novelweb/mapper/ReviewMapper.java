package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 书评接口
 */
public interface ReviewMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKeyWithBLOBs(Review record);

    int updateByPrimaryKey(Review record);

    List<Review> pageList(@Param("nId") Integer nId,
                          @Param("uId") Integer uId);
}