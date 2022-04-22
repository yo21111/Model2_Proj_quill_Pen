package repository.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.BookBean;
import repository.DTO.DeclBean;
import repository.DTO.NoticeBean;

public class AdminDao {
	private static String namespace = "myBatis.mapper.adminMapper.";
	
	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();

	//////////////////////////// 관리자 유효성 검사 시작///////////////////////////////
	// 해당 아이디의 등급 가져오기 (select)
	public boolean isAdmin(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		boolean check = false;
		
		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace+"isAdmin", uId);
			check = result == 1 ? true : false;

			return check; 
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 관리자 유효성 검사 끝////////////////////////////////
	
	///////////////////////// 공지사항 목록 CRUD 시작 //////////////////////////////
	// 공지사항 목록 가져오기 (select)   pageNo : 페이지 번호
	public List<NoticeBean> selectNoticeList(int pageNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		pageNo = (pageNo-1)*5;
		
		try {
			return sqlSession.selectList(namespace+"selectNoticeList", pageNo); 
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////// 공지사항 목록 CRUD 끝 ////////////////////////////////
	
	///////////////////////////// 공지글 CRUD 시작//////////////////////////////////
	// 공지 글 쓰기(insert)
	public int insertNotice(NoticeBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.insert(namespace+"insertNotice", bean);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 가져오기(select)
	public NoticeBean selectNotice(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne(namespace+"selectNotice", bno);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 수정하기(update)
	public int updateNotice(NoticeBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.update(namespace+"updateNotice", bean);
		} finally {
			sqlSession.close();
		}
	}

	// 공지 글 삭제하기(delete)
	public int deleteNotice(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.delete(namespace+"deleteNotice", bno);
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////////// 공지글 CRUD 끝 ///////////////////////////////////

	///////////////////////////// 신고글 목록 CRUD 시작 /////////////////////////////
	//신고글 목록 가져오기(select)   pageNo : 페이지 번호
	public List<DeclBean> selectDeclList(int pageNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		pageNo = (pageNo-1)*5;
		
		try {
			return sqlSession.selectList(namespace+"selectDeclList", pageNo); 
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////////// 신고글 목록 CRUD 끝 ///////////////////////////////

	
	///////////////////////////// 신고글 CRUD 시작//////////////////////////////////
	// 신고 글 가져오기(select)
	public DeclBean selectDecl(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace+"selectDecl", bno);
		} finally {
			sqlSession.close();
		}
	}

	// 신고 글 삭제하기(delete)
	public int deleteDecl(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.delete(namespace+"deleteDecl", bno);
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////////// 신고글 CRUD 끝 ///////////////////////////////////
	
	///////////////////////////// 책 소개페이지 CRUD 시작//////////////////////////////////
	// 책 소개페이지 글 쓰기(insert)
	public int insertBook(BookBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.insert(namespace+"insertBook", bean);
		} finally {
			sqlSession.close();
		}
	}

	// 책 소개페이지 글 가져오기(select)
	public BookBean selectBook(int bookNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace+"selectBook", bookNo);
		} finally {
			sqlSession.close();
		}
	}

	// 책 소개페이지 수정하기(update)
	public int updateBook(BookBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.update(namespace+"updateBook", bean);
		} finally {
			sqlSession.close();
		}
	}

	// 책 소개페이지 삭제하기(delete)
	public int deleteBook(int bookNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.delete(namespace+"deleteBook", bookNo);
		} finally {
			sqlSession.close();
		}
	}
	///////////////////////////// 책 소개페이지 CRUD 끝 ///////////////////////////////////
}
