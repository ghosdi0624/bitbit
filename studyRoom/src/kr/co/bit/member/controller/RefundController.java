package kr.co.bit.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;
import kr.co.bit.member.dao.BoardDao;
import kr.co.bit.member.dao.ResvDao;
import kr.co.bit.member.vo.BoardVO;
import kr.co.bit.member.vo.ResvVO;

public class RefundController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ResvDao resvDao=new ResvDao();
		BoardDao boardDao = new BoardDao();
		
		//List<ResvVO> resv = new ArrayList<>();
		List<BoardVO> board = new ArrayList<>();
		board=boardDao.getAllMember();
		//resv=resvDao.getResvMember();	
		
		
		
		
		//∆‰¿Ã¬°
		String pgstr = request.getParameter("pg");
		if (pgstr == null) {
			pgstr = "1";
		}
		int pg = Integer.parseInt(pgstr);
		int block = 5;
		int rowpage = 10;
		int total = resvDao.totalResv();/////
		int allpage = total / rowpage + (total % rowpage != 0 ? 1 : 0);
		int startpage = ((pg - 1) / block * block) + 1;
		int endpage = 0;
		if ((total / rowpage) + (total % rowpage != 0 ? 1 : 0) < ((pg - 1) / block * block) + block) {
			endpage = (total / rowpage) + (total % rowpage != 0 ? 1 : 0);
		} else {
			endpage = ((pg - 1) / block * block) + block;
		}

		ArrayList<ResvVO> list = resvDao.selectAllResv(pg, rowpage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("block", block);
		request.setAttribute("allpage", allpage);
		////////////////////
		
		//request.setAttribute("resvMember", resv);
		request.setAttribute("boardMember", board);

		return "/admin/refund.jsp";
	}
}

	

