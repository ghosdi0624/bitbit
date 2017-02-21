package kr.co.bit.hotel.service;

import java.util.List;
import java.util.Map;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

public interface HotelService {

	public List<CompanyInfoVO> searchHotel();
	public CompanyFacilitiesVO hotelDatail(String name);
	public CompanyInfoVO getIntro(String name);
	public List<CompanyFileVO> getFile(String name);
	public List<RoomVO> minPrice();
	public MemberReserveVO checkList(String checkIn, String checkOut);

}
