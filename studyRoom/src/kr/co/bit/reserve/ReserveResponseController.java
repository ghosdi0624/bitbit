package kr.co.bit.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;

public class ReserveResponseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String time = request.getParameter("jTime");
		int roomNo = Integer.parseInt(request.getParameter("jRoomNo"));
		String roomName = null;

		switch (roomNo) {
		case 1:
			roomName = "八蔓没";
			break;
		case 2:
			roomName = "包技没";
			break;
		case 3:
			roomName = "措烹飞";
			break;
		case 4:
			roomName = "惫技没";
			break;
		case 5:
			roomName = "背腊没";
			break;
		case 6:
			roomName = "版蔓没";
			break;
		case 7:
			roomName = "家规没";
			break;
		}
		
		request.setAttribute("id", id);
		request.setAttribute("time", time);
		request.setAttribute("roomName", roomName);
		
		return "/reserve/reserveResponse.jsp";
	}

}
