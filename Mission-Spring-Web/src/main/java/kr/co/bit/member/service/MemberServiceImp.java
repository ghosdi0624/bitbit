package kr.co.bit.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.member.MemberVO;
import kr.co.bit.member.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO dao;
	@Override
	public List<MemberVO> memberInfo() {
		
		List<MemberVO> list = dao.memberInfo();		
		return list;
	}
	
	@Override
	public MemberVO login(MemberVO member) {
		
		MemberVO user = dao.login(member);
		
		return user;
	}

	@Override
	public MemberVO mypage(MemberVO member) {
		
		MemberVO vo = dao.mypage(member);
		
		return vo;
	}

	@Override
	public String pwproc(String id) {
		
		String pw = dao.pwproc(id);
		
		return pw;
	}

	@Override
	public void changPW(MemberVO memberVO) {
		
		dao.changPW(memberVO);
	}

}
