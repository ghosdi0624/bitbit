package kr.co.bit.reserve.dao;

import java.util.List;

import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

public interface ReserveDAO {

	public List<RoomVO> reserveForm(String hotelName);
	public List<MemberReserveVO> memberReserve(String hotelName);
	public RoomVO reserve(String roomName);
	public void insertReserve(MemberReserveVO memberReserveVO);
	public List<MemberReserveVO> reserveByRoom(String roomName);
	public void cancleReserve(MemberReserveVO memberReserveVO);
}
