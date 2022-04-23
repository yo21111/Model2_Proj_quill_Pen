package repository.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.BookBean;

public class BookDao {
	private static String namespace = "myBatis.mapper.bookMapper.";

	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();
	
	//////////////////////////// 로그인 유효성 검사 시작///////////////////////////////
	// 로그인 여부 확인하기 (select)
	public boolean isLogin(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		boolean check = false;

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "isLogin", uId);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 로그인 유효성 검사 끝////////////////////////////////
	
	//////////////////////////// 전체 책목록 가져오기 시작//////////////////////////////
	public List<BookBean> selectBookList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		
		try {
			return sqlSession.selectList(namespace+"selectBookList");

		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 전체 책목록 가져오기 끝////////////////////////////////
	
	//////////////////////////// 특정 책정보 가져오기 시작//////////////////////////////
	public BookBean selectBook(int bookNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		
		try {
			return sqlSession.selectOne(namespace+"selectBook", bookNo);

		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 특정 책정보 가져오기 끝////////////////////////////////

}
