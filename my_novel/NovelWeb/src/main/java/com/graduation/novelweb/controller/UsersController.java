package com.graduation.novelweb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import com.graduation.novelweb.dto.Users;
import com.graduation.novelweb.service.UsersService;


/**
 * 用户控制层
 *
 * @author tanlin
 */
@RequestMapping("/user")
@Controller
public class UsersController {
    @Autowired
    private UsersService service;
    // 时间格式化工具
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 创建json对象
    JSONObject json = new JSONObject();

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    @GetMapping("/query")
    @ResponseBody
    public JSONObject query(@RequestParam Integer uid) {
        System.out.println("------------------" + uid);
        Users user = service.select(uid);
        //user.setFormatTime(sdf.format(user.getCreateTime()));
        //user.setFormatTime(sdf.format(user.getUpdateTime()));
        json.put("user", user);
        return json;
        //return service.select(uid).getuNickname();

    }

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                           @RequestParam(required = false) Integer pageSize) {
        PageInfo<Users> page = PageUtil.createPageInfo(pageNum, pageSize, Users.class);
	    page = service.page(page);
        //user.setFormatTime(sdf.format(user.getCreateTime()));
        //user.setFormatTime(sdf.format(user.getUpdateTime()));
        json.put("users", page);
        return json;

    }

    /**
     * 用户注册
     *
     * @param user
     */
    @PostMapping("/register")
    @ResponseBody
    public JSONObject addUser(@RequestBody Users user) {
        Users newUser = service.add(user);
        System.out.println("-----" + user.getuName());
        json.put("user", newUser);
        return json;

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
