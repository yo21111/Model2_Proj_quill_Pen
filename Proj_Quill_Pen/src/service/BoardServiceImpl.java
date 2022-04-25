package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DAO.BoardDao;
import repository.DTO.BoardBean;
import repository.DTO.DeclBean;

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
			result = uId.equals(bDao.idCheck(bno));
		}
		
		return result;
	}

	@Override
	public String findWriter(String uId) throws Exception {
		String writer = bDao.findWriter(uId);
		return writer;
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
		
		if (uId.equals(bDao.idCheck(bno))) {
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

}
