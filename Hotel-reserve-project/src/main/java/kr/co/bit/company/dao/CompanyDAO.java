package kr.co.bit.company.dao;

import java.util.List;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

public interface CompanyDAO {

	public void companyform(CompanyVO companyVO);
	public String idcheck(String id);
	public CompanyVO companylogin(CompanyVO companyVO);
	public void secondRegisterHotel(CompanyInfoVO companyInfoVO);
	public void register(CompanyFacilitiesVO facilities);
	public void fileUpload(List<CompanyFileVO> list);
	public void mainFileUpload(CompanyInfoVO companyInfoVO);
	public List<CompanyInfoVO> roomRegisterForm(String id);
	public void roomRegister(RoomVO roomVO);
	public List<CompanyInfoVO> getHotelNames(String id);
	public List<MemberReserveVO> getReservation(List<CompanyInfoVO> companyList);
}
