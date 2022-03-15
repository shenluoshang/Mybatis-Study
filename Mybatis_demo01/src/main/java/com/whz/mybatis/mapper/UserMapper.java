package com.whz.mybatis.mapper;

import com.whz.mybatis.pojo.User;

import java.util.List;

/**
 * @author weihongzhi on 2022/3/8.
 *
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除指定用户信息
     */
    void deleteUser();

    User getUserById(int id);

    /**
     * 查询所有用户
     */
    List<User> selectAllUser();
}
