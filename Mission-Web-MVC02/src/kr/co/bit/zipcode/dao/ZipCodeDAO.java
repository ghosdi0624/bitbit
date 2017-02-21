package kr.co.bit.zipcode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;
import kr.co.bit.zipcode.vo.ZipCodeVO;

public class ZipCodeDAO {
	
	public List<ZipCodeVO> getAddr(String post){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<ZipCodeVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select zipcode, area1, area2, area3, area4 from tblzipcode where area3 like '%'||?||'%' ");
		
		try {
			conn = new ConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, post);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				ZipCodeVO zip = new ZipCodeVO();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setArea1(rs.getString("area1"));
				zip.setArea2(rs.getString("area2"));
				zip.setArea3(rs.getString("area3"));
				zip.setArea4(rs.getString("area4"));
				
				list.add(zip);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}
}
