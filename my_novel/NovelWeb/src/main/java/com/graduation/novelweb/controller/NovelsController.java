package com.graduation.novelweb.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 小说主题控制层
 * @author tanlin
 *
 */
@RequestMapping("/novel")
@Controller
public class NovelsController {

	/**
	 *
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


	@RequestMapping("/add")
	@ResponseBody
	public void add(){
		System.out.println("小说新增接口");
	}

}
