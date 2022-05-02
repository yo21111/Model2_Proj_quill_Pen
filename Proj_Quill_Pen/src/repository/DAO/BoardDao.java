package repository.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.DeclBean;
import repository.DTO.WriterBean;

public class BoardDao {
	private static String namespace = "myBatis.mapper.boardMapper.";

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

	// 본인 글 여부 확인하기 (select)
	public String idCheck(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			// 결과가 1이면 true 아니면 false
			return sqlSession.selectOne(namespace + "idCheck", bno);

		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 로그인 유효성 검사 끝////////////////////////////////

	//////////////////////////// 해당 아이디 작가명 찾기 시작////////////////////////////////
	// 작가명 찾기 (select)
	public String findWriter(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			// 결과가 1이면 true 아니면 false
			return sqlSession.selectOne(namespace + "findWriter", uId);

		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 해당 아이디 작가명 찾기 끝////////////////////////////////

	// 작가명 찾기 (select)
	public WriterBean getWriter(String writer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace + "getWriter", writer);

		} finally {
			sqlSession.close();
		}
	}

	//////////////////////////// 게시글 관련 CRUD 시작 //////////////////////////////
	// 글 정보 가져오기
	public BoardBean selectBoard(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace + "selectBoard", bno);
		} finally {
			sqlSession.close();
		}
	}

	// 글 등록하기
	public int insertBoard(BoardBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.insert(namespace + "insertBoard", bean);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	// 글 수정하기
	public int updateBoard(BoardBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.update(namespace + "updateBoard", bean);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	// 글 삭제하기
	public int deleteBoard(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.delete(namespace + "deleteBoard", bno);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	// 조회수 증가
	public int increViewCnt(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.update(namespace + "increViewCnt", bno);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	//////////////////////////// 게시글 관련 CRUD 끝 ////////////////////////////////

	//////////////////////////// 신고하기 시작 //////////////////////////////
	// 신고하기
	public int insertDecl(DeclBean dBean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.insert(namespace + "insertDecl", dBean);
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 신고하기 끝 //////////////////////////////

	//////////////////////////// 댓글 관련 CRUD 시작 //////////////////////////////
	// 댓글 갯수 가져오기
	public int getCmntCnt(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace + "getCmntCnt", bno);
		} finally {
			sqlSession.close();
		}
	}

	// 해당 댓글의 cOrder 찾기 (답글 쓸 때 cOrder)
	public int findcOrder(int cno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace + "findcOrder", cno);
		} finally {
			sqlSession.close();
		}
	}

	// 게시글 댓글중 가장 큰 cOrder찾기 (기본 댓글 쓸 때 cOrder)
	public int findMaxcOrder(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(namespace + "findMaxcOrder", bno);
		} finally {
			sqlSession.close();
		}
	}

	// 댓글 쓰기
	public int insertCmnt(int bno, String writer, String content) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("writer", writer);
		map.put("content", content);

		try {
			return sqlSession.insert(namespace + "insertCmnt", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	// 댓글 수정하기
	public int updateCmnt(int cno, String writer, String content) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("cno", cno);
		map.put("writer", writer);
		map.put("content", content);

		try {
			return sqlSession.update(namespace + "updateCmnt", map);
		} finally {
			sqlSession.close();
		}
	}

	// 댓글 삭제하기
	public int deleteCmnt(int cno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.delete(namespace + "deleteCmnt", cno);
		} finally {
			sqlSession.close();
		}
	}

	// 댓글 목록 불러오기
	public List<CmntBean> selectCmntList(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList(namespace + "selectCmntList", bno);
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 댓글 관련 CRUD 끝 ////////////////////////////////

	//////////////////////////// 구독하기 시작 //////////////////////////////
	// 구독 여부 확인
	public boolean isSubs(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		boolean check = false;

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "isSubs", map);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}

	// 구독하기
	public int subscribe(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		try {
			return sqlSession.insert(namespace + "subscribe", map);
		} finally {
			sqlSession.close();
		}
	}

	// 구독취소 하기
	public int unSubscribe(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		try {
			return sqlSession.delete(namespace + "unSubscribe", map);
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 구독하기 끝 ////////////////////////////////

	//////////////////////////// 추천하기 시작 //////////////////////////////
	// 추천 여부 확인
	public boolean isLike(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		boolean check = false;

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "isLike", map);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}

	// 추천하기
	public int like(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		try {
			return sqlSession.insert(namespace + "like", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	// 추천취소 하기
	public int unLike(String uId, int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		map.put("bno", bno);

		try {
			return sqlSession.delete(namespace + "unLike", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	//////////////////////////// 추천하기 끝 ////////////////////////////////

	//////////////////////////// 작가 글목록 가져오기 시작 //////////////////////////////
	public List<WriterBean> selectWriterList(String writer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList(namespace + "selectWriterList", writer);
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 작가 글목록 가져오기 끝 ///////////////////////////////

}
