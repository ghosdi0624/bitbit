package kr.co.bit.board.vo;

/**
 * ´ñ±ÛVO
 * 
 * @author bit
 *
 */
public class BoardCommentVO {
	private int no;
	private String writer;
	private String coment;
	private int boardNo;
	private String regDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardCommentVO [no=" + no + ", writer=" + writer + ", coment=" + coment + ", boardNo=" + boardNo
				+ ", regDate=" + regDate + "]";
	}

}
