package kr.co.bit.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.member.dao.MemberDAO;
import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Service
public class MemberServiceImp implements MemberService{
	
	@Autowired
	private MemberDAO dao;

	@Override
	public void memberform(MemberVO memberVO) {
		
		dao.memberform(memberVO);
	}

	@Override
	public String idcheck(String id) {
		
		String result = dao.idcheck(id);
		
		return result;
	}

	@Override
	public MemberVO memberlogin(MemberVO memberVO) {
		
		MemberVO userVO = dao.memberlogin(memberVO);
		
		return userVO;
	}

	@Override
	public List<MemberReserveVO> myPage(String id) {
		
		List<MemberReserveVO> list = dao.myPage(id);
		
		return list;
	}
}
