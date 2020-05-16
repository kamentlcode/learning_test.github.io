package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Bookrack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookrackMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bookrack record);

    int insertSelective(Bookrack record);

    Bookrack selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Bookrack record);

    int updateByPrimaryKey(Bookrack record);

    List<Bookrack> pageList(@Param("uId") Integer uId,
                            @Param("bName") String bName);
}