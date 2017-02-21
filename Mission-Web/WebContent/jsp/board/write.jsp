<%@page import="kr.co.bit.board.vo.BoardFileVO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@page import="kr.co.bit.board.vo.BoardVO"%>
<%@page import="kr.co.bit.util.BitFileNamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	1. 사용자가 입력한 파라미터(제목, 글쓴이, 내용)를 추출
	2. 추출한 파라미터를 t_board 테이블에 입력
	3. 사용자에게 메세지를 전달 후 목록페이지로 이동
--%>
<%-- <% 
	
	// 파일 첨부 전 내용
	
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	Connection conn = new ConnectionFactory().getConnection();
	
	StringBuilder sql = new StringBuilder();
	sql.append("insert into t_board (no, title, writer, content) ");
	sql.append(" values (seq_t_board_no.nextval, ?, ?, ?) ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, title);
	pstmt.setString(2, writer);
	pstmt.setString(3, content);	
	pstmt.executeUpdate();
	
	JDBCClose.close(conn, pstmt);
	
%> --%>
<%
	request.setCharacterEncoding("utf-8");
	
	// 업로드 하려는 파일 위치 지정 --> 절대경로로 지정
	String saveFolder = "C:/Users/user/workspace/Mission-Web/WebContent/upload";
	
	MultipartRequest multi 
		= new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8", new BitFileNamePolicy()); // 파일 업로드 완료
	
	// 1. 게시물 저장
	String title = multi.getParameter("title");
	String writer = multi.getParameter("writer");
	String content = multi.getParameter("content");
	
	// BoardVO 객체 생성 및 초기화
	BoardVO board = new BoardVO();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	
	// 게시판 번호 추출
	BoardDAO dao = new BoardDAO();
	int no = dao.selectNo();
	board.setNo(no);
	
	// DB에 저장
	dao.insert(board);
	
	// 2. 첨부파일 저장(t_board_file)
	Enumeration files = multi.getFileNames();
	while(files.hasMoreElements()){
		String fileName = (String)files.nextElement();
		File f = multi.getFile(fileName);							// --> multi.getFile('attachFile');
		if(f != null){
			String fileOriName = multi.getOriginalFileName(fileName);
			String fileSaveName = multi.getFilesystemName(fileName);
			int fileSize = (int)f.length();
			
			BoardFileVO fileVO = new BoardFileVO();
			fileVO.setNo(no);
			fileVO.setFileOriName(fileOriName);
			fileVO.setFileSaveName(fileSaveName);
			fileVO.setFileSize(fileSize);
			
			dao.insertFile(fileVO);			
		}
	}
%>
<script>
	alert("게시물이 등록되었습니다.");
	location.href = "list.jsp";
</script>