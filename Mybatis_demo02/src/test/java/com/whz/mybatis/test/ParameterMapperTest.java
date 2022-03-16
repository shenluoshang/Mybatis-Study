package com.whz.mybatis.test;

import com.whz.mybatis.mapper.ParameterMapper;
import com.whz.mybatis.pojo.User;
import com.whz.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weihongzhi on 2022/3/14.
 */
public class ParameterMapperTest {

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        int user = mapper.insertUser(new User(null,"李四","123",23,"男","123@qq.com"));
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.getUserByUsername("admin");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "admin;show tables;";
        Class.forName("");
        Connection connection = DriverManager.getConnection("","root","201314");
//        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = '" + username + "';");
        // 占位符赋值
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ?");
        ps.setString(1,username);
    }
}
