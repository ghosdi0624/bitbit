package kr.co.bit.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;
import kr.co.bit.reserve.dao.ReserveDAO;

@Service
public class ReserveServiceImp implements ReserveService {
	
	@Autowired
	private ReserveDAO dao;

	@Override
	public List<RoomVO> reserveForm(String hotelName) {
		
		List<RoomVO> list = dao.reserveForm(hotelName);
		
		return list;
	}

	@Override
	public List<MemberReserveVO> memberReserve(String hotelName) {
		
		List<MemberReserveVO> memberList = dao.memberReserve(hotelName);
		
		return memberList;
	}

	@Override
	public RoomVO reserve(String roomName) {
		
		RoomVO roomVO = dao.reserve(roomName);
		
		return roomVO;
	}

	@Override
	public void insertReserve(MemberReserveVO memberReserveVO) {
		
		dao.insertReserve(memberReserveVO);
		
	}

	@Override
	public List<MemberReserveVO> reserveByRoom(String roomName) {
		
		List<MemberReserveVO> list = dao.reserveByRoom(roomName);
		
		return list;
	}

	@Override
	public void cancleReserve(MemberReserveVO memberReserveVO) {
		
		dao.cancleReserve(memberReserveVO);
		
	}
}
