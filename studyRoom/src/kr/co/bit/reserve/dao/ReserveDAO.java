package kr.co.bit.reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.reserve.vo.ReserveVO;
import kr.co.bit.util.ConnectionFactory;

public class ReserveDAO {

	/**
	 * 예약 내용 DB저장
	 * @param day
	 * @param roomNo
	 * @param people
	 * @param id
	 * @param strTime
	 */
	public void insertReserve(String day, String roomName, String people, String id, String strTime) {
		
		int pNum = Integer.parseInt(people);
		int time = Integer.parseInt(strTime);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into reservation ");
		sql.append(" (rsv_no, member_id, room_name, persons_num, day, time) ");
		sql.append(" values (seq_rsv_no.nextval,?,?,?,?,?)  ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setString(1, id);
			pstmt.setString(2, roomName);
			pstmt.setInt(3, pNum);
			pstmt.setString(4, day);
			pstmt.setInt(5, time);
			pstmt.executeUpdate();
			
		} catch(Exception e){
			e.getMessage();
		}
	}
	
	/**
	 * 예약 현황 불러오기
	 */
	
	public List<ReserveVO> selectReserve(String day) {
		
		List<ReserveVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select room_name, status, time ");
		sql.append(" from reservation ");
		sql.append(" where to_char(day, 'YYYY-MM-DD') = ?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			)
		{
			pstmt.setString(1, day);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReserveVO vo = new ReserveVO();
				vo.setRoomName(rs.getString("room_name"));
				vo.setStatus(rs.getInt("status"));
				vo.setTime(rs.getInt("time"));
				list.add(vo);
			}
		} catch(Exception e){
			e.getMessage();
		}
		
		return list;
	}
	
}
