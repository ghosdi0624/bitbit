package kr.co.bit.company.vo;

public class CompanyInfoVO {
	
	private int no;
	private String id;
	private String hotelName;
	private String internet;
	private String parking;
	private String breakfast;
	private String introduce;
	private String addr;
	private String oriMainFile;
	private String newMainFile;
	
	public CompanyInfoVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getOriMainFile() {
		return oriMainFile;
	}

	public void setOriMainFile(String oriMainFile) {
		this.oriMainFile = oriMainFile;
	}

	public String getNewMainFile() {
		return newMainFile;
	}

	public void setNewMainFile(String newMainFile) {
		this.newMainFile = newMainFile;
	}

	@Override
	public String toString() {
		return "CompanyInfoVO [no=" + no + ", id=" + id + ", hotelName=" + hotelName + ", internet=" + internet
				+ ", parking=" + parking + ", breakfast=" + breakfast + ", introduce=" + introduce + ", addr=" + addr
				+ ", oriMainFile=" + oriMainFile + ", newMainFile=" + newMainFile + ", toString()=" + super.toString()
				+ "]";
	}

}
