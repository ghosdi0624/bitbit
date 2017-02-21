package kr.co.bit.board.vo;
/**
 * ÆÄÀÏVO
 * @author bit
 *
 */
public class BoardFileVO {
	private int no;
	private String fileName;
	private int boardNo;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "BoardFileVO [no=" + no + ", fileName=" + fileName + ", boardNo=" + boardNo + "]";
	}

}
