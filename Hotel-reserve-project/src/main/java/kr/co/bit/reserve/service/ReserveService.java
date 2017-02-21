package kr.co.bit.reserve.service;

import java.util.List;

import kr.co.bit.hotel.vo.RoomVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

public interface ReserveService {

	public List<RoomVO> reserveForm(String hotelName);
	public List<MemberReserveVO> memberReserve(String hotelName);
	public RoomVO reserve(String roomName);
	public void insertReserve(MemberReserveVO memberReserveVO);
	public List<MemberReserveVO> reserveByRoom(String roomName);
	public void cancleReserve(MemberReserveVO memberReserveVO);

}
