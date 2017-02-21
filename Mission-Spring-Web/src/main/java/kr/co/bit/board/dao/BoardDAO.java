package kr.co.bit.board.dao;

import java.util.List;

import kr.co.bit.board.BoardVO;


public interface BoardDAO {

	public List<BoardVO> list();
	public BoardVO detail(int no);
	public void insert(BoardVO boardVO);
	public void delete(int no);
}
