package kr.co.bit.hotel.vo;

public class RoomVO {
	
	private int no;
	private String hotelName;
	private String roomName;
	private int minCapacity;
	private int maxCapacity;
	private String price;
	private String oriRoomFile;
	private String newRoomFile;
	private String introduce;
	
	public RoomVO(){
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String gethotelName() {
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

	public int getMinCapacity() {
		return minCapacity;
	}

	public void setMinCapacity(int minCapacity) {
		this.minCapacity = minCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOriRoomFile() {
		return oriRoomFile;
	}

	public void setOriRoomFile(String oriRoomFile) {
		this.oriRoomFile = oriRoomFile;
	}

	public String getNewRoomFile() {
		return newRoomFile;
	}

	public void setNewRoomFile(String newRoomFile) {
		this.newRoomFile = newRoomFile;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	@Override
	public String toString() {
		return "RoomVO [no=" + no + ", hotelName=" + hotelName + ", roomName=" + roomName + ", minCapacity="
				+ minCapacity + ", maxCapacity=" + maxCapacity + ", price=" + price + ", introduce=" + introduce
				+ ", oriRoomFile=" + oriRoomFile + ", newRoomFile=" + newRoomFile + ", toString()=" + super.toString()
				+ "]";
	}
	
}
