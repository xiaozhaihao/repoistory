package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

	private static SqlSessionFactory sqlSessionFactory;
	private static final ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	static{
		try {
			//1.ͨ��Resource��ȡMyBatis�������ļ�
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����ļ�ʧ��");
		}
	}
	
	public static SqlSession openSqlSession(){
		SqlSession sqlSession = tl.get();
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
			tl.set(sqlSession);
		}
		return sqlSession;
	}
	
	public static void closeSqlSession(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.close();
		tl.remove();
	}
	
	public static void commit(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.commit();
		closeSqlSession();
	}
	
	public static void rollback(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.rollback();closeSqlSession();
	}
	
	public static Object getMapper(Class clazz){
		return openSqlSession().getMapper(clazz);
	}
}
