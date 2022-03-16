package com.whz.mybatis.test;

import com.whz.mybatis.mapper.SQLMapper;
import com.whz.mybatis.pojo.User;
import com.whz.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author weihongzhi on 2022/3/16.
 */
public class SQLMapperTest {

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> users = mapper.getUserByLike("admin");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("4,5,6");
        System.out.println(result);
    }

    @Test
    public void testgetUserByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> users = mapper.getUserByTableName("t_user");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        PreparedStatement ps = connection.prepareStatement("insert",Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();

    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "男", "123@123.com");
        System.out.println(user);
        mapper.insertUser(user);
        System.out.println(user);

    }
}
