package kr.co.bit.member.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import kr.co.bit.controller.Controller;

public class SetDirection {

	private Map<String, Controller> mapping;

	public SetDirection(String args) {
		mapping = new HashMap<>();
		Properties prop = new Properties();

		try {

			InputStream input = new FileInputStream(args); // args는 properties
															// 파일 이름이다.
			prop.load(input); // properties 객체를 만들어서 properties 파일의 내용을 업로드해준다.

			Set<Object> key = prop.keySet(); // set 콜렉션을 만들어서 각각의 key값인
												// uri(*.do) 값을 넣어준다

			for (Object keys : key) { // mapping 해쉬맵 안에 properties 객체 안의 uri값과
										// 객체를 넣어준다. (key, value) = (uri, 객체)

				Class<?> makingClass = Class.forName(prop.getProperty(keys.toString()));
				mapping.put(keys.toString(), (Controller) makingClass.newInstance());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Controller getController(String uri) {

		return mapping.get(uri); // join.do와 같은 uri에 맞는 Controller 객체를 리턴해준다.
	}

}
