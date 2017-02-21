package kr.co.bit.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.bit.MyConfig;

public class BoardDAO {

	private SqlSession session;
	
	public BoardDAO(){
		session = new MyConfig().getInstance();
		System.out.println(session);
	}

	public void work() {
//		insert();
//		select();
//		selectOne();
//		selectNos();
		selectWhere();
	}
	
	private void selectWhere() {

		BoardVO board = new BoardVO();
		
		board.setTitle("Áö°ã");
		board.setContent("¼ÂÆÃ");
		
		List<BoardVO> list = session.selectList("kr.co.bit.board.BoardDAO.selectWhere", board);
		
		for(BoardVO vo : list){
			System.out.println(vo);
		}
		
	}

	private void selectNos() {
		
		BoardVO board = new BoardVO();
		
		board.setNos(new int[] {12,15,17,18,19});
		
		List<BoardVO> list = session.selectList("kr.co.bit.board.BoardDAO.selectNos", board);
		
		for(BoardVO vo : list){
			System.out.println(vo);
		}
		
	}

	private void selectOne() {
		
		BoardVO board = new BoardVO();
		board.setNo(21);
		
		BoardVO result = session.selectOne("kr.co.bit.board.BoardDAO.selectOneBoard", board);
		
		System.out.println(result);
		
	}

	private void select() {
		
		List<BoardVO> list = session.selectList("kr.co.bit.board.BoardDAO.selectBoard");
		
		for(BoardVO board : list){
			System.out.println(board);
		}
		
	}

	public void insert(){
		
		BoardVO board = new BoardVO();
		
		board.setTitle("hihi");
		board.setWriter("È«±æµ¿");
		board.setContent("Hello~");
		
		session.insert("kr.co.bit.board.BoardDAO.insertBoard", board);
		session.commit();
		
		System.out.println("insert.....");
		
	}
}
