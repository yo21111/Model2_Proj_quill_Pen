package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.BoardDao;
import repository.DTO.BoardBean;
import repository.DTO.CmntBean;
import repository.DTO.DeclBean;
import repository.DTO.WriterBean;

public class BoardServiceImpl implements BoardService {
	BoardDao bDao = new BoardDao();
	
	@Override
	public boolean isLogin(String uId, int bno) throws Exception {
		
		boolean result = false;
		
		if(bno == 0) {
		// insert인 경우
			result = bDao.isLogin(uId);
		} else {
			result = bDao.isLogin(uId);
			String writer = bDao.idCheck(bno);
			
			
			if (writer != null && writer.equals(bDao.findWriter(uId))) {
				result = true;
			} else {
				result = false;
			}
		}
		
		return result;
	}

	@Override
	public String findWriter(String uId) throws Exception {
		String writer = bDao.findWriter(uId);
		return writer;
	}
	
	
	@Override
	public WriterBean getWriter(String writer) throws Exception {
		WriterBean writerBean = bDao.getWriter(writer);
		return writerBean;
	}

	@Override
	public boolean write(BoardBean bBean) throws Exception {
		int result = bDao.insertBoard(bBean);
		return result == 1 ? true : false;
	}

	@Override
	public boolean update(BoardBean bBean) throws Exception {
		int result = bDao.updateBoard(bBean);
		return result == 1 ? true : false;
	}

	@Override
	public boolean delete(String uId, int bno) throws Exception {
		boolean result = false;
		
		String findWriter = bDao.findWriter(uId);
		String idCheckWriter = bDao.idCheck(bno);
		
		
		if (findWriter.equals(idCheckWriter)) {
			int res = bDao.deleteBoard(bno);
			result = res==1 ? true : false;
		}
		
		return result;
	}

	@Override
	public BoardBean read(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		BoardBean bBean = bDao.selectBoard(bno);
		return bBean;
	}

	@Override
	public boolean report(DeclBean dBean) throws Exception {
		int result = bDao.insertDecl(dBean);
		
		return result==1 ? true : false;
	}

	@Override
	public int getCmntCnt(int bno) throws Exception {
		int cmntCnt = bDao.getCmntCnt(bno);
		return cmntCnt;
	}

	@Override
	public List<CmntBean> selectCmntList(int bno) throws Exception {
		List<CmntBean> cmntList = bDao.selectCmntList(bno);
		return cmntList;
	}

	@Override
	public boolean isLike(String uId, int bno) throws Exception {
		boolean res = bDao.isLike(uId, bno);
		return res;
	}

	@Override
	public void like(String uId, int bno) throws Exception {
		bDao.like(uId, bno);
	}

	@Override
	public void unLike(String uId, int bno) throws Exception {
		bDao.unLike(uId, bno);
	}
	
	
}
