package com.mybatis.mapper;

import com.mybatis.pojo.UserInfo;

// 使用Mapper
public interface UserInfoMapper {
    UserInfo findUserInfoById(int id);
}
