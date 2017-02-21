import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//================================================================
// TreeSet<T> 
//	--> 트리를 추상화한 클래스
//	--> 이진탐색트리 !! --> 자식이 2개 밖에 없는 트리(이진 트리)
//================================================================



public class Collection4 {

	public static void main(String[] args) 
	{
		TreeSet<Integer> hSet = new TreeSet<Integer>();
		
		hSet.add(new Integer(3));
		hSet.add(new Integer(1));
		hSet.add(new Integer(2));
		System.out.println(hSet.size());
		// 전체 출력 !!
		Iterator<Integer> iter = hSet.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
