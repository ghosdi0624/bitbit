import java.util.Calendar;
import java.util.Scanner;

interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}
interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

class PhoneInfo
{
	String name;
	String phoneNum;
	
	public PhoneInfo(String name, String phoneNum)
	{
		this.name=name;
		this.phoneNum=phoneNum;
	}
	public void showPhoneInfo()
	{
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNum);
	}
}

class PhoneUnivInfo extends PhoneInfo
{
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String phone, String major, int year)
	{
		super(name,phone);
		this.major=major;
		this.year=year;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}

class PhoneCompanyInfo extends PhoneInfo
{
	String company;
	
	public PhoneCompanyInfo(String name, String phone, String company)
	{
		super(name,phone);
		this.company=company;
	}
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("company : "+company);
	}
}

class PhoneBookManager
{
	final int MAX_CNT=100;
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curCnt=0;
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst()
	{
		if(inst==null)
			inst = new PhoneBookManager();
		return inst;
	}
	private PhoneBookManager(){}
	private PhoneInfo readBasic()
	{
		System.out.print("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.scan.nextLine();
		return new PhoneInfo(name, phone);
	}
	private PhoneInfo readUniv()
	{
		System.out.print("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.scan.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer.scan.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer.scan.nextInt();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	private PhoneInfo readCompany()
	{
		System.out.print("이름 : ");
		String name = MenuViewer.scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.scan.nextLine();
		System.out.print("직장 : ");
		String job = MenuViewer.scan.nextLine();
		return new PhoneCompanyInfo(name, phone, job);
	}
	
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택 >> ");
		int choice = MenuViewer.scan.nextInt();
		MenuViewer.scan.nextLine();
		
		PhoneInfo pi = null;
		switch(choice)
		{
		case INPUT_SELECT.NORMAL: pi = readBasic();	break;
		case INPUT_SELECT.UNIV:	pi = readUniv();	break;
		case INPUT_SELECT.COMPANY:	pi = readCompany();	break;
		}
		infoStorage[curCnt++] = pi;
		System.out.println("데이터 입력이 완료 되었습니다...");
	}
	public void findData()
	{
		System.out.println("데이터 검색을 시작합니다..");
		
		System.out.print("이름 : ");
		String name = MenuViewer.scan.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			infoStorage[dataIdx].showPhoneInfo();
			System.out.println("데이터 검색이 완료 되었습니다.");
		}
	}
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다..");
		
		System.out.print("이름 : ");
		String name = MenuViewer.scan.nextLine();
		
		int dataIdx = search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
		}
		else
		{
			for(int i=dataIdx; i<(curCnt-1); i++)
			{
				infoStorage[i]=infoStorage[i+1];
			}
			curCnt--;
			System.out.println("데이터 삭제가 완료 되었습니다. \n");
		}
	}
	private int search(String name)
	{
		for(int i=0; i<curCnt; i++)
		{
			PhoneInfo curInfo = infoStorage[i];
			if(name.compareTo(curInfo.name)==0)
				return i;
		}
		return -1;
	}
}

class MenuViewer
{
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 : ");
	}
}
public class PhoneBook {
	
	public static void main(String[] args) {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		int choice;
		
		
		while(true)
		{
			MenuViewer.showMenu();
			choice = MenuViewer.scan.nextInt();
			MenuViewer.scan.nextLine();
			switch(choice)
			{
				case INIT_MENU.INPUT : manager.inputData();	break;
				case INIT_MENU.SEARCH : manager.findData();	break;
				case INIT_MENU.DELETE : manager.deleteData();	break;
				case INIT_MENU.EXIT : System.out.println("프로그램을 종료 합니다.."); return;
				default : System.out.println("다시 입력해 주세요"); break;
			}
		}
				
	}

}
