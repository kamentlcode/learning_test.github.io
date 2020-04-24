package com.graduation.novelweb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduation.novelweb.util.errorcode.MyErrorCode;
import com.graduation.novelweb.util.errorcode.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.novelweb.dto.Users;
import com.graduation.novelweb.mapper.UsersMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public Users select(int id){
		Users user = mapper.selectByPrimaryKey(id);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		//检查用户对象不能为空
		ParamUtil.checkNotNull(user, MyErrorCode.UserCode.USER_NOT_EXIST);
		return user;
	}

	/**
	 * 名称查询用户
	 * @param name
	 * @return
	 */
	public Users selectByName(String name ){
		Users user = mapper.selectByName(name);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return user;
	}

	/**
	 * 查询用户列表
	 * @param
	 * @return
	 */
	public PageInfo<Users> page(PageInfo<Users> page){
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Users> users = mapper.pageList();
		page =((Page<Users>)users).toPageInfo();
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return page;

	}

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public Users add(Users user){
		ParamUtil.checkNotNull(user, MyErrorCode.UserCode.USER_NOT_EXIST);
		ParamUtil.checkNotBlank(user.getuName(), MyErrorCode.UserCode.USER_NAME_NOTBLANK);
		ParamUtil.checkNotBlank(user.getuNickname(), MyErrorCode.UserCode.USER_NICKNAME_NOTBLANK);
		ParamUtil.checkNotBlank(user.getuPassword(), MyErrorCode.UserCode.USER_PASSWORD_NOTBLANK);

		user.setCreateTime(now);
		user.setUpdateTime(now);
		user.setuPermission(0);
		//Users u = mapper.selectByPrimaryKey(1);

		mapper.insert(user);
		return user;
	}

	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public boolean delete(Integer id){
		boolean result = (mapper.deleteByPrimaryKey(id) > 1);
		//user.setFormatTime(sdf.format(user.getUpdateTime()));
		return result;
	}

}
