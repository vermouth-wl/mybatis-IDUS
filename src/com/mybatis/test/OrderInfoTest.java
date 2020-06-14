package com.mybatis.test;

import com.mybatis.pojo.OrderInfo;
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

import static org.junit.Assert.*;

public class OrderInfoTest {

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

            // 得到配置流
            inputStream = Resources.getResourceAsStream(resource);

            // 从配置流中获取会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 启用会话
            sqlSession = sqlSessionFactory.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 测试方法
    @Test
    public void findAllOrder() {
        List<OrderInfo> orders = sqlSession.selectList("findAllOrder");
        // 输出订单信息
        orders.forEach(e -> System.out.println(e));
    }

    @Test
    public void findOrderByOrderCode() {
        OrderInfo order = sqlSession.selectOne("findOrderByOrderCode", "00001");
        System.out.println(order);
    }

    @Test
    public void findOrderByOrderNameLike() {
        List<OrderInfo> orders = sqlSession.selectList("findOrderByOrderNameLike", "华");
        orders.forEach(e -> System.out.println(e));
    }

    @Test
    public void addOrder() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder_code("00003");
        orderInfo.setOrder_name("华为P40 Pro 128G");
        orderInfo.setOrder_status(1);

        // 返回受影响的行数
        int result = sqlSession.insert("addOrder", orderInfo);
        if (result > 0) {
            System.out.println("插入成功");
            System.out.println("--------正在执行全量数据查询-------");
            findAllOrder();
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void updateOrder() {
        // 查询需修改的记录
        OrderInfo order = sqlSession.selectOne("findOrderById", 3);

        // 执行修改方法
        order.setOrder_name("华为P40 Pro 256G");

        // 返回受影响的条数
        int result = sqlSession.update("updateOrder", order);
        if (result > 0) {
            System.out.println("更新成功");
            System.out.println("--------正在执行全量数据查询-------");
            findAllOrder();
        } else {
            System.out.println("更新失败");
        }

    }

    @Test
    public void deleteOrder() {
        int result = sqlSession.delete("deleteOrder", 3);
        if (result > 0) {
            System.out.println("删除成功");
            System.out.println("--------正在执行全量数据查询-------");
            findAllOrder();
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