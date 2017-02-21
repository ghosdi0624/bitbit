package kr.co.bit.reserve.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@Repository
public class ReserveDAOImp implements ReserveDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<RoomVO> reserveForm(String hotelName) {
		
		List<RoomVO> list = sqlSessionTemplate.selectList("kr.co.bit.hotel.RoomDAO.selectAll", hotelName);
		
		return list;
	}

	@Override
	public List<MemberReserveVO> memberReserve(String hotelName) {
		
		List<MemberReserveVO> memberList = sqlSessionTemplate.selectList("kr.co.bit.member.MemberDAO.selectRoom", hotelName);
		
		return memberList;
	}

	@Override
	public RoomVO reserve(String roomName) {
		
		RoomVO roomVO = sqlSessionTemplate.selectOne("kr.co.bit.hotel.RoomDAO.selectByRoomName", roomName);
		
		return roomVO;
	}

	@Override
	public void insertReserve(MemberReserveVO memberReserveVO) {
		
		sqlSessionTemplate.insert("kr.co.bit.reserve.MemberReserveDAO.insertReserve", memberReserveVO);
		
	}

	@Override
	public List<MemberReserveVO> reserveByRoom(String roomName) {
		
		List<MemberReserveVO> memberList = sqlSessionTemplate.selectList("kr.co.bit.member.MemberDAO.selectByRoom", roomName);
		
		return memberList;
	}

	@Override
	public void cancleReserve(MemberReserveVO memberReserveVO) {
		
		sqlSessionTemplate.delete("kr.co.bit.reserve.MemberReserveDAO.deleteReserve", memberReserveVO);
		
	}

	
}
