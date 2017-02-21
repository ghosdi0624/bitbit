import java.util.*;

//======================================================================
// set<E> 인터페이스를 상속받는 클래스들 !!
// List<E> 차이점 !!
//	--> set<E> 데이타 저장 순서를 유지하지 않는다.. !!
//	--> 데이타의 중복된 저장을 허용하지 않는다.


// HashSet<E> 클래스
// TreeSet<E> 클래스
//======================================================================



public class Collection3 {

	public static void main(String[] args) 
	{
		HashSet<String> hSet = new HashSet<String>();
		
		hSet.add("AAA");
		hSet.add("BBB");
		hSet.add("CCC");
		System.out.println(hSet.size());
		// 전체 출력 !!
		Iterator<String> iter = hSet.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		// 해쉬 알고리즘 !!
		//	-> 해쉬함수에 기준이 되는 로직을 넣고..
		//	-> 기준점에 따리 분류 !!
		//	-> 매우 빠른 검색 속도 !!
		String str = "AAA";
		System.out.println(str.hashCode());
		System.out.println(iter.hashCode());
		System.out.println(hSet.hashCode());
	
	}

}
