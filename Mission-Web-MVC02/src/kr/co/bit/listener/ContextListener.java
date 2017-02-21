package kr.co.bit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.bit.board.dao.BoardDAO;
import kr.co.bit.board.service.BoardService;
import kr.co.bit.login.dao.LoginDAO;
import kr.co.bit.login.service.LoginService;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 		// 서버가 종료 될때 가징 마지막에 호출
        System.out.println("리스너 종료");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 	// 서버가 시작할때 가장 먼저 호출

         ServletContext sc = event.getServletContext();
         
         BoardDAO boardDao = new BoardDAO();         
         BoardService boardService = new BoardService(boardDao);
         sc.setAttribute("boardService", boardService);
         
         LoginDAO loginDao = new LoginDAO();
         LoginService loginService = new LoginService(loginDao);
         sc.setAttribute("loginService", loginService);
    }
	
}
