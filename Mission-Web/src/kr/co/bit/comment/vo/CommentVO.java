package kr.co.bit.comment.vo;

/**
 * ´ñ±Û VO
 * @author User
 *
 */
public class CommentVO {

	private int no;
	private int boardNo;
	private String writer;
	private String content;
	private String regDate;
	
	public CommentVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CommentVO [no=" + no + ", boardNo=" + boardNo + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", toString()=" + super.toString() + "]";
	}
	
	
}
