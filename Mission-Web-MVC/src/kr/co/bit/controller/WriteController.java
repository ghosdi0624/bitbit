package kr.co.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.BitFileNamePolicy;

public class WriteController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		// 업로드 하려는 파일 위치 지정 --> 절대경로로 지정
		String saveFolder = "C:/Users/user/workspace/Mission-Web/WebContent/upload";
		
		MultipartRequest multi = new MultipartRequest(request, 
													  saveFolder, 
													  1024 * 1024 * 3, 
													  "utf-8",
													  new BitFileNamePolicy()
													  ); // 파일 업로드 완료
		
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
		
		return "/board/write.jsp";
	}

}
