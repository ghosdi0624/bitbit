package kr.co.bit.company.vo;

public class CompanyFacilitiesVO {

	private String id;
	private String basic;
	private String convenience;
	private String service;
	private String internet;
	private String parking;
	private String checkIn;
	private String checkOut;
	private String hotelName;
	
	public CompanyFacilitiesVO(){
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getConvenience() {
		return convenience;
	}

	public void setConvenience(String convenience) {
		this.convenience = convenience;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String toString() {
		return "CompanyFacilitiesVO [id=" + id + ", basic=" + basic + ", convenience=" + convenience + ", service="
				+ service + ", internet=" + internet + ", parking=" + parking + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", hotelName=" + hotelName + ", toString()=" + super.toString() + "]";
	}

}
