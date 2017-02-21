package kr.co.bit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/**/*.xml"})
public class DBTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	@Test
	public void 멤버회원가입() throws Exception{
		MemberVO member = new MemberVO();
		member.setId("ghosdi0624");
		member.setPassword("1234");
		member.setEmail("ghosdi0624@naver.com");
		member.setName("홍순일");
		member.setTel1("010");
		member.setTel2("9700");
		member.setTel3("2782");
		sqlSessionTemplate.insert("kr.co.bit.member.MemberDAO.insertMember", member);
	}
	
//	@Test
	public void 기업회원가입() throws Exception{
		CompanyVO companyVO = new CompanyVO();
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyDAO.insertCompany", companyVO);
	}
	
//	@Test
	public void 아이디체크() throws Exception{

		String id = "ghosdi0624";
		
		String result = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectIdcheck", id);
		System.out.println(result);
	}
	
//	@Test
	public void 로그인체크() throws Exception{

		CompanyVO vo = new CompanyVO();
		vo.setId("company");
		vo.setPassword("1234");
		
		CompanyVO result = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyDAO.selectcompany", vo);
		System.out.println(result);
	}
	
//	@Test
	public void 멤버로그인체크() throws Exception{

		MemberVO vo = new MemberVO();
		vo.setId("ghosdi0624");
		vo.setPassword("1234");
		
		MemberVO result = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectmember", vo);
		System.out.println(result);
	}
	
//	@Test
	public void 호텔등록() throws Exception{

		CompanyInfoVO vo = new CompanyInfoVO();
		vo.setAddr("서울시 강남");
		vo.setBreakfast(null);
		vo.setHotelName("비트호텔");
		vo.setId("company");
		vo.setInternet("on");
		vo.setIntroduce("우리호텔최고");
		vo.setParking("on");
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyInfoDAO.insertinfo", vo);
	}
	
//	@Test
	public void searchHotel() {
		
		List<CompanyInfoVO> list = sqlSessionTemplate.selectList("kr.co.bit.company.CompanyInfoDAO.selectAll");
		
		for(CompanyInfoVO vo : list){
			System.out.println(vo);
		}
	}
	
//	@Test
	public void 부대시설조회() {
		
		String name = "비트호텔";
		CompanyFacilitiesVO companyFacilitiesVO 
			= sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyFacilitiesDAO.selectByName", name);
		
		System.out.println(companyFacilitiesVO);
	}
	
//	@Test
	public void getIntroduce(){
		
		String name = "비트호텔";
		
		CompanyInfoVO vo = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyInfoDAO.selectIntro", name);
		System.out.println(vo);
	}
	
	@Test
	public void listTest(){
		
		String name = "비트호텔";
		
		List<CompanyInfoVO> companyList = new ArrayList<>();
		CompanyInfoVO vo1 = new CompanyInfoVO();
		vo1.setHotelName("컴퍼니호텔");
		CompanyInfoVO vo2 = new CompanyInfoVO();
		vo2.setHotelName("서울호텔");
		
		companyList.add(vo1);
		companyList.add(vo2);
		
		
		List<MemberReserveVO> list = sqlSessionTemplate.selectList("kr.co.bit.reserve.MemberReserveDAO.selectReservation", companyList);
		
		for(MemberReserveVO vo : list){
			System.out.println(vo);
		}
	}
}
