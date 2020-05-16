package com.graduation.novelweb.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Bookrack;
import com.graduation.novelweb.dto.Chapters;
import com.graduation.novelweb.service.ChaptersService;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanlin
 * @date 2020/5/13
 * 小说章节控制层
 */
@Controller
@RequestMapping("/chapter")
public class ChaptersController {
    @Autowired
    ChaptersService service;

    // 创建json对象
    JSONObject json = new JSONObject();

    /**
     * 分页查询小说所属的章节
     * @param pageNum
     * @param pageSize
     * @param nId
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                          @RequestParam(required = false) Integer pageSize,
                          @RequestParam(required = false) Integer nId){
        PageInfo<Chapters> page = PageUtil.createPageInfo(pageNum,pageSize,Chapters.class);
        json.put("chapters", service.page(page,nId));
        System.out.println("     pageNum="+pageNum);
        System.out.println("     pageSize="+pageSize);
        return json;
    }

    /**
     * 获取章节详情
     * @param cId
     * @return
     */
    @GetMapping("/select")
    @ResponseBody
    public JSONObject select(
            @RequestParam(required = false) Integer cId){
        json.put("chapter", service.select(cId));
        return json;
    }
}
