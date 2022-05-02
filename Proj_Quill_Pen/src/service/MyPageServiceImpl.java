package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.DAO.MyPageDao;
import repository.DTO.BoardBean;
import repository.DTO.LikeBean;
import repository.DTO.MemberBean;
import repository.DTO.SubsBean;
import repository.DTO.WriterBean;

public class MyPageServiceImpl implements MyPageService {
	MyPageDao mDao = new MyPageDao();

	@Override
	public boolean isLogin(String uId) throws Exception {
		boolean result = mDao.isLogin(uId);
		return result;
	}

	@Override
	public boolean writerCheck(String writer) throws Exception {
		boolean result = mDao.writerCheck(writer);
		return result;
	}
	
	@Override
	public boolean modUser(String uName, String uEmail, String uPhone, String uBirth, String writer) throws Exception {
		MemberBean bean = new MemberBean();
		bean.setuName(uName);
		bean.setuEmail(uEmail);
		bean.setuBirth(uBirth);
		bean.setuPhone(uPhone);
		bean.setWriter(writer);
		
		int result = mDao.updateMember(bean);

		return result==1 ? true : false;
	}

	@Override
	public MemberBean userInfo(String uId) throws Exception {
		MemberBean mBean = mDao.selectMember(uId);
		return mBean;
	}

	@Override
	public List<BoardBean> myArticle(String writer) throws Exception {
		List<BoardBean> list = mDao.selectMyBoardList(writer);
		return list;
	}

	@Override
//	public List<WriterBean> subWriter(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	public List<WriterBean> subWriter(String writer) throws Exception {
//		HttpSession session = req.getSession();
//		String uId = (String) session.getAttribute("uId_Session");

		List<SubsBean> list = mDao.selectSubWriterList(writer);
		List<WriterBean> returnList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			SubsBean bean = list.get(i);
			String subWriter = mDao.findWriter(bean.getuId());
			WriterBean wBean = mDao.findWBean(subWriter);

			returnList.add(wBean);
		}

		return returnList;
	}

	@Override
	public List<BoardBean> likeArticle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		String uId = (String) session.getAttribute("uId_Session");

		List<LikeBean> list = mDao.selectLikeBoardList(uId);
		List<BoardBean> returnList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			LikeBean bean = list.get(i);
			BoardBean bBean = mDao.selectBoard(bean.getBno());

			returnList.add(bBean);
		}

		return returnList;
	}

	@Override
	public boolean withdraw(String uId) throws Exception {
		int result = mDao.deleteMember(uId);
		return result == 1 ? true : false;
	}

	@Override
	public WriterBean findWriter(String uId) throws Exception {
		WriterBean wBean = mDao.findWBean(uId);
		return wBean;
	}

	@Override
	public String findId(String writer) throws Exception {
		String uId = mDao.findId(writer);
		return uId;
	}

	@Override
	public int getSubCnt(String writer) throws Exception {
		return mDao.getSubCnt(writer);
	}

	@Override
	public int getLikeCnt(String uId) throws Exception {
		return mDao.getLikeCnt(uId);
	}
	
	@Override
	public boolean selectSubWriter(String uId, String writer) throws Exception {
		SubsBean subsBean = new SubsBean();
		
		subsBean.setuId(uId);
		subsBean.setWriter(writer);
		
		int result = mDao.selectSubWriter(subsBean);
		return result ==1 ? true : false;
		
	}
	
	@Override
	public boolean insertSubWriter(String uId, String writer) throws Exception {
		SubsBean subsBean = new SubsBean();
		
		subsBean.setuId(uId);
		subsBean.setWriter(writer);
		
		int result = mDao.insertSubWriter(subsBean);
		
		return result ==1 ? true : false;
	}
	
	@Override
	public boolean deleteSub (String uId, String writer) throws Exception {
		SubsBean subsBean = new SubsBean();
		
		subsBean.setuId(uId);
		subsBean.setWriter(writer);
		
		int result = mDao.deleteSub(subsBean);
		return result == 1 ? true : false;
	}

}
