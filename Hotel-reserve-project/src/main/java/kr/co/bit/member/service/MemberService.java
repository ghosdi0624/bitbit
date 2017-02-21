package kr.co.bit.member.service;

import java.util.List;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

public interface MemberService {

	public void memberform(MemberVO memberVO);
	public String idcheck(String id);
	public MemberVO memberlogin(MemberVO memberVO);
	public List<MemberReserveVO> myPage(String id);
}
