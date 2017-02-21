import java.util.*;

//========================================================================
// map<E>
//	HashMap<E>
//	TreeMap<E>

//========================================================================


public class Collection6 {

	public static void main(String[] args) 
	{
		//		키값		밸류값
		HashMap<String, String> Addrs = new HashMap<String, String>(); 
		Addrs.put("김철수", "01011112222");
		Addrs.put("이철수", "123");
		Addrs.put("하철수", "1234");
		// map은 iter 방식을 지원 안함 !! --> key값을 통해서 바로 접근가능 !!
		// Iterator<String,String> iter = Addrs.iterator --> 불가
		//	1) 김철수의 전화번호는 ?
		System.out.println(Addrs.get("김철수"));
		//	2) 이철수를 삭제
		System.out.println(Addrs.remove("이철수"));
		//	이철수는 삭제된 키값이기 때문에.. map에 존재 하지 않는다..
		System.out.println(Addrs.get("이철수"));
		
	}

}
