package kr.co.bit.member.vo.reserve;

public class MemberReserveVO {

	private int no;
	private String memberNo;
	private String hotelName;
	private String roomName;
	private String checkIn;
	private String checkOut;
	private int personNum;
	private String price;
	private int status;
	
	public MemberReserveVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberReserveVO [no=" + no + ", memberNo=" + memberNo + ", hotelName=" + hotelName + ", roomName="
				+ roomName + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", personNum=" + personNum + ", price="
				+ price + ", status=" + status + ", toString()=" + super.toString() + "]";
	}
	
}
