package kr.co.bit.front;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import kr.co.bit.controller.Controller;

public class HandlerMapping {

	private Map<String, Controller> mappings = null;
	
	public HandlerMapping() {
		this("C:/Users/User/workspace/studyRoom/bean.properties");
	}
	
	public HandlerMapping(String configName) {
		mappings = new HashMap<>();
		///Properties파일 중간에 공백 ㄴㄴ **=** 형태로 써야함
		Properties prop = new Properties();
		
		try {
			InputStream inStream 
				= new FileInputStream(configName);
			prop.load(inStream);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				//System.out.println(key + " : " + prop.getProperty(key.toString()));
				String className = prop.getProperty(key.toString());
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller getController(String uri) {
		
		return mappings.get(uri);
	}
	
	public static void main(String[] args) throws Exception {
		
//		java.util.Random r = new java.util.Random();
//		int random = r.nextInt(45) + 1;
//		System.out.println("random : " + random);
		
//		Class<?> clz = Class.forName("java.util.Random");
//		java.util.Random r = (java.util.Random)clz.newInstance();
//		System.out.println(r.nextInt(45) + 1);
		
		
//		Class<?> clz = Class.forName("kr.co.kt.controller.ListController");
//																	
//		Controller obj = (Controller)clz.newInstance();// =new ListController();  newInstance()객체를 생성해 반환해줌. 리플렉션
//		System.out.println(obj.handleRequest(null, null));
		
	}
}