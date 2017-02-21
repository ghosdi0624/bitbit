package kr.co.bit.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.company.dao.CompanyDAO;
import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Service
public class CompanySerivceImp implements CompanyService {

	@Autowired
	private CompanyDAO dao;

	@Override
	public void companyform(CompanyVO companyVO) {

		dao.companyform(companyVO);
		
	}

	@Override
	public String idcheck(String id) {
		
		String result = dao.idcheck(id);
		
		return result;
	}

	@Override
	public CompanyVO companylogin(CompanyVO companyVO) {
		
		CompanyVO userVO = dao.companylogin(companyVO);
		
		return userVO;
	}

	@Override
	public void secondRegisterHotel(CompanyInfoVO companyInfoVO) {

		if(companyInfoVO.getInternet()==null){
			companyInfoVO.setInternet("no");
		}
		if(companyInfoVO.getBreakfast()==null){
			companyInfoVO.setBreakfast("no");
		}
		if(companyInfoVO.getParking()==null){
			companyInfoVO.setParking("no");
		}
		dao.secondRegisterHotel(companyInfoVO);
		
	}

	@Override
	public void register(CompanyFacilitiesVO facilities) {

		dao.register(facilities);
		
	}

	@Override
	public void fileUpload(List<CompanyFileVO> list) {
		
		dao.fileUpload(list);
		
	}

	@Override
	public void mainFileUpload(CompanyInfoVO companyInfoVO) {
		
		dao.mainFileUpload(companyInfoVO);
		
	}

	@Override
	public List<CompanyInfoVO> roomRegisterForm(String id) {
		
		List<CompanyInfoVO> list = dao.roomRegisterForm(id);
		
		return list;
	}

	@Override
	public void roomRegister(RoomVO roomVO) {

		dao.roomRegister(roomVO);
		
	}

	@Override
	public List<CompanyInfoVO> getHotelNames(String id) {
		
		List<CompanyInfoVO> companyList = dao.getHotelNames(id);
		
		return companyList;
	}

	@Override
	public List<MemberReserveVO> getReservation(List<CompanyInfoVO> companyList) {

		List<MemberReserveVO> list = dao.getReservation(companyList);
		
		return list;
	}

}
