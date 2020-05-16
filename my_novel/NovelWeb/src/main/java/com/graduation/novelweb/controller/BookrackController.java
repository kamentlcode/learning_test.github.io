package com.graduation.novelweb.controller;

import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Bookrack;
import com.graduation.novelweb.dto.BoorackNovelRel;
import com.graduation.novelweb.service.BookrackService;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户书架控制层
 * @author tanlin
 * @date 2020/5/8
 */
@RequestMapping("/bookrack")
@Controller
public class BookrackController {
    @Autowired
    private BookrackService service;

    // 创建json对象
    JSONObject json = new JSONObject();

    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody Bookrack bookrack){
        json.put("newBookrack", service.add(bookrack));
        return json;
    }

    @PostMapping("/addref")
    @ResponseBody
    public JSONObject addRef(@RequestBody BoorackNovelRel ref){
        json.put("newBookrack", service.addRef(ref));
        return json;
    }

    /**
     * 查询用户书架收藏的小说
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                           @RequestParam(required = false) Integer pageSize,
                           @RequestParam(required = true) Integer uId,
                           @RequestParam(required = false) String bName) {
        PageInfo<Bookrack> page = PageUtil.createPageInfo(pageNum, pageSize, Bookrack.class);
        page = service.page(page,uId,bName);
        System.out.println("0--------------"+bName);
        json.put("Bookracks", page);
        System.out.println("=============="+"调用分页查询");
        return json;

    }
}
