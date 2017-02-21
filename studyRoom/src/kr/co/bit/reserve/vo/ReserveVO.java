package kr.co.bit.reserve.vo;

public class ReserveVO {
	
	private int rsvNo;
	private String memberId;
	private String roomName;
	private int personsNum;
	private int status;
	private String day;
	private int time;
	
	public ReserveVO(){
		
	}

	public int getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getPersonsNum() {
		return personsNum;
	}

	public void setPersonsNum(int personsNum) {
		this.personsNum = personsNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ReserveVO [rsvNo=" + rsvNo + ", memberId=" + memberId + ", roomName=" + roomName + ", personsNum="
				+ personsNum + ", status=" + status + ", day=" + day + ", time=" + time + ", toString()="
				+ super.toString() + "]";
	}

	
}
