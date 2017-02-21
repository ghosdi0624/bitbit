import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

//=======================================================================
// 컬렉션 프레임워크 !!
//	--> 자료구조 클래스들의 모음
//	--> C언어는 자료구조를 직접 작성 --> 생산성이 덜어진다 !!
//	--> 자료구조 : 배열, 리스트, 스택, 큐, 트리, 해쉬 
//	--> 알고리즘 : 정렬, 탐색
//=======================================================================
/*		    // --> 제너릭
		   	 Collection<E> 
		   	 	  |
		set<E>	List<E>	Queue<E>
*/
// map<k,v>
//=======================================================================
//	1) A~Z 이름을 정렬해서 출력 !! --> iterator 이용 !!
//	2) 010을 사용하지 않는 사람은 모두 010으로 전화번호 변경 !!
//	3) outputAddr --> iterator을 이용하여 다시 구현 !!
//	4) printAddr --> list.foreach를 통해서 구현 !!
//	5) 검색기능 추가
//		--> 전화번호 뒷자리로 검색 기능 추가 !!
//	6) 그룹 합치기
//=======================================================================
// ArrayList를 이용하여 2차원 배열 형태로 주소록 작성 !!
//=======================================================================
//	[][][][][][][][][]	가
//	[][][][][][][][][]	나
//	[][][][][][][][][]	다
//	[][][][][][][][][]	라
//	[][][][][][][][][]	마
//	[][][][][][][][][]	바
//	주소추가, 삭제, 검색(이름), 출력
//=======================================================================

class Addr {
	String name;
	String phoneNo;

	public Addr(String name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}

class AddressBook {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Addr> addrList;

	public AddressBook() {
		addrList = new ArrayList(10); // 기본 10개짜리 배열을 생성해라 !!
	}

	public void inputAddr() // 삽입
	{
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("전화번호: ");
		String phone = scan.nextLine();
		// 1명의 주소 생성 !!
		Addr addr = new Addr(name, phone);
		// 추가 !!
		addrList.add(addr);

	}

	public void outputAddr() // 삭제
	{
		String name = scan.nextLine();
		for (int i = 0; i < addrList.size(); i++) {
			if (addrList.get(i).name.equals(name)) {
				addrList.remove(i);
				break;
			}
		}
	}

	public void printAddr() // 출력
	{
		for (Addr addr : addrList) {
			System.out.println(addr.getName() + addr.getPhoneNo());
		}
	}

}
// 1) 전화번호 프로그램 : 주소추가, 삭제, 검색(이름), 출력 (위 내용으로)
// =======================================================================
// 콘솔 메모장 프로그램 !!
// =======================================================================
// 1) LinkedList 클래스 사용
// 2) space문자 단위로 LinkedList에 문자열을 저장 !!

// I am a boy 를 사용자가 입력후 엔터를 치면

// [I] -> [am] -> [a] -> [boy]

// 명령어 :
// a : 추가입력
// z : 마지막 단어 삭제
// x : 전체 삭제

public class Collection1 {

	public static void main(String[] args) {
		// java에서 기본적으로 제공하는 배열 클래스 : ArrayList
		// ArrayList : 동적인 배열을 추상화한 클래스 !!
		AddressBook book = new AddressBook();
		book.inputAddr();
		book.printAddr();
		book.inputAddr();
		book.printAddr();
		book.outputAddr();
		book.printAddr();

		List<AddressBook> list = new LinkedList<AddressBook>();
		list.add(new AddressBook());

		Iterator<AddressBook> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		/*
		 * LinkedList<Integer> list = new LinkedList<Integer>();
		 * 
		 * list.add(new Integer(10)); list.add(20); list.add(30); //리스트의 크기
		 * for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		 * 
		 * list.remove(0);
		 * 
		 * for (Integer integer : list) { System.out.println(integer); }
		 */

	}

}
