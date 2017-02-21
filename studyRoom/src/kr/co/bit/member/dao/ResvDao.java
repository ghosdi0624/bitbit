package kr.co.bit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.member.vo.ResvVO;
import kr.co.bit.util.ConnectionFactory;

public class ResvDao {

	public List<ResvVO> getResvMember() {
		ResvVO vo = null;
		List<ResvVO> board = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from reservation");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ResvVO();

				vo.setRsv_no(rs.getInt("rsv_no"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setPersons_num(rs.getInt("persons_num"));
				vo.setStatus(rs.getInt("status"));
				vo.setDay(rs.getString("day"));
				vo.setTime(rs.getInt("time"));

				board.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public List<ResvVO> getResvById(String id) {
		ResvVO vo = null;
		List<ResvVO> board = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select rsv_no, member_id, room_name, persons_num, status, to_char(day, 'yyyy-MM-dd') day, time from reservation where MEMBER_ID=?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ResvVO();
				vo.setRsv_no(rs.getInt("rsv_no"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setPersons_num(rs.getInt("persons_num"));
				vo.setStatus(rs.getInt("status"));
				vo.setDay(rs.getString("day"));
				vo.setTime(rs.getInt("time"));
				board.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public void updateResv(String no, String payment) {
		int num = Integer.parseInt(no);
		int status = 0;
		switch (payment) {
		case "대기":
			status = 1;
			break;
		case "결제완료":
			status = 2;
			break;
		case "환불":
			status = 3;
			break;
		case "환불2":
			status = 4;
			break;
		}
		// System.out.println(num + " " +status);
		if(status==3)
			insertRefund(num);
		if(status==4)
			status=3;
		StringBuilder sql = new StringBuilder();
		sql.append("update reservation set status=? where rsv_no=? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, status);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertRefund(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT into REFUNDINFO ");
		sql.append("VALUES (SEQ_REFUND_NO.nextval, ");
		sql.append("(SELECT CASE WHEN (to_char(DAY,'dd')-to_char(SYSDATE,'dd')) = 0 THEN 1");
		sql.append("WHEN (to_char(DAY,'dd')-to_char(SYSDATE,'dd')) < 3 THEN 2 ");
		sql.append("ELSE 3 END ");
		sql.append(" FROM RESERVATION ");
		sql.append("where RSV_NO=?), ?)");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPersons(int num) {

		int total = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from rsv_persons ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getInt("ps_num") == num) {
					total = rs.getInt("pay");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return total;
	}

	public List<ResvVO> getById(String id) {

		List<ResvVO> board = new ArrayList<>();
		ResvVO vo = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select * from reservation where member_id=?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ResvVO();

				vo.setRsv_no(rs.getInt("rsv_no"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setPersons_num(rs.getInt("persons_num"));
				vo.setStatus(rs.getInt("status"));
				vo.setDay(rs.getString("day"));
				vo.setTime(rs.getInt("time"));

				board.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;

	}

	/**
	 * 결제상태와 달에 따른 돈
	 * 
	 * @param status
	 * @param month
	 * @return int account
	 */
	public int getReserveAccount(int month) {//결제금액
		StringBuilder sql = new StringBuilder();
		int account = 0;
		sql.append("SELECT sum(p.PAY) ");
		sql.append("FROM RESERVATION r, RSV_PERSONS p ");
		sql.append("where r.STATUS=2");// 결제상태
		sql.append("and r.PERSONS_NUM=p.PS_NUM ");
		sql.append("and to_char(DAY,'MM')=?");// 달
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, month);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			account = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	public int getRefundAccount(int month) {//환불할 금액(rule x)
		StringBuilder sql = new StringBuilder();
		int account = 0;
		sql.append("SELECT sum(p.PAY) ");
		sql.append("FROM RESERVATION r, RSV_PERSONS p ");
		sql.append("where r.STATUS=3");// 결제상태
		sql.append("and r.PERSONS_NUM=p.PS_NUM ");
		sql.append("and to_char(DAY,'MM')=?");// 달
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, month);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			account = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public int getRefund2Account(int month) {//환불하고 남은 금액(rule o)
		StringBuilder sql = new StringBuilder();
		int account = 0;
		sql.append("SELECT sum(p.PAY*RULE.PER) FROM  RESERVATION r, RSV_PERSONS p, REFUNDINFO i, RULE where i.RESERVATION_NO = r.RSV_NO and  i.RULE_NO=RULE.NO and r.STATUS=3 and r.PERSONS_NUM=p.PS_NUM and to_char(DAY,'MM')=?");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, month);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			account = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	/**
	 * 전체 예약 수
	 * 
	 * @return int
	 */
	public int totalResv() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) ");
		sql.append("from RESERVATION");
		int total = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	/**
	 * 페이징
	 * 
	 * @param page
	 * @param rowpage
	 * @return
	 */
	public ArrayList<ResvVO> selectAllResv(int page, int rowpage) {
		int start = (page * rowpage) - (rowpage - 1);
		int end = (page * rowpage);
		ResvVO vo = null;
		ArrayList<ResvVO> board = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from ");
		sql.append("(select rownum rnum, rsv_no, member_id, room_name, persons_num, status, day, time from ");
		sql.append("reservation order by rsv_no desc) ");
		sql.append("where rnum between " + start + " and " + end);
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ResvVO();
				vo.setRsv_no(rs.getInt("rsv_no"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setPersons_num(rs.getInt("persons_num"));
				vo.setStatus(rs.getInt("status"));
				vo.setDay(rs.getString("day"));
				vo.setTime(rs.getInt("time"));
				
				board.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
}
