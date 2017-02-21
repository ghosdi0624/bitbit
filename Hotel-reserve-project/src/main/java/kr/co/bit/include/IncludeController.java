package kr.co.bit.include;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncludeController {
	
	@RequestMapping("/include/footer.do")
	public String footer(){
		
		return "include/footer";
	}
	
	@RequestMapping("/include/topmenu.do")
	public String header(){
		
		return "include/topmenu";
	}
	
	@RequestMapping("/include/sidemenu.do")
	public String sideMenu(){
		
		return "include/sidemenu";
	}
}
