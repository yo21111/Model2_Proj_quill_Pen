package repository.DAO;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatis;
import repository.DTO.MemberBean;

public class MemberDao {
	private static String namespace = "myBatis.mapper.memberMapper.";

	SqlSessionFactory sqlSessionFactory = MyBatis.getSqlSessionFactory();

	//////////////////////////// 아이디 중복확인 시작///////////////////////////////
	public boolean idCheck(String uId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		boolean check = false;

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "idCheck", uId);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 아이디 중복확인 끝////////////////////////////////

	//////////////////////////// 작가명 중복확인 시작///////////////////////////////
	public boolean writerCheck(String writer) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		boolean check = false;

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "writerCheck", writer);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 작가명 중복확인 끝////////////////////////////////

	//////////////////////////// 로그인 정보 확인 ///////////////////////////////
	public boolean login(String uId, String uPw) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		boolean check = false;

		MemberBean bean = new MemberBean();
		bean.setuId(uId);
		bean.setuPw(uPw);

		try {
			// 결과가 1이면 true 아니면 false
			int result = sqlSession.selectOne(namespace + "login", bean);
			check = result == 1 ? true : false;

			return check;
		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 로그인 중복확인 끝////////////////////////////////

	//////////////////////////// 회원가입 시작///////////////////////////////
	public int registerMember(MemberBean bean) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.insert(namespace + "registerMember", bean);

		} finally {
			sqlSession.close();
		}
	}
	//////////////////////////// 회원가입 끝////////////////////////////////

	//////////////////////////// 아이디 찾기 시작 ////////////////////////////////
	// 이름, 휴대폰 번호 받아서 아이디 찾기
	public String findId(String uName, String uPhone) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, String> map = new HashMap<>();
		map.put("uName", uName);
		map.put("uPhone", uPhone);

		try {
			return sqlSession.selectOne(namespace + "findId", map);

		} finally {
			sqlSession.close();
		}
	}

	//////////////////////////// 아이디 찾기 끝 //////////////////////////////////

	//////////////////////////// 비밀번호 찾기 시작 ////////////////////////////////
	// 아이디, 휴대폰 번호 받아서 존재하는 유저인지 확인하기
	public int isMember(String uId, String uPhone) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Map<String, String> map = new HashMap<>();
		map.put("uId", uId);
		map.put("uPhone", uPhone);

		try {
			String result = sqlSession.selectOne(namespace + "isMember", map);
			int res = Integer.parseInt(result);
			return res;

		} finally {
			sqlSession.close();
		}
	}

	// 해당 아이디 비밀번호 변경하기
	public int updatePw(String uId, String uPw) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();


		Map<String, String> map = new HashMap<>();
		map.put("uId", uId);
		map.put("uPw", uPw);


		try {
			return sqlSession.update(namespace + "updatePw", map);

		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	//////////////////////////// 비밀번호 찾기 끝 //////////////////////////////////

}
