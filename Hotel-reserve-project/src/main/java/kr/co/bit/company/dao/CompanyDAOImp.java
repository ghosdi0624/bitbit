package kr.co.bit.company.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Repository
public class CompanyDAOImp implements CompanyDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void companyform(CompanyVO companyVO) {

		sqlSessionTemplate.insert("kr.co.bit.company.CompanyDAO.insertCompany", companyVO);

	}

	@Override
	public String idcheck(String id) {
		
		String result = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyDAO.selectIdcheck", id);

		return result;
	}

	@Override
	public CompanyVO companylogin(CompanyVO companyVO) {

		CompanyVO userVO = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyDAO.selectcompany", companyVO);
		
		return userVO;
	}

	@Override
	public void secondRegisterHotel(CompanyInfoVO companyInfoVO) {
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyInfoDAO.insertinfo", companyInfoVO);
		
	}

	@Override
	public void register(CompanyFacilitiesVO facilities) {
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyFacilitiesDAO.insertfacilities", facilities);
		
	}

	@Override
	public void fileUpload(List<CompanyFileVO> list) {
		
		for(CompanyFileVO companyFileVO : list){
			sqlSessionTemplate.insert("kr.co.bit.company.CompanyDAO.insertFile", companyFileVO);
			System.out.println(companyFileVO);
		}
	}

	@Override
	public void mainFileUpload(CompanyInfoVO companyInfoVO) {
		
		System.out.println("¡¯¿‘"+companyInfoVO);
		sqlSessionTemplate.update("kr.co.bit.company.CompanyInfoDAO.updateOriMainFile", companyInfoVO);
		sqlSessionTemplate.update("kr.co.bit.company.CompanyInfoDAO.updateNewMainFile", companyInfoVO);
		
	}

	@Override
	public List<CompanyInfoVO> roomRegisterForm(String id) {
		
		List<CompanyInfoVO> list = sqlSessionTemplate.selectList("kr.co.bit.company.CompanyInfoDAO.selectById", id);
		
		return list;
	}

	@Override
	public void roomRegister(RoomVO roomVO) {
		
		sqlSessionTemplate.insert("kr.co.bit.hotel.RoomDAO.insertRoom", roomVO);
		
	}

	@Override
	public List<CompanyInfoVO> getHotelNames(String id) {
		
		List<CompanyInfoVO> companyList = sqlSessionTemplate.selectList("kr.co.bit.company.CompanyInfoDAO.selectHotelNames", id);
		
		return companyList;
	}

	@Override
	public List<MemberReserveVO> getReservation(List<CompanyInfoVO> companyList) {
		
		List<MemberReserveVO> list = sqlSessionTemplate.selectList("kr.co.bit.reserve.MemberReserveDAO.selectReservation", companyList);
		
		return list;
	}


}
