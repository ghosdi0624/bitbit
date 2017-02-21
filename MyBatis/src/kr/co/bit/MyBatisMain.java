package kr.co.bit;

import kr.co.bit.board.BoardDAO;

public class MyBatisMain {

	public static void main(String[] args) {
	
		BoardDAO dao = new BoardDAO();
		
		dao.work();
	}

}
