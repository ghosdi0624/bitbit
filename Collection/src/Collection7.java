//======================================================================
//	1) 전화번호부를 작성	--> TreeMap을 이용해서.. 변경 !!
//	2) 기존의 전화번호부 ( Addr 클래스)
//		--> 검색기능을 HashSet을 이용해서 구현 !!
//======================================================================

import java.util.*;

class AddrBook
{
	TreeMap<String, String> map;
	
	public AddrBook()
	{
		map = new TreeMap<String, String>();
	}
	
	public void input()
	{
		Scanner scan = new Scanner(System.in);
		
		String name = scan.nextLine();
		String phone = scan.nextLine();
		
		map.put(name, phone);
	}
	
	public void print()
	{
		NavigableSet<String> navi = map.navigableKeySet();
		
		Iterator<String> iter = navi.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(map.get(iter.next()));
		}
	}
}

public class Collection7 {

	public static void main(String[] args) 
	{

		AddrBook ab = new AddrBook();
		ab.input();
		ab.input();
		ab.input();
		ab.print();
/*		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(3, "A3");
		map.put(2, "A2");
		map.put(4, "A4");
		map.put(1, "A1");
		map.put(5, "A5");
		// TreeMap에 탐색 전용 Set을 얻어온다 !!
		NavigableSet<Integer> navi = map.navigableKeySet();
		// 오름차순
		Iterator<Integer> iter = navi.iterator();		// iterator가 map에 직접 지원하진 않지만 navi로 접근
		while(iter.hasNext())
		{
			System.out.println(map.get(iter.next()));
		}
		
		Iterator<Integer> iter1 = navi.descendingIterator();
		while(iter1.hasNext())
		{
			System.out.println(map.get(iter1.next()));
		}
*/
	}

}
