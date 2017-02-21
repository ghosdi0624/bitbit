package kr.co.bit.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.reserve.dao.ReserveDAO;

public class ReserveProcController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ReserveDAO dao = new ReserveDAO();
		
		String day = request.getParameter("date"); 							// 	예약 날짜 yyyy-mm-dd
		String[] time = request.getParameter("time").split(",");			// 	예약시간
		String[] roomName = request.getParameter("roomName").split(",");	//	방이름
		String[] people = request.getParameter("people").split(",");		//	인원수
		String id = (String)session.getAttribute("id");						// 	ID
		//String id = "admin";
		for(int i=0; i<time.length; i++){
			dao.insertReserve(day,roomName[i],people[i],id,time[i]);
		}
		
		return "/reserve/reserveProc.jsp";
	}

}
