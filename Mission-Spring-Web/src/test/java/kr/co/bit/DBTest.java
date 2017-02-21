package kr.co.bit;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.bit.board.BoardVO;
import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.member.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/**/*.xml"})  // xml 파일을 읽어서 Autowired 하는 것.
public class DBTest {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private BoardDAO dao;
	
//	@Test
	public void testConnection() throws Exception{	// Junit 녹색불 -> 정상적으로 Autowired 되었음.
		
		System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
	}
	
//	@Test
	public void 게시판상세페이지조회테스트() throws Exception{
		
		BoardVO board = new BoardVO();
		board = sqlSessionTemplate.selectOne("kr.co.bit.board.BoardDAO.selectBoardByNo", 21);
		System.out.println(board);
	}
	
	
//	@Test
	public void DAO읽기() throws Exception{
		
		BoardVO board = dao.detail(21);
		System.out.println(board);
		
	}
	
	@Test
	public void 멤버불러오기() throws Exception{
		
		System.out.println("member.......");
		List<MemberVO> list = sqlSessionTemplate.selectList("kr.co.bit.member.MemberDAO.selectMember");
		for(MemberVO member : list){
			System.out.println(member);
		}
	}
	
	@Test
	public void 로그인확인() throws Exception{
		
		MemberVO member = new MemberVO();
		member.setId("admin");
		member.setPassword("admin");
				
		MemberVO vo = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.login", member);
		System.out.println(vo);
	}
	
//	@Test
	public void 글등록() throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setContent("test");
		boardVO.setTitle("titleTest");
		boardVO.setWriter("testwriter");
		sqlSessionTemplate.insert("kr.co.bit.board.BoardDAO.insertBoard", boardVO);
	}
	
//	@Test
	public void 글삭제() throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(3);
		sqlSessionTemplate.delete("kr.co.bit.board.BoardDAO.deleteBoard", boardVO);
	}
	
//	@Test
	public void 마이페이지() throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPassword("1234");
		sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.mypage", vo);
		System.out.println(vo);
	}
	
//	@Test
	public void 비밀번호체크() throws Exception{
		
		String id = "ghosdi0624";
		String pw = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.pwproc", id);
		System.out.println(pw);
	}
	
//	@Test
	public void 비밀번호변경() throws Exception{
		
		String id = "ghosdi0624";
		String password = "12347";
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(password);
		sqlSessionTemplate.update("kr.co.bit.member.MemberDAO.changePW", memberVO);
	}
	
	@Transactional
	@Test
	public void 트랜잭션테스트() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("제목입니다");
		board.setWriter("홍길동");
		board.setContent("내용입니다.");
		
		sqlSessionTemplate.insert("kr.co.bit.board.BoardDAO.insertBoard", board);
	}
	
}
