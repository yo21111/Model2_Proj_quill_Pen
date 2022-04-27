package service;

import repository.DAO.MemberDao;
import repository.DTO.MemberBean;

public class MemberServiceImpl implements MemberService {
	MemberDao mDao = new MemberDao();
	
	@Override
	public boolean idChk(String uId) throws Exception {
		boolean result = mDao.idCheck(uId);
		return result;
	}

	@Override
	public boolean writerChk(String writer) throws Exception {
		boolean result = mDao.writerCheck(writer);
		return result;
	}

	@Override
	public boolean loginChk(String uId, String uPw) throws Exception {
		boolean result = mDao.login(uId, uPw);
		return result;
	}

	@Override
	public boolean validator(MemberBean bean) throws Exception {
		String uId = bean.getuId();
		String uPw = bean.getuPw();
		String uName = bean.getuName();
		String uPhone = bean.getuPhone();
		String writer = bean.getWriter();
		
		if (uId == null || uPw == null || uName == null || uPhone == null || writer ==null) {
			return false;
		} else if (uPhone.length() != 11) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean newMem(MemberBean bean) throws Exception {
		int result = mDao.registerMember(bean);
		return result == 1? true : false;
	}

	@Override
	public String findId(String uName, String uPhone) throws Exception {
		String id = mDao.findId(uName, uPhone);
		return id;
	}

	@Override
	public boolean findPw(String uId, String uPhone) throws Exception {
		int isMem = mDao.isMember(uId, uPhone);
		return isMem == 1 ? true : false;
	}

	@Override
	public boolean changePw(String uId, String uPw) throws Exception {
		int result = mDao.updatePw(uId, uPw);
		return result == 1 ? true : false;
	}

}
