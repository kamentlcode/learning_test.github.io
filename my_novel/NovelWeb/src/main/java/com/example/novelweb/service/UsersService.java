package com.example.novelweb.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novelweb.dto.Users;
import com.example.novelweb.mapper.UsersMapper;

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
	
	public Users select(int uid ){
		Users user = mapper.selectByPrimaryKey(uid);
		user.setFormatTime(sdf.format(user.getUpdateTime()));
		return user;
	}

}
