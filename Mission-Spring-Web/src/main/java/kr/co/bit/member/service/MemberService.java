package kr.co.bit.member.service;

import java.util.List;

import kr.co.bit.member.MemberVO;

public interface MemberService {
	
	public List<MemberVO> memberInfo();
	public MemberVO login(MemberVO member);
	public MemberVO mypage(MemberVO member);
	public String pwproc(String id);
	public void changPW(MemberVO memberVO);
}
