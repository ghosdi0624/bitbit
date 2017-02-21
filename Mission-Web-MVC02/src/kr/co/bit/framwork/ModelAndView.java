package kr.co.bit.framwork;

import java.util.HashMap;
import java.util.Map;

/*
 * Model	: 화면단(jsp)에서 사용할 데이터 저장객체(Request 공유영역에 등록시킬 객체)
 * View		: 응답화면 페이지(jsp) 정보 저장
 */
public class ModelAndView {
	
	private String view;
	private Map<String, Object> model;
	
	public ModelAndView(){
		model = new HashMap<>();
	}

	public ModelAndView(String view){
		this();
		this.view = view;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public void addAttribute(String key, Object value){		// setAttribute와 같은기능
		model.put(key, value);
	}
}
