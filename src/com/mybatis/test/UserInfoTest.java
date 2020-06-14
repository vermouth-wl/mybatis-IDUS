package com.mybatis.test;

import com.mybatis.mapper.UserInfoMapper;
import com.mybatis.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserInfoTest {
    // 创建会话工厂
    private SqlSessionFactory sqlSessionFactory;
    // 创建会话
    private SqlSession sqlSession;

    @Before
    public void init() {
        // 读取mybatis配置文件
        String resource = "mybatis-config.xml";
        // 创建文件输入流
        InputStream inputStream;

        try {
            // 得到配置文件流
            inputStream  = Resources.getResourceAsStream(resource);
            // 从配置文件流中获取会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 通过会话工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建查询方法
    @Test
    public void testFindUserInfoById() {
        // 通过SqlSession执行映射结果，并返回结果集
        UserInfo userInfo = sqlSession.selectOne("findUserInfoById", 1);
        System.out.println(userInfo);
    }

    // 通过Mapper接口执行Sql查询
    @Test
    public void findUserInfoById() {
        // 获得UserInfoMapper接口的代理对象
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 直接调用接口方法并传参
        UserInfo userInfo = userInfoMapper.findUserInfoById(1);
        System.out.println(userInfo);
    }

    @Test
    public void testFindUserInfoByUserName() {
        // 模糊查询
        List<UserInfo> userInfos = sqlSession.selectList("findUserInfoByUserName", "王");
        // forEach()方法输出
        userInfos.forEach(e -> System.out.println(e));
    }

    @Test
    public void testFindAllUser() {
        // 通过SqlSession执行映射结果，并返回结果集
        List<UserInfo> userInfoList = sqlSession.selectList("findUserInfo");
        // forEach()输出
        userInfoList.forEach(e -> System.out.println(e));
    }

    @Test
    public void testAddUserInfo() {
        // 添加用户
        UserInfo userInfo = new UserInfo();
        // 向userInfo对象中添加数据
        userInfo.setUser_code("X001");
        userInfo.setUser_name("维维");
        userInfo.setPassword("vermouth");
        userInfo.setName("肖维");
        userInfo.setPhone("15736227795");
        userInfo.setEmail("1575968301@qq.com");
        userInfo.setStatus(1);
        userInfo.setAddress("重庆市涪陵区");
        // 执行结果返回条数
        int result = sqlSession.insert("addUserInfo", userInfo);
        if (result > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testUpdateUserInfo() {
        // 实例化用户对象
        UserInfo userInfo = sqlSession.selectOne("findUserInfoByUserCode", "Y001");
        userInfo.setPhone("13658469115");

        // 执行update()方法, 返回受影响结果条数
        int result = sqlSession.update("updateUserInfo", userInfo);
        if (result > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDeleteUserInfoById() {
        // 实例化用户对象
        UserInfo userInfo = new UserInfo();
        // 执行delete()方法，该方法返回受影响的条数
        int result = sqlSession.delete("deleteUserInfoById", 6);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }
}