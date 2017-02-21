package kr.co.bit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.member.vo.BoardVO;
import kr.co.bit.util.ConnectionFactory;

public class BoardDao {

	public void insertMember(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into member(id,name,password,phone) ");
		sql.append("values (?,?,?,?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, board.getId());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPassword());
			pstmt.setString(4, board.getPhone());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> getAllMember() {

		List<BoardVO> board = null;
		BoardVO vo = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select*from member");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			board = new ArrayList<>();

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setPhone(rs.getString("phone"));
				vo.setType(rs.getString("type"));

				board.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;

	}

	public String changePW(String id) {

		String pw = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select password from member ");
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
		sql.append("update member set ");
		sql.append(" password = ? ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void deleteMember(String id) {

		StringBuilder sql = new StringBuilder();
		sql.append("update member set id = ? where id = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, "delete" + id);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BoardVO login(String id, String pw) {

	      BoardVO vo = null;
	      StringBuilder sql = new StringBuilder();
	      sql.append("select * ");
	      sql.append(" from member ");
	      sql.append(" where id = ? and password = ?");

	      try (Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

	      ) {

	         pstmt.setString(1, id);
	         pstmt.setString(2, pw);

	         ResultSet rs = pstmt.executeQuery();

	         if (rs.next()) {
	            vo = new BoardVO();
	            vo.setId(rs.getString("id"));
	            vo.setName(rs.getString("name"));
	            vo.setPassword(rs.getString("password"));
	            vo.setPhone(rs.getString("phone"));
	            vo.setType(rs.getString("type"));
	         }

	      } catch (Exception e) {
	         e.getMessage();
	      }

	      return vo;
	   }
	   
	   public boolean selectId(String id) {

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      StringBuilder sql = new StringBuilder();
	      sql.append("select id from member where id = ?");
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
}
