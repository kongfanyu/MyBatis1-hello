package com.shop.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.shop.entity.Emp;
import com.shop.util.MyBatisUtil;

public class MyBatisTest1 {
	
	@Test
	public void test6() throws IOException{
		SqlSession session = MyBatisUtil.getSqlSession();
		String statement = "com.shop.dao.EmpMapper"+".updateEname";
		Emp emp = new Emp();
		emp.setId(1);
		emp.setEname("小昭");
		int result =  session.update(statement, emp);
		System.out.println("受影响的行数:"+result);
		session.commit();
		MyBatisUtil.closesSession(session);
	}
	@Test
	public void test5() throws IOException{
		SqlSession session = MyBatisUtil.getSqlSession();
		String statement = "com.shop.dao.EmpMapper"+".updateEmp";
		Emp emp = new Emp(1,"小昭", new Date(), "圣女",8888.66, 2);
		int result =  session.update(statement, emp);
		System.out.println("受影响的行数:"+result);
		session.commit();
		MyBatisUtil.closesSession(session);
	}
	
	@Test
	public void test4() throws IOException{
		SqlSession session = MyBatisUtil.getSqlSession();
		String statement = "com.shop.dao.EmpMapper"+".deleteEmp";
		int result =  session.delete(statement, 3);
		System.out.println("受影响的行数:"+result);
		session.commit();
		MyBatisUtil.closesSession(session);
	}
	
	@Test
	public void test3() throws IOException{
		SqlSession session = MyBatisUtil.getSqlSession();
		String statement = "com.shop.dao.EmpMapper"+".saveEmp";
		Emp emp = new Emp(null,"张无忌", new Date(), "教主",1234.56, 1);
		int result =  session.insert(statement, emp);
		System.out.println("获取的主键:"+emp.getId());
		System.out.println("受影响的行数:"+result);
		session.commit();
		MyBatisUtil.closesSession(session);
	}
	
	@Test
	public void test2() throws IOException{
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		String statement = "com.shop.dao.EmpMapper"+".selectEmp";
		Emp emp =  session.selectOne(statement , 1);
		System.out.println(emp);
		session.close();
	}
	@Test
	public void test1() throws IOException{
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		System.out.println(session);
	}
}
