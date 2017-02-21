package kr.co.bit.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Repository
public class MemberDAOImp implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void memberform(MemberVO memberVO) {
		
		sqlSessionTemplate.insert("kr.co.bit.member.MemberDAO.insertMember", memberVO);
	}

	@Override
	public String idcheck(String id) {
		
		String result = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectIdcheck", id);
		
		return result;
	}

	@Override
	public MemberVO memberlogin(MemberVO memberVO) {
		
		MemberVO userVO = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectmember", memberVO);
		
		return userVO;
	}

	@Override
	public List<MemberReserveVO> myPage(String id) {
		
		List<MemberReserveVO> list = sqlSessionTemplate.selectList("kr.co.bit.reserve.MemberReserveDAO.selectmypage", id);
		
		return list;
	}
}
