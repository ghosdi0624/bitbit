package kr.co.bit.reserve;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.reserve.dao.ReserveDAO;
import kr.co.bit.reserve.vo.ReserveVO;

public class ReserveFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		ReserveDAO dao = new ReserveDAO();
		List<ReserveVO> list = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd" ); 
		Date currentTime = new Date (); 
		String today = formatter.format(currentTime);	// 오늘날짜 구하기 yyyy-mm-dd
		
		String date = request.getParameter("date");		// 넘어온 날짜 / 있으면 해당날짜 , 없으면 오늘날짜로 DB 추출
		if(date==null){
			list = dao.selectReserve(today);
		} else {
			list = dao.selectReserve(date);
		}
		
		request.setAttribute("date", date);
		request.setAttribute("list", list);
		
		return "/reserve/reserveForm.jsp";
	}

}
