package repository.DAO;

import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;

public class HomeDao {
	private static String namespace = "myBatis.mapper.mapper.";

	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();
	
	
	
	
}
