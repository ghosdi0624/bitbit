package kr.co.bit.member.dao;

import java.util.List;

import kr.co.bit.member.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> memberInfo();
	public MemberVO login(MemberVO member);
	public MemberVO mypage(MemberVO member);
	public String pwproc(String id);
	public void changPW(MemberVO memberVO);
}
