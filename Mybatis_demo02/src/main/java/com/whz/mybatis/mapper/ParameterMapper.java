package com.whz.mybatis.mapper;

import com.whz.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author weihongzhi on 2022/3/14.
 */
public interface ParameterMapper {

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     */
    User checkLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();
}
