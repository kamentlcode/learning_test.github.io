package com.graduation.novelweb.controller;

import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.dto.Novels;
import com.graduation.novelweb.service.ChaptersService;
import com.graduation.novelweb.service.NovelsService;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 小说主题控制层
 *
 * @author tanlin
 */
@RequestMapping("/novel")
@Controller
public class NovelsController {

    @Autowired
    private NovelsService service;
    @Autowired
    private ChaptersService chaptersService;

    // 创建json对象
    JSONObject json = new JSONObject();

    /**
     * 上传多个文件
     *
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String ajaxUploadFileCon(
            @RequestParam("file") MultipartFile mfile) throws IllegalStateException, IOException {
        // 判断是否有值
        if (mfile.isEmpty()) {
            // 结束
            return "没有选择上传文件";
        }
        // 获取存储路径
        // request.getServletContext().getRealPath("");//服务器项目路径
        String path = "F:/设计文稿/测试路径";
        // 获取文件名字
        String fname = mfile.getOriginalFilename();
        // 定义路径
        File ff = new File(path, fname);
        // 上传
        mfile.transferTo(ff);
        return "上传成功";
    }


    @PostMapping("/add")
    @ResponseBody
    public JSONObject add(@RequestBody Novels novel) {
        System.out.println("小说新增接口");
        Novels insert = service.insert(novel);
        json.put("newNovel", insert);
        return json;
    }

    @PostMapping("/upload/chapter")
    @ResponseBody
    public JSONObject uploadChapter(@RequestBody Novels novel) {
        chaptersService.add(novel);
        json.put("result", 1);
        return json;
    }

    /**
     * 分页查询所有小说
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                           @RequestParam(required = false) Integer pageSize,
                           @RequestParam(required = false) String keyword,
                           @RequestParam(required = false) String type) {
        PageInfo<Novels> page = PageUtil.createPageInfo(pageNum, pageSize, Novels.class);
        page = service.page(page, keyword, type);
        json.put("novels", page);
        return json;

    }

    /**
     * 分页查询所有小说(收藏排行)
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/count/br")
    @ResponseBody
    public JSONObject pageCountBr(@RequestParam(required = false) Integer pageNum,
                                  @RequestParam(required = false) Integer pageSize,
                                  @RequestParam(required = false) String keyword,
                                  @RequestParam(required = false) String type) {
        PageInfo<Novels> page = PageUtil.createPageInfo(pageNum, pageSize, Novels.class);
        page = service.pageCountBr(page, keyword, type);
        json.put("brNovels", page);
        return json;

    }

    /**
     * 分页查询所有小说（字数排行）
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/count/words")
    @ResponseBody
    public JSONObject countReviewsList(@RequestParam(required = false) Integer pageNum,
                                       @RequestParam(required = false) Integer pageSize,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) String type) {
        PageInfo<Novels> page = PageUtil.createPageInfo(pageNum, pageSize, Novels.class);
        page = service.countWordsList(page, keyword, type);
        json.put("wordsNovels", page);
        return json;

    }

    /**
     * 分页查询所有小说（书评数排行）
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/count/reviews")
    @ResponseBody
    public JSONObject countWordsList(@RequestParam(required = false) Integer pageNum,
                                     @RequestParam(required = false) Integer pageSize,
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(required = false) String type) {
        PageInfo<Novels> page = PageUtil.createPageInfo(pageNum, pageSize, Novels.class);
        page = service.countReviewsList(page, keyword, type);
        json.put("reviewsNovels", page);
        return json;

    }

    /**
     * 分页查询所有小说（热度排行）
     * 热度=（收藏数*0.6+书评数*0.4）*100
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/count/popularity")
    @ResponseBody
    public JSONObject countPopularityList(@RequestParam(required = false) Integer pageNum,
                                          @RequestParam(required = false) Integer pageSize,
                                          @RequestParam(required = false) String keyword,
                                          @RequestParam(required = false) String type) {
        PageInfo<Novels> page = PageUtil.createPageInfo(pageNum, pageSize, Novels.class);
        page = service.countPopularityList(page, keyword, type);
        json.put("popularityNovels", page);
        return json;

    }

    /**
     * id查询小说详情（字数，收藏数，热度）最新章节
     * 热度=（收藏数*0.6+书评数*0.4）*100
     *
     * @return
     */
    @GetMapping("/getById")
    @ResponseBody
    public JSONObject getInfo(
                              @RequestParam(required = false) Integer nId) {
        Novels novel = service.getById(nId);
        json.put("novel", novel);
        json.put("chapter", chaptersService.selectNewest(nId));
        return json;

    }

}
