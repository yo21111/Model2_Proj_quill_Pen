package repository.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.NoticeBean;

public class AdminDao {
	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();

	/////////////////////////////////////////////////////////////////////////////////
	//////////////////////////// 관리자 유효성 검사 시작///////////////////////////////
	// 해당 아이디의 등급 가져오기 (select)
	public boolean isAdmin(String mId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		boolean check = false;
		
		try {
			// 결과가 1이면 true 아니면 false
			// int result = sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
			return check; 
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 관리자 유효성 검사 끝////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////// 공지사항 목록 CRUD 시작 //////////////////////////////
	// 공지사항 목록 가져오기 (select)
	public List<NoticeBean> selectNoticeList(String mId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		try {
			// int result = sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
			return new ArrayList<NoticeBean>(); 
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////// 공지사항 목록 CRUD 끝 ////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// 공지글 CRUD 시작//////////////////////////////////
	// 공지 글 쓰기(insert)
	public int insertNotice(String mId, String title, String content) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return 1; // sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 가져오기(select)
	public NoticeBean selectNotice(String mId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return new NoticeBean(); // sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 수정하기(select)
	public int updateNotice(String mId, int bno, String title, String content) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return 1; // sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 삭제하기(delete)
	public int deleteNotice(String mId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return 1; // sqlSession."매퍼(mapper)에서 설정한 id"(매개변수, ...);
		} finally {
			sqlSession.close();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// 공지글 CRUD 끝 ///////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

}
