package com.graduation.novelweb.mapper;

import com.graduation.novelweb.dto.Novels;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NovelsMapper {
    int deleteByPrimaryKey(Integer nId);

    /**
     * 新增一本小说信息
     * @param record
     * @return
     */
    int insert(Novels record);

    /**
     * 新增一本小说信息
     * @param record
     * @return
     */
    int insertSelective(Novels record);

    Novels selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(Novels record);

    int updateByPrimaryKey(Novels record);


    List<Novels> pageList(@Param("keyword")String keyword,
                          @Param("type")String type);

    List<Novels> countBrList(@Param("keyword")String keyword,
                             @Param("type")String type);

    List<Novels> countWordsList(@Param("keyword")String keyword,
                                @Param("type")String type);

    List<Novels> countReviewsList(@Param("keyword")String keyword,
                                  @Param("type")String type);

}