package kr.co.bit.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping(){
		this("C:/Users/User/workspace/Mission-Web-MVC/bean.properties");
	}
	
	public HandlerMapping(String configName){
		
		mappings = new HashMap<>();	
		Properties prop = new Properties();
		
		try{
			InputStream inStream = new FileInputStream(configName);
			prop.load(inStream);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys){
//				System.out.println(key + " : " + prop.getProperty(key.toString()));
				String className = prop.getProperty(key.toString());
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}	
		} catch(Exception e){
			e.getMessage();
		}	
		
	}
	
	public Controller getController(String uri){
		
		return mappings.get(uri);
	}

}
