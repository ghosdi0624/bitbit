package kr.co.bit.framwork;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "controllers", 
						value = "kr.co.bit.board.control.BoardController|kr.co.bit.login.control.LoginController")
		})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping mappings;
	
	public void init(ServletConfig config) throws ServletException {
		String ctrlNames = config.getInitParameter("controllers");
		
		try{
			mappings = new HandlerMapping(ctrlNames);
		} catch(Exception e){
			
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uri 추출 -> 해당 controller의 해당 method 호출
		// /board/list.do => new BoardController().list();
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		
		System.out.println("uri : " + uri);
		
		String view = null;
		CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
		
		try{
			if(cam==null){
				throw new Exception("요청하신 URL은 존재하지 않습니다.");
			}
			
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			
			ModelAndView mav = (ModelAndView)method.invoke(target, request, response);
			view = mav.getView();
			
			//request 공유영역에 객체 등록
			Map<String, Object> model = mav.getModel();
			
			Set<String> keys = model.keySet();
			for(String key : keys){		//데이터가 여러개일 경우 모두 공유영역에 추가
				request.setAttribute(key, model.get(key));
				System.out.println(key);
			}
			
		} catch(Exception e){
			request.setAttribute("exception", e);
			view = "/ErrorServlet";
		}
		
		// 응답을 위한 JSP 이동
		if(view.startsWith("redirect:")) {
			//sendRedirect
			response.sendRedirect(view.substring("redirect:".length()));
		} else{
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
