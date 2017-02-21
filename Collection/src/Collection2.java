import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

//=====================================================================
// 			Collection
//				|
//			   List
//			|		|
//	  ArrayList    LinkedList
//	  [][][][][]	
//
// ArrayList 단점 !!
//	1) 저장 공간을 확보 확장 변경 하는 비용이 많이 든다.. 크기 고정 !!
//	2) 데이터를 삭제하는 비용이 많이 든다 !!
// ArrayList 장점 !!
//	--> 데이터 참조가 빨라서 실행속도가 빠르다 !! --> 성능 !!
// LinkedList : 삽입/삭제의 속도가 빠르다. 양을 예측할 수 없을 때 사용.
//=====================================================================

class IntCmp implements Predicate<Integer>
{
	public boolean test(Integer t) 
	{
	// ex) 짝수만 모두 삭제해라 !!
		if(t<10)
			return true;
		else
			return false;
	}
}

class Cmp implements Comparator<Integer>
{
	public int compare(Integer o1, Integer o2) 
	{
		if(o1<o2)
			return -1;
		else
			return 1;
	}
}

class Replace implements UnaryOperator<Integer>
{
	public Integer apply(Integer t) 
	{
		if(t==1)
			return 1111;
		else
			return t;
	}	
}



public class Collection2 {

	public static void main(String[] args) {

		ArrayList src = new ArrayList();
		src.add(1);
		src.add(2);
		src.add(3);
		
		List<Integer> list = new LinkedList<Integer>();
		// Collection 인터페이스 메소드 !!
		list.add(10);		// 값 하나 추가 !!
		list.addAll(src);	// 다른 컬렉션을 넣어서 추가 !!
		list.add(0, 4885);
		list.addAll(0, src);
		// Iterator : 반복자 !!
		//	--> 컬렉션에 존재하는 원소를 참조하는 역할을 하는 참조변수 !!
		//	--> 배열안에 모든 원소를 한번씩 접근해서 값을 가져오는 역할 !!
		// list 안에서 원소들의 값을 가져오는 변수
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())	// 다음 원소가 존재하지 않을 때까지 !!
		{
			System.out.print(iter.next()+"--");
		}
		System.out.println("--");
		
		// 삭제 연산들.....
//		list.remove(0);						// 첫번째거 지워라 
//		list.remove(new Integer(4885));		// 객체 지우기
//		list.removeAll(src);				// src의 전체 삭제
//		list.removeIf(new IntCmp());		// 선택적인 실행
//		list.clear();						// 한번에 정리 , removeIf에서 return true만 입력과 동일
//		list.contains(new Integer(4885));	// 해당 값이 있는지 없는지 / true/false로 반환
//			System.out.println(list.contains(new Integer(5000)));
//		list.sort(new Cmp());				// 정렬 하기
//		System.out.println(list.indexOf(new Integer(4885)));	// 4885가 몇번째 index에 있는지
//		Object[] ar = list.toArray();		// Collection의 값들을 java의 기본 배열로 리턴 !!
//		for(Object object : ar)
//		{System.out.println(object);}
		list.replaceAll(new Replace());		// 현재 컬렉션의 값들을 바꾸기
		
		
		iter = list.iterator();
		while(iter.hasNext())	// 다음 원소가 존재하지 않을 때까지 !!
		{
			System.out.print(iter.next()+"--");
		}
		
	}

}




