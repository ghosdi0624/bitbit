package kr.co.bit.login.vo;

public class LoginVO {
	
	private String id;
	private String pw;
	private String type;
	
	public LoginVO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", pw=" + pw + ", type=" + type + ", toString()=" + super.toString() + "]";
	}
	
	
}
