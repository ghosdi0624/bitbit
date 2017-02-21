package kr.co.bit.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.member.MemberVO;

@Repository
public class MemberDAOImp implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MemberVO> memberInfo() {
		
		List<MemberVO> list = sqlSessionTemplate.selectList("kr.co.bit.member.MemberDAO.selectMember");
		return list;
	}
	
	@Override
	public MemberVO login(MemberVO member) {
	
		MemberVO user = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.login", member);
		
		return user;
	}

	@Override
	public MemberVO mypage(MemberVO member) {
		
		MemberVO vo = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.mypage", member);
		
		return vo;
	}

	@Override
	public String pwproc(String id) {
		
		String pw = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.pwproc", id);
		
		return pw;
	}

	@Override
	public void changPW(MemberVO memberVO) {
		
		sqlSessionTemplate.update("kr.co.bit.member.MemberDAO.changePW", memberVO);
	}

}
