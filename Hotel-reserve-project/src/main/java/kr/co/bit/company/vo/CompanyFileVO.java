package kr.co.bit.company.vo;

public class CompanyFileVO {
	
	private int no;
	private String hotelName;
	private String oriFile;
	private String newFile;
	
	public CompanyFileVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}

	public String getNewFile() {
		return newFile;
	}

	public void setNewFile(String newFile) {
		this.newFile = newFile;
	}

	@Override
	public String toString() {
		return "CompanyFileVO [no=" + no + ", hotelName=" + hotelName + ", oriFile=" + oriFile + ", newFile=" + newFile
				+ ", toString()=" + super.toString() + "]";
	}
}
