package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DTO.BoardBean;

public interface BbsService {

	// 전체글 목록 선택시
	public List<BoardBean> articleList (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	// (int bno)
	
	// 카테고리 선택시
	public List<BoardBean> category (HttpServletRequest req, HttpServletResponse resp) throws Exception;
	//public BoardBean category (String category) throws Exception;
	
}
