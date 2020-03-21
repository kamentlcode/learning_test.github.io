package com.example.novelweb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.example.novelweb.dto.Users;
import com.example.novelweb.service.UsersService;

import net.minidev.json.JSONObject;

/**
 * 用户控制层
 * @author lexed
 *
 */
@RequestMapping("/user")
@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	// 时间格式化工具
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 根据id查询用户
	 */
	@RequestMapping("/query")
	@ResponseBody
	public JSONObject query(Integer uid){
		// 创建json对象
		JSONObject json = new JSONObject();
		Users user = service.select(uid);
		user.setFormatTime(sdf.format(user.getCreateTime()));
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		json.put("user", user);
		return json;
		//return service.select(uid).getuNickname();
		
	}
	
	//只需要加上下面这段即可，注意不能忘记注解
//		@InitBinder
//		public void initBinder(WebDataBinder binder, WebRequest request) {
//			
//			//转换日期
//			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
//		}

}
