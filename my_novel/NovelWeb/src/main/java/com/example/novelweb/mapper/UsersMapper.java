package com.example.novelweb.mapper;

import org.springframework.stereotype.Repository;

import com.example.novelweb.dto.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Users record);

    Users selectByPrimaryKey(Integer uId);

    int updateByPrimaryKey(Users record);
}