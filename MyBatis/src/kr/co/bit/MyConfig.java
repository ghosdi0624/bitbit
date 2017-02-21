package kr.co.bit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {
	
	private String resource = "mybatis-config.xml";
	private SqlSession session;
	
	public MyConfig(){
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance(){
		return session;
	}
}
