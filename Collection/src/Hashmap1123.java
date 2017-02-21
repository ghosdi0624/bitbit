import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student{
	int id;
	String phone;
	
	public Student(int id, String phone){
		this.id = id;
		this.phone = phone;
	}
	public String toString(){
		return id+" "+phone;
	}
}

public class Hashmap1123 {

	public static void main(String[] args) {

		HashMap<String, Integer> h = new HashMap<String, Integer>();
		
		h.put("한원선", 99);
		h.put("안홍진", 97);
		h.put("황기태", 34);
		h.put("이영희", 98);
		h.put("정원석", 70);
		
		System.out.println("HashMap의 요소 개수 : "+h.size());
		Set<String> s = h.keySet();
		Iterator<String> it = s.iterator();
		
		String name = null;
		while(it.hasNext()){
			name = it.next();
			System.out.println(name + " : "+h.get(name));
		}
//		System.out.println("한원선 : "+h.get("한원선"));
//		System.out.println("안홍진 : "+h.get("안홍진"));
//		System.out.println("황기태 : "+h.get("황기태"));
//		System.out.println("이영희 : "+h.get("이영희"));
//		System.out.println("정원석 : "+h.get("정원석"));
//		System.out.println(h.entrySet());
		System.out.println("==================================");
		
		HashMap<String, Student> h1 = new HashMap<String, Student>();
		
		h1.put("한원선", new Student(2, "010-222-2222"));
		h1.put("황기태", new Student(1, "010-111-1111"));
		h1.put("이영희", new Student(3, "010-333-3333"));
		
		System.out.println("HashMap의 요소 개수 : "+h1.size());
//		System.out.println("한원선 : "+h1.get("한원선"));
//		System.out.println("황기태 : "+h1.get("황기태"));
//		System.out.println("이영희 : "+h1.get("이영희"));
//		System.out.println(h1.entrySet());
		
		Set<String> s1 = h1.keySet();
		Iterator<String> it1 = h1.keySet().iterator();
		String name1 = null;
		while(it1.hasNext()){
			name1 = it1.next();
			System.out.println(name1+" : "+h1.get(name1));
		}
		
	}

}
