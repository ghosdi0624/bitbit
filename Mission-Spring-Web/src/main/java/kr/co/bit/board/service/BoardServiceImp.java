package kr.co.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.board.BoardVO;
import kr.co.bit.board.dao.BoardDAO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> list() {
		
		List<BoardVO> list = dao.list();
		
		return list;
	}

	@Override
	public BoardVO detail(int no) {
		
		BoardVO board = dao.detail(no);
		
		return board;
	}

	@Override
	public void insert(BoardVO boardVO) {
		
		dao.insert(boardVO);
		
	}

	@Override
	public void delete(int no) {
		
		dao.delete(no);
		
	}

	
	
}
