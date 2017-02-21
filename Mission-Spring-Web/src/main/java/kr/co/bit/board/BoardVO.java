package kr.co.bit.board;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BoardVO {

	private int no;
	@NotEmpty(message="공백으로 두시면 안됩니다.")
	@Length(min=2, max=20, message="2~20글자 사이로 입력해 주세요")
	private String title;
	@NotEmpty(message="공백으로 두시면 안됩니다.")
	@Pattern(regexp="^[A-Za-z0-9]*$", message="특수기호로 시작하실 수 없습니다.")
	private String writer;
	@NotEmpty(message="공백으로 두시면 안됩니다.")
	private String content;
	private String viewCnt;
	private String regDate;
	private int[] nos;

	public int[] getNos() {
		return nos;
	}

	public String getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}

	public void setNos(int[] nos) {
		this.nos = nos;
	}

	public BoardVO() {

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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}

	

}
