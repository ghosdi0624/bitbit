package kr.co.bit.board.vo;

public class BoardVo {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;
	
	// 기본생성자 : alt + shift + s --> c
	// 매개변수 가지는 생성자 : alt + shift + s --> o
	// getter/setter 메소드 : alt + shift + s --> r
	// 오버라이드 : alt + shift + s --> v
	// toString() 메소드 : alt + shift + s --> s
	public BoardVo() {
		
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	
	
	
}
