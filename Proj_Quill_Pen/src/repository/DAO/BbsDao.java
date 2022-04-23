package repository.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.BoardBean;

public class BbsDao {
	private static String namespace = "myBatis.mapper.bbsMapper.";
	
	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();

	//////////////////////////// 로그인 유효성 검사 시작///////////////////////////////
	// 로그인 여부 확인하기 (select)
	public boolean isLogin(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		boolean check = false;
		
		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace+"isLogin", uId);
			check = result == 1 ? true : false;

			return check; 
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 로그인 유효성 검사 끝////////////////////////////////
	
	///////////////////////// 전체글 목록 CRUD 시작 //////////////////////////////
	// 전체글 목록 가져오기 (select)   pageNo : 페이지 번호
	public List<BoardBean> selectBbsList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		try {
			return sqlSession.selectList(namespace+"selectBbsList"); 
		} finally {
			sqlSession.close();
		}
	}
	
	// 전체글 목록 가져오기 / 카테고리 선택 시 (select)   pageNo : 페이지 번호
	public List<BoardBean> selectBbsCategory(String category) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList(namespace+"selectBbsCategory", category); 
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////// 전체글 목록 CRUD 끝 ////////////////////////////////
	
	///////////////////////// 검색어가 있을 시 전체글 목록 시작 ////////////////////////////////
	public List<BoardBean> selectBbsSearch(String search) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList(namespace+"selectBbsSearch", search); 
		} finally {
			sqlSession.close();
		}
	}	
	///////////////////////// 검색어가 있을 시 전체글 목록 끝 //////////////////////////////////
	
}
