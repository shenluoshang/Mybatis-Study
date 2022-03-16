package com.whz.mybatis.mapper;

import com.whz.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author weihongzhi on 2022/3/16.
 */
public interface EmpMapper {

    /**
     * 查询所有的员工信息
     */
    List<Emp> selectAllEmp();
}
