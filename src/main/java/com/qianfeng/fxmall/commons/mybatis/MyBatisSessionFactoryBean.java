package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

/**
 * SessionFactory 封装，饿汉单例模式
 */
@Configuration
public class MyBatisSessionFactoryBean {
//    private static  SqlSessionFactory sqlSessionFactory;
//    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
//
//    private static void initSessionFactory(){
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
//             sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    static{
//        initSessionFactory();
//    }
//
//    @Bean
//    private  static SqlSessionFactory getSqlSessionFactory(){
//        if(sqlSessionFactory==null){
//            initSessionFactory();
//        }
//        return sqlSessionFactory;
//    }
//    @Scope("prototype")
//    @Bean
//    public static SqlSession getSession(){
//        SqlSession session=threadLocal.get();
//        if(session==null){
//            session=sqlSessionFactory.openSession();
//            threadLocal.set(session);
//        }
//        return session;
//    }
//    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
//
//    @Bean
//    public SqlSessionFactory provideSessionFactory() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        return sqlSessionFactory;
//    }
//
//
//    @Scope("prototype")
//    @Bean
//    public SqlSession provideSession(SqlSessionFactory sqlSessionFactory){
//
//        System.out.println(Thread.currentThread().getName());
//
//        SqlSession session1 = threadLocal.get();
//        if (session1 == null){
//            System.out.println("--------------open session-------------");
//            session1 = sqlSessionFactory.openSession();
//            threadLocal.set(session1);
//        }
//
//        return session1;
//    }
}
