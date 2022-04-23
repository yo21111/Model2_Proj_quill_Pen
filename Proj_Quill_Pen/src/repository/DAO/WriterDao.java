package repository.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.BoardBean;
import repository.DTO.LikeBean;
import repository.DTO.SubsBean;

public class WriterDao {
	private static String namespace = "myBatis.mapper.writerMapper.";

	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();
	
	//////////////////////////// 목록 가져오기 시작 ////////////////////////////////
	// 해당 작가의 아이디 가져오기
	public String selectWriterId(String writer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace+"selectWriterId", writer);
		} finally {
			sqlSession.close();
		}
	}
	
	// 해당 작가가 쓴 게시물 목록 가져오기
	public List<BoardBean> selectBoardList(String writer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList(namespace+"selectBoardList", writer);
		} finally {
			sqlSession.close();
		}
	}
	
	// 해당 작가가 구독한 작가 목록 가져오기
	public List<SubsBean> selectSubsList(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList(namespace+"selectSubsList", uId);
		} finally {
			sqlSession.close();
		}
	}
	
	// 해당 작가가 추천한 글 목록 가져오기
	public List<LikeBean> selectLikeList(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList(namespace+"selectLikeList", uId);
		} finally {
			sqlSession.close();
		}
	}
	
	//////////////////////////// 목록 가져오기 끝//////////////////////////////////
	
}
