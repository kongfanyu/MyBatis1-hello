package com.shop.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	//重量级 一个应用只创建一次
	private static SqlSessionFactory sessionFactory;

	static{
		String config = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSqlSession(){
		//session非线程安全，每次创建，关闭
		SqlSession session = sessionFactory.openSession();//true自动提交
		return session;
	}
	public static void closesSession(SqlSession session ){
		if (session !=null) {
			session.close();
		}
	}
}
