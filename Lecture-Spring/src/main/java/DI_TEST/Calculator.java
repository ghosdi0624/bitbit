package DI_TEST;

public class Calculator {

	void add(int firstNum, int secondNum){
		System.out.print("µ¡¼À°á°ú : "+firstNum + " + " + secondNum + " = ");
	}
	void sub(int firstNum, int secondNum){
		System.out.print("»¬¼À°á°ú : "+firstNum + " - " + secondNum + " = ");
	}
	void mul(int firstNum, int secondNum){
		System.out.print("°ö¼À°á°ú : "+firstNum + " * " + secondNum + " = ");
	}
	void div(int firstNum, int secondNum){
		System.out.print("³ª´°¼À°á°ú : "+firstNum + " / " + secondNum + " = ");
	}
}
