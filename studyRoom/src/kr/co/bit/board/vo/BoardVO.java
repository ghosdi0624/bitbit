package kr.co.bit.board.vo;

/**
 * 게시판 Value Object
 * 
 * @author bit
 *
 */
public class BoardVO {

	private int no;//글번호
	private int grpNo;//답변된글번호, 자기자신
	private int grpOder;//답변순서
	private int depth;//답변깊이정도
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;
	private String type;//공지, 일반글 타입

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGrpNo() {
		return grpNo;
	}

	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}

	public int getGrpOder() {
		return grpOder;
	}

	public void setGrpOder(int grpOder) {
		this.grpOder = grpOder;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", grpNo=" + grpNo + ", grpOder=" + grpOder + ", depth=" + depth + ", title="
				+ title + ", writer=" + writer + ", content=" + content + ", viewCnt=" + viewCnt + ", regDate="
				+ regDate + ", type=" + type + "]";
	}

}
