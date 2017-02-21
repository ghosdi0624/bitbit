package kr.co.bit.board.service;

import java.util.List;

import kr.co.bit.board.BoardVO;

public interface BoardService {
	
	public List<BoardVO> list();
	public BoardVO detail(int no);
	public void insert(BoardVO boardVO);
	public void delete(int no);
}
