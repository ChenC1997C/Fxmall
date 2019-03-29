package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SessionFactory 封装，饿汉单例模式
 */
public class MyBatisSessionFactoryBean {
    private static  SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    private static void initSessionFactory(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
             sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static{
        initSessionFactory();
    }
    private  static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            initSessionFactory();
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        SqlSession session=threadLocal.get();
        if(session==null){
            session=sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
