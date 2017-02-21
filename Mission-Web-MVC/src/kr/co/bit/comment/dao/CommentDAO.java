package kr.co.bit.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.comment.vo.CommentVO;
import kr.co.bit.util.ConnectionFactory;

public class CommentDAO {

	public void insertComment(int boardNo, String writer, String content){
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_board_comment (no, board_no, writer, content) ");
		sql.append(" values (seq_t_board_comment_no.nextval, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) 
		{
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public List<CommentVO> selectAll(int boardNo){
		
		List<CommentVO> list = new ArrayList<>();
		CommentVO comment = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select writer, content, reg_date ");
		sql.append(" from t_board_comment ");
		sql.append(" where board_no = ?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) 
		{
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String regDate = rs.getString("reg_date");
				
				comment = new CommentVO();
				comment.setWriter(writer);
				comment.setContent(content);
				comment.setRegDate(regDate);
				
				list.add(comment);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return list;
	}
}
