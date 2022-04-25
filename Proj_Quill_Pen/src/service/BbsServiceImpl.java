package service;

import java.util.List;

import repository.DAO.BbsDao;
import repository.DTO.BoardBean;

public class BbsServiceImpl implements BbsService {
	BbsDao bDao = new BbsDao();
	
	@Override
	public List<BoardBean> articleList() throws Exception {
		List<BoardBean> bbsList = bDao.selectBbsList();
		return bbsList;
	}

	@Override
	public List<BoardBean> category(String category) throws Exception {
		List<BoardBean> bbsList = bDao.selectBbsCategory(category);
		return bbsList;
	}

	@Override
	public List<BoardBean> search(String search) throws Exception {
		List<BoardBean> bbsList = bDao.selectBbsSearch(search);
		return bbsList;
	}

}
