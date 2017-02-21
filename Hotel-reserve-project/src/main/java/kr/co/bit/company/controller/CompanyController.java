package kr.co.bit.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.bit.company.service.CompanyService;
import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;
import kr.co.bit.util.FileUtils;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;
	@Autowired
	private FileUtils fileUtils;

	@RequestMapping("/company/company.do")
	public String companyform(@ModelAttribute CompanyVO companyVO) {

		service.companyform(companyVO);

		return "redirect:/";
	}

	@RequestMapping("company/idcheck.do")
	public String idcheck(@RequestParam("id") String id, Model model) {

		String result = service.idcheck(id);

		boolean b = true;
		if (result == null) {
			b = false;
		}

		model.addAttribute("b", b);
		model.addAttribute("id", id);

		return "member/idCheck";
	}

	@RequestMapping("/login/companylogin.do")
	public String companylogin(@ModelAttribute CompanyVO companyVO, HttpSession session, Model model) {

		CompanyVO userVO = service.companylogin(companyVO);
		if (userVO != null) {
			session.setAttribute("userVO", userVO);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "로그인을실패 하였습니다.");
		}
		return "login/companyloginform";
	}

	@RequestMapping("/company/registerHotel.do")
	public String registerHotel() {

		return "company/registerhotel";
	}

	@RequestMapping(value = "/company/secondregisterhotel.do", method = RequestMethod.POST)
	public String secondRegisterHotel(@ModelAttribute CompanyInfoVO companyInfoVO, HttpSession session) {

		CompanyVO companyVO = (CompanyVO) session.getAttribute("userVO");
		companyInfoVO.setId(companyVO.getId());
		session.setAttribute("hotelName", companyInfoVO.getHotelName());

		service.secondRegisterHotel(companyInfoVO);

		return "company/secondregisterhotel";
	}

	@RequestMapping(value = "/company/register.do", method = RequestMethod.POST)
	public String register(HttpServletRequest request, HttpSession session) {

		CompanyFacilitiesVO facilities = new CompanyFacilitiesVO();
		CompanyVO companyVO = (CompanyVO) session.getAttribute("userVO");
		String hotelName = (String)session.getAttribute("hotelName");

		// 일반 사항
		String[] basicArr = request.getParameterValues("basic");
		String basic = "";

		if (basicArr != null) {
			for (int i = 0; i < basicArr.length; i++) {
				basic += "· "+basicArr[i] + "  ";
			}
		} else {
			basic += "-";
		}
		// 편의시설
		String[] convenienceArr = request.getParameterValues("convenience");
		String convenience = "";
		if (convenienceArr != null) {
			for (int i = 0; i < convenienceArr.length; i++) {
				convenience += "· "+convenienceArr[i] + "  ";
			}
		} else {
			convenience += "-";
		}
		// 서비스
		String[] serviceArr = request.getParameterValues("service");
		String hotelservice = "";
		if (serviceArr != null) {
			for (int i = 0; i < serviceArr.length; i++) {
				hotelservice += "· "+serviceArr[i] + "  ";
			}
		} else {
			hotelservice += "-";
		}
		// 인터넷
		String[] internetArr = request.getParameterValues("internet");
		String internet = "";
		if (internetArr != null) {
			for (int i = 0; i < internetArr.length; i++) {
				internet += "· "+internetArr[i] + "  ";
			}
		} else {
			internet += "-";
		}

		// 주차장
		String[] parkingArr = request.getParameterValues("parking");
		String parking = "";
		if (parkingArr != null) {
			for (int i = 0; i < parkingArr.length; i++) {
				parking += "· "+parkingArr[i] + "  ";
			}
		} else {
			parking += "-";
		}

		String checkIn = request.getParameter("check-in");
		String checkOut = request.getParameter("check-out");

		facilities.setId(companyVO.getId());
		facilities.setBasic(basic);
		facilities.setConvenience(convenience);
		facilities.setService(hotelservice);
		facilities.setInternet(internet);
		facilities.setParking(parking);
		facilities.setCheckIn(checkIn);
		facilities.setCheckOut(checkOut);
		facilities.setHotelName(hotelName);

		service.register(facilities);
		
		return "company/thirdregisterhotel";
	}
	
	@RequestMapping("/company/thirdregisterhotel.do")
	public String thirdRegisterHotel(){
		
		return "company/thirdregisterhotel";
	}
	
	@RequestMapping(value="/company/fileupload.do")
	public String fileUpload(HttpServletRequest request, HttpSession session) throws Exception{

		String hotelName = request.getParameter("hotelName");
		
		Object[] object = fileUtils.saveFile(hotelName, request);
		
		@SuppressWarnings("unchecked")
		List<CompanyFileVO> list = (List<CompanyFileVO>)object[0];
		CompanyInfoVO companyInfoVO = (CompanyInfoVO)object[1];
		
		service.fileUpload(list);
		service.mainFileUpload(companyInfoVO);
		
		session.removeAttribute("hotelName");
		
		return "redirect:/";
	}
	
	@RequestMapping("/company/roomregister.do")
	public String roomRegisterForm(HttpSession session, Model model){
		
		CompanyVO companyVO = (CompanyVO)session.getAttribute("userVO");
		List<CompanyInfoVO> list = service.roomRegisterForm(companyVO.getId());
		
		model.addAttribute("list", list);
		
		return "company/roomregister";
	}
	
	@RequestMapping(value="/company/roomregister.do", method=RequestMethod.POST)
	public String roomRegister(@ModelAttribute RoomVO roomVO, HttpServletRequest request) throws Exception{
		
		RoomVO vo = fileUtils.saveRoomFile(roomVO.gethotelName(), request);
		roomVO.setOriRoomFile(vo.getOriRoomFile());
		roomVO.setNewRoomFile(vo.getNewRoomFile());
		
		service.roomRegister(roomVO);
		
		return "redirect:/";
	}
	
	@RequestMapping("/company/companypage.do")
	public String companyPage(HttpSession session, Model model){
		
		CompanyVO companyVO = (CompanyVO)session.getAttribute("userVO");
		String id = companyVO.getId();
		
		List<CompanyInfoVO> companyList = service.getHotelNames(id);		// 해당 id사업자에 맞는 호텔명들 불러오기
		List<MemberReserveVO> list = service.getReservation(companyList);	//예약현황 불러오기
				
		model.addAttribute("list", list);
		
		return "company/companypage";
	}
}

