package com.graduation.novelweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.novelweb.dto.Users;
import com.graduation.novelweb.mapper.UsersMapper;
import org.springframework.util.StringUtils;

/**
 * 用户业务处理层
 * @author tanlin
 *
 */
@Service
public class UsersService {
	@Autowired
	private UsersMapper mapper;
	// 时间格式化工具
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Date now = new Date();

	Random random = new Random();
	int id = random.nextInt(99999);

	/**
	 * id查询用户
	 * @param id
	 * @return
	 */
	public Users select(int id ){
		Users user = mapper.selectByPrimaryKey(id);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return user;
	}

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public Users add(Users user) throws Exception {
		user.setCreateTime(now);
		user.setUpdateTime(now);
		user.setuPermission(0);
		System.out.println("======================"+user.getuName());
		Users u = mapper.selectByPrimaryKey(1);
		Users us = mapper.selectByName(user.getuName());
		boolean nameIsExist = (u!=null);
		if (nameIsExist){
			throw new Exception("抛出异常，用户名不能重复");
		}



		System.out.println("---------"+user.getuName()+user.getuNickname());
		mapper.insert(user);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		System.out.println("---------"+user.getuId());
		return user;
	}

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	public Users edit(Users user){
		Users oldUser = mapper.selectByPrimaryKey(user.getuId());

		//逐一赋值
		oldUser.setuNickname(user.getuNickname());
		oldUser.setuPassword(user.getuPassword());
		oldUser.setuPermission(user.getuPermission());
		oldUser.setUpdateTime(now);

		mapper.updateByPrimaryKey(oldUser);

		return oldUser;
	}

	/**
	 * id删除用户
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id){
		boolean result = (mapper.deleteByPrimaryKey(id) > 1);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return result;
	}

}
