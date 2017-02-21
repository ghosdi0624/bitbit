package kr.co.bit.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.board.BoardVO;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> list() {
		
		List<BoardVO> list = sqlSessionTemplate.selectList("kr.co.bit.board.BoardDAO.selectBoard");
		
		return list;
	}

	@Override
	public BoardVO detail(int no) {
		
		BoardVO board = sqlSessionTemplate.selectOne("kr.co.bit.board.BoardDAO.selectBoardByNo", no);
		
		return board;
	}

	@Override
	public void insert(BoardVO boardVO) {

		sqlSessionTemplate.insert("kr.co.bit.board.BoardDAO.insertBoard", boardVO);
		
	}

	@Override
	public void delete(int no) {

		sqlSessionTemplate.delete("kr.co.bit.board.BoardDAO.deleteBoard", no);
		
	}

}
