package kr.co.bit.company.vo;

public class CompanyVO {

	private String id;
	private String companyName;
	private String password;
	private String addr;
	private String bankName;
	private String bankAccount;
	private String type;
	
	public CompanyVO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CompanyVO [id=" + id + ", companyName=" + companyName + ", password=" + password + ", addr=" + addr
				+ ", bankName=" + bankName + ", bankAccount=" + bankAccount + ", type=" + type + ", toString()="
				+ super.toString() + "]";
	}

}
