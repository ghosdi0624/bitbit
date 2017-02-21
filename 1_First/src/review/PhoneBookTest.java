package review;

import java.io.*;
import java.util.*;

class Member {
	String name;
	String address;
	String phoneNo;

	public Member() {
		name = "";
		address = "";
		phoneNo = "";
	}

	public Member(String name, String address, String phoneNo) {
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String toString() {
		return String.format("%s/%s/%s", name, address, phoneNo);
	}
}

class ManagerMember {
	ArrayList<Member> list;

	public ManagerMember() {
		list = new ArrayList<Member>();
	}

	public void addMember(Member m) {
		list.add(m);
	}

	public void removeMember(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.compareTo(name) == 0)
				list.remove(i);
		}
	}

	public void findMember(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.compareTo(name) == 0)
				System.out.println(list.get(i));
		}
	}

	public void modifiMember(String name, String modiName, String modiAddr, String modiPhone) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.compareTo(name) == 0) {
				list.get(i).name = modiName;
				list.get(i).address = modiAddr;
				list.get(i).phoneNo = modiPhone;
			}
		}
	}

	public String toString() {
		Iterator<Member> it = list.iterator();
		String str = "";
		while (it.hasNext()) {
			str += it.next() + "\n";
		}
		return str;
	}
}

public class PhoneBookTest {

	public static void viewMenu() {
		System.out.println("========================================================");
		System.out.println("               	   	        전화번호부                                                        ");
		System.out.println("========================================================");
		System.out.println("삽입:0, 삭제:1, 찾기:2, 수정3, 전체보기:4, 파일저장:5, 프로그램종료:6");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ManagerMember manager = new ManagerMember();
		Member member;
		ArrayList<String[]> arr = new ArrayList<String[]>();
		
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		File f = new File("src/review/phone.txt");

		int choice;

		if (f.exists()) {
			System.out.println("저장된 정보를 불러옵니다.");
			try {
				fr = new FileReader("src/review/phone.txt");
				br = new BufferedReader(fr);
				String s;
				String[] str;
				String copyName;
				String copyAddr;
				String copyPhone;
				while ((s = br.readLine()) != null) {
					str = s.split("/");
					arr.add(str);
				}
				for (int i = 0; i < arr.size(); i++) {
					for (int j = 0; j < 1; j++) {
						copyName = arr.get(i)[j];
						copyAddr = arr.get(i)[j + 1];
						copyPhone = arr.get(i)[j + 2];
						member = new Member(copyName, copyAddr, copyPhone);
						manager.addMember(member);
					}
				}
			} catch (Exception e1) {

			}
		}

		while (true) {
			viewMenu();
			choice = scan.nextInt();
			scan.nextLine();
			try {
				switch (choice) {
				case 0:
					System.out.println("이름, 주소, 전화번호 순으로 입력 하세요");
					String name = scan.nextLine();
					String address = scan.nextLine();
					String phoneNo = scan.nextLine();
					member = new Member(name, address, phoneNo);
					manager.addMember(member);
					System.out.println("삽입 완료!!");
					break;
				case 1:
					System.out.println("삭제할 이름을 입력하세요");
					String deleteName = scan.next();
					manager.removeMember(deleteName);
					System.out.println("삭제 완료 !!");
					break;
				case 2:
					System.out.println("검색할 이름을 입력하세요");
					String findName = scan.next();
					manager.findMember(findName);
					break;
				case 3:
					System.out.println("수정할 사람의 이름을 입력하세요");
					String modifiName = scan.next();
					System.out.println("변경할 정보를 이름, 주소, 전화번호 순으로 입력하세요");
					String modiName = scan.next();
					String modiAddress = scan.next();
					String modiPhoneNo = scan.next();
					manager.modifiMember(modifiName, modiName, modiAddress, modiPhoneNo);
					System.out.println("변경 완료!!");
				case 4:
					System.out.println(manager);
					break;
				case 5:
					try {
						String save = manager.toString();
						fw = new FileWriter("src/review/phone.txt");
						bw = new BufferedWriter(fw);
						bw.write(save);
						bw.flush();
					} catch (Exception e) {
						System.out.println("저장할수 없습니다.");
					}
					System.out.println("저장 완료!!");
				case 6:
					System.out.println("프로그램이 종료 됩니다.");
					scan.close();
					return;
				default:
					System.out.println("정보를 다시 정확하게 입력하세요");
				}
			} catch (Exception e) {
				System.out.println("데이터를 정확하게 입력하지 않아 시스템이 종료 됩니다.");
				return;
			}
		}
	}
}
