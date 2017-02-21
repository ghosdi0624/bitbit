package kr.co.bit.board.service;

import java.util.List;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardVO;

public class BoardService {

	private BoardDAO dao;
	
	public BoardService(BoardDAO boardDao){
		this.dao = boardDao;
	}
	
	public List<BoardVO> selectAllBoard() {
		
		List<BoardVO> list = dao.selectAllBoard(1, 10);
		
		return list;
	}
	
}
