package kr.co.bit.member.vo;

public class BoardVO {

	private String id;
	private String name;
	private String password;
	private String phone;
	private String type;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", type=" + type
				+ "]";
	}
	
	
	
	
	
	
}
