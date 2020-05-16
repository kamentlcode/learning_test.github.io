package com.graduation.novelweb.controller;

import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Bookrack;
import com.graduation.novelweb.dto.Review;
import com.graduation.novelweb.service.ReviewService;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanlin
 * @date 2020/5/10
 */
@RequestMapping("/review")
@Controller
public class ReviewController {

    @Autowired
    private ReviewService service;
    // 创建json对象
    JSONObject json = new JSONObject();

    /**
     * 新增书评
     * @param review
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody Review review){
        json.put("newReview", service.add(review));
        return json;
    }

    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                           @RequestParam(required = false) Integer pageSize,
                           @RequestParam(required = false) Integer nId,
                           @RequestParam(required = false) Integer uId){
        PageInfo<Review> page = PageUtil.createPageInfo(pageNum, pageSize, Review.class);
        page = service.page(page,nId,uId);
        json.put("reviews",page);
        return json;
    }


}
