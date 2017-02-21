package kr.co.bit.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.dao.HotelDAO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	private HotelDAO dao;

	@Override
	public List<CompanyInfoVO> searchHotel() {
		
		List<CompanyInfoVO> list = dao.searchHotel();
		
		return list;
	}

	@Override
	public CompanyFacilitiesVO hotelDatail(String name) {
		
		
		CompanyFacilitiesVO companyFacilitiesVO = dao.hotelDatail(name);
		
		return companyFacilitiesVO;
	}

	@Override
	public CompanyInfoVO getIntro(String name) {
		
		CompanyInfoVO companyInfoVO = dao.getIntro(name);
		
		return companyInfoVO;
	}

	@Override
	public List<CompanyFileVO> getFile(String name) {

		List<CompanyFileVO> list = dao.getFile(name);
		
		return list;
	}

	@Override
	public List<RoomVO> minPrice() {

		List<RoomVO> roomList = dao.minPrice();
		
		return roomList;
	}

	@Override
	public MemberReserveVO checkList(String checkIn, String checkOut) {

		MemberReserveVO checkList = dao.checkList(checkIn, checkOut);
		
		return checkList;
	}
}
