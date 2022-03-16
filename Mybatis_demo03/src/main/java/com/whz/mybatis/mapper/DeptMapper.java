package com.whz.mybatis.mapper;

import com.whz.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author weihongzhi on 2022/3/16.
 */
public interface DeptMapper {

    /**
     * 通过分布查询查询员工以及员工所对应的部门信息
     * 分布查询第二步：通过did查询员工所对应的部门
     */
    Dept selectEmpAndDeptByStepTwo(@Param("did") Integer did);
}
