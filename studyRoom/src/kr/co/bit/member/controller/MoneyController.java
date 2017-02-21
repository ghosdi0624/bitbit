package kr.co.bit.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.ResvDao;

public class MoneyController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String mon = request.getParameter("money");// 1월, 2월...
		mon = mon.substring(0, mon.indexOf("월"));// 달
		ResvDao dao = new ResvDao();
		String Json="";
		Json += "[{paidTotal : ";
		Json += dao.getReserveAccount(Integer.parseInt(mon))+dao.getRefundAccount(Integer.parseInt(mon));
		Json += "}, {refundTotal : ";
		Json += dao.getRefund2Account(Integer.parseInt(mon));
		Json += "}, {margin : ";
		Json += dao.getReserveAccount(Integer.parseInt(mon))+dao.getRefundAccount(Integer.parseInt(mon)) - dao.getRefund2Account(Integer.parseInt(mon));
		Json += "}]";
		return "/admin/test.jsp?money="+Json;
	}
}
