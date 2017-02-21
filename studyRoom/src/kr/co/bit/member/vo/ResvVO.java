package kr.co.bit.member.vo;

public class ResvVO {
	
	private int rsv_no;
	private String member_id;
	private String room_name;
	private int persons_num;
	private int status;
	private String day;
	private int time;
	
	public int getRsv_no() {
		return rsv_no;
	}
	public void setRsv_no(int rev_no) {
		this.rsv_no = rev_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getPersons_num() {
		return persons_num;
	}
	public void setPersons_num(int persons_num) {
		this.persons_num = persons_num;
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
		return "ResvVO [rev_no=" + rsv_no + ", member_id=" + member_id + ", room_name=" + room_name + ", persons_num="
				+ persons_num + ", status=" + status + ", day=" + day + ", time=" + time + "]";
	}
	
	
	
	
}
