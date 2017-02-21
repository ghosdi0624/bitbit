package kr.co.bit.login.service;

import kr.co.bit.login.dao.LoginDAO;
import kr.co.bit.login.vo.LoginVO;

public class LoginService {
	
	private LoginDAO dao;
	
	public LoginService(LoginDAO dao){
		
		this.dao = dao;
	}
	
	public LoginVO login(LoginVO loginVO){
		
		LoginVO userVO = dao.login(loginVO);
		return userVO;
	}
}
