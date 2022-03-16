package com.whz.mybatis.mapper;

import com.whz.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weihongzhi on 2022/3/16.
 */
public interface EmpMapper {

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp selectEmpAndDept(@Param("eid") Integer eid);
    /**
     * 查询所有的员工信息
     */
    List<Emp> selectAllEmp();

    /**
     * 通过分布查询查询员工以及员工所对应的部门信息
     * 分布查询第一步：查询员工信息
     */
    Emp selectEmpAndDeptByStepOne(@Param("eid") Integer eid);
}
