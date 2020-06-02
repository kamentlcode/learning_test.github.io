package com.graduation.novelweb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.util.pagehelper.PageUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import com.graduation.novelweb.dto.Users;
import com.graduation.novelweb.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
    // 用户登录状态
    private HashMap<HttpSession, Users> userSession = new HashMap<HttpSession, Users>();

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
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public JSONObject page(@RequestParam(required = false) Integer pageNum,
                           @RequestParam(required = false) Integer pageSize) {
        PageInfo<Users> page = PageUtil.createPageInfo(pageNum, pageSize, Users.class);
	    page = service.page(page);

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

        json.put("registerStatue", service.add(user));
        return json;

    }

    /**
     * 用户注册
     *
     * @param user
     */
    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestBody Users user, HttpServletRequest request) {

        json.put("loginStatue", service.login(user,request));
        return json;

    }

    /**
     * 从session中获取用户信息
     * @param request
     */
    @GetMapping("/session/in")
    @ResponseBody
    public JSONObject in(HttpServletRequest request) {
        // 获取当前session
        System.out.println("……从session中获取用户信息……");
        json.put("session",service.in(request));

        return json;

    }

    /**
     * 用户退出登录
     * @param request
     */
    @GetMapping("/session/out")
    @ResponseBody
    public JSONObject out(HttpServletRequest request) {
        // 获取当前session
        System.out.println("……从session中移除用户信息……");
        json.put("session",service.out(request));
        return json;

    }

}
