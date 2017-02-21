package kr.co.bit.framwork;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.co.bit.framwork.annotation.RequestMapping;

public class HandlerMapping {

	private Map<String, CtrlAndMethod> mappings = null;

	public HandlerMapping(String ctrlNames) throws Exception {

		mappings = new HashMap<>();

		String[] ctrls = ctrlNames.split("\\|"); // 정규식이기 때문에 \\ 삽입
		for (String ctrl : ctrls) {
			Class<?> clz = Class.forName(ctrl.trim()); // web.xml에 양쪽에 공백 발생할 수 있어서 trim 추가
			Object target = clz.newInstance();

			Method[] methods = clz.getMethods(); // public 모든 메소드
			// Method[] methods = clz.getDeclaredMethods(); // 직접 선언한 메소드만
			for (Method method : methods) {
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);

				if (reqAnno != null) {
					String uri = reqAnno.value();
					CtrlAndMethod cam = new CtrlAndMethod(target, method);

					mappings.put(uri, cam);
				}
			}

		}
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri){
		return mappings.get(uri);
	}
}
