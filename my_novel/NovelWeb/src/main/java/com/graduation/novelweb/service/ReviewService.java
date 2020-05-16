package com.graduation.novelweb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Bookrack;
import com.graduation.novelweb.dto.Review;
import com.graduation.novelweb.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 书评业务处理层
 * @author tanlin
 *
 */
@Service
public class ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    public Review add(Review review){
        System.out.println("================="+review.getrContent());
        System.out.println("================="+review.getnId());
        System.out.println("================="+review.getuId());
        Date now = new Date();
        review.setrId(Integer.valueOf(String.valueOf(now.getTime()).substring(0, 10)));
        review.setCreateTime(now);
        review.setUpdateTime(now);
        reviewMapper.insert(review);
        return review;
    }

    public PageInfo<Review> page(PageInfo<Review> page, Integer nId, Integer uId){
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Review> reviews = reviewMapper.pageList(nId, uId);
        page = ((Page<Review>)reviews).toPageInfo();
        return page;
    }
}
