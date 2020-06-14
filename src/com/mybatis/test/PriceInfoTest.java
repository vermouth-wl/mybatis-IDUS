package com.mybatis.test;

import com.mybatis.pojo.PriceInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PriceInfoTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    // 创建init()方法，使用@Before注解
    @Before
    public void init() {
        // 创建配置文件
        String resource = "mybatis-config.xml";
        // 创建InputStream
        InputStream inputStream;

        try {
            // 得到配置文件流
            inputStream = Resources.getResourceAsStream(resource);
            // 从配置文件中获取配置信息，创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获取sqlSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建测试方法
    @Test
    public void findPriceInfoByItemCode() {
        PriceInfo priceInfo = sqlSession.selectOne("findPriceInfoByItemCode", "X01");
        System.out.println(priceInfo);
    }

    // 创建destroy()方法，使用@After注解
    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭事务
        sqlSession.close();
    }
}