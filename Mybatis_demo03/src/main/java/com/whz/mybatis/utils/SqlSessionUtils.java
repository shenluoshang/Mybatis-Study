package com.whz.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author weihongzhi on 2022/3/16.
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
