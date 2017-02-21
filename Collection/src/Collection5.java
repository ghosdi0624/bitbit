import java.util.*;

// 기본 타입이 아닌 객체타입을 TreeSEt에서 사용 방법 !!

//	1) Comparable 인터페이스의 CompareTo 메소드를 구현 (비교)
/*
class Addr implements Comparable<Addr>
{
	String name;
	String phoneNo;
	
	public Addr(String name, String no)
	{
		this.name = name;
		this.phoneNo = no;
	}
	public int compareTo(Addr o) {
		if(this.phoneNo.charAt(0) > o.phoneNo.charAt(0))
			return 1;
		else if(this.phoneNo.charAt(0) < o.phoneNo.charAt(0))
			return -1;
		else
			return 0;
	}
	
}
*/
public class Collection5 {

	public static void main(String[] args) 
	{
/*		TreeSet<Addr> ts = new TreeSet<Addr>();
		ts.add(new Addr("김철수", "010"));
		ts.add(new Addr("이철수", "011"));
		ts.add(new Addr("왕철수", "017"));
		
		Iterator<Addr> iter = ts.iterator();
		
		while(iter.hasNext())
		{
			Addr addr = iter.next();
			System.out.println(addr.name + " : " + addr.phoneNo);
		}
*/		
	}

}
