import java.util.Scanner;
//=======================================================================
// 주민번호 입력 예외 클래스를 작성해라 !!
// 주민번호 : 13자리 입력받아서 유효하지 않은 주민번호이면 예외 전달 !!
// ex) 770101-1100123
//	--> 3번째 자리가 2이상 나올수 없음
//	--> 5~6번째 자리는 31까지 나와야 함 등등
//=======================================================================
// 1-100 사이의 난수를 발생
// 추출된 난수가 1-45사이에 있는 경우는 "발생된 로또 번호는 XX입니다."
// 추출된 난수가 46-100 사이에 있는 경우는 예외(LottoNumverException)을 발생시켜 처리하는 프로그램 작성
//=======================================================================
// 다음과 같은 배열을 선언 !!
// int size = scan.nextInt();
// int [] array = new int[size]; / size가 음수일 경우의 예외 발생 !!
// 1) 배열의 사용자로부터 입력 받아서 초기화 (0이 입력되면) : ZeroInputException
// 2) 배열을 전체 출력 !! : ArrayIndexOutofBoundsException !!
// 3) finally : 종료 메시지 출력
//=======================================================================
// 예외 클래스의 계층도 !!
//=======================================================================
/* 					Throwable
 						|
 					Exception
 						|
 			IOException		RumtimeException			
			-File, 입출력		-실행시간에 발생하는 예외들... NULL, ARRAY

*/
//=======================================================================
// 나이 입력 예외 처리 클래스 !!
//=======================================================================

class AgeInputException extends Exception
{
	public AgeInputException()
	{	//부모 클래스의 생성자 : exception
		super("나이는 음수일 수 없습니다.(1~255)");
	}
}

public class MainClass {

	public static void main(String[] args) {
		
		
		
		
		// getter/setter 에서 일반적으로 사용
/*		if(age<1 || age>255)
		{
			
		}
*/
/*		직접 throw를 통해서 예외를 발생시켜 전달하는 방법 !!
 * 		try
		{
			int age = key.nextInt();
			System.out.println("나이 : "+age);
			if(age<0)
			{
				AgeInputException e = new AgeInputException();
				throw e;	// throw : 예외를 발생시키고 싶을때 사용 !!
			}
		}
		catch(AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
*/		
		
		
		// 별도의 메서드에서 throw를 발생시키고 전달하는 방법 !!
		
		try
		{
			int age = readAge();
			System.out.println("나이는 : " + age);
		}
		catch(AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public static int readAge() throws AgeInputException
	{
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		if(age<1)
		{
			AgeInputException e = new AgeInputException();
			throw e;
		}
		return age;
	}
}
