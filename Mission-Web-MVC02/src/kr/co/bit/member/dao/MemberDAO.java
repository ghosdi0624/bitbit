package kr.co.bit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class MemberDAO {

	public List<MemberVO> selectAllMember() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		List<MemberVO> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_member ");

		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setEmailId(rs.getString("email_id"));
				member.setEmailDomain(rs.getString("email_domain"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setPost(rs.getString("post"));
				member.setBasicAddr(rs.getString("basic_addr"));
				member.setDetailAddr(rs.getString("detail_addr"));
				member.setType(rs.getString("type"));
				member.setRegDate(rs.getString("reg_date"));

				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}

	public MemberVO selectMyInfo(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberVO member = new MemberVO();

		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_member where id = ? ");

		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPassword(rs.getString("password"));
			member.setEmailId(rs.getString("email_id"));
			member.setEmailDomain(rs.getString("email_domain"));
			member.setTel1(rs.getString("tel1"));
			member.setTel2(rs.getString("tel2"));
			member.setTel3(rs.getString("tel3"));
			member.setPost(rs.getString("post"));
			member.setBasicAddr(rs.getString("basic_addr"));
			member.setDetailAddr(rs.getString("detail_addr"));
			member.setType(rs.getString("type"));
			member.setRegDate(rs.getString("reg_date"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return member;
	}

	public boolean selectId(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id from t_member where id = ?");
		boolean b = true;

		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public void insertMember(String id, String pw, String name, String email, String selectmail, String tel1,
			String tel2, String tel3, String post, String basic_addr, String addr) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(
				"insert into t_member (id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr) ");
		sql.append(" values (?,?,?,?,?,?,?,?,?,?,?) ");

		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.setString(4, email);
			pstmt.setString(5, selectmail);
			pstmt.setString(6, tel1);
			pstmt.setString(7, tel2);
			pstmt.setString(8, tel3);
			pstmt.setString(9, post);
			pstmt.setString(10, basic_addr);
			pstmt.setString(11, addr);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	public String changePW(String id) {

		String pw = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select password from t_member ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			pw = rs.getString("password");
		} catch (Exception e) {
			e.getMessage();
		}

		return pw;
	}

	public void lastChangePW(String id, String pw) {

		StringBuilder sql = new StringBuilder();
		sql.append("update t_member set ");
		sql.append(" password = ? ");
		sql.append(" where id = ? ");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
