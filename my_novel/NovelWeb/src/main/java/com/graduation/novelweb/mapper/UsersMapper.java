package com.graduation.novelweb.mapper;


import com.graduation.novelweb.dto.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 用户名查询用户
     * @param name
     * @return
     */
    Users selectByName(@Param("uName") String name);

    List<Users> pageList();
}