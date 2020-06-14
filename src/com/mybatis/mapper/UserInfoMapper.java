package com.mybatis.mapper;

import com.mybatis.pojo.UserInfo;

// 使用Mapper
public interface UserInfoMapper {
    // 方法名必须和配置文件中的id值一致
    UserInfo findUserInfoById(int id);
}
