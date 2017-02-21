package DI_TEST;

public class MyCalculator {

	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public MyCalculator(Calculator calculator, int firstNum, int secondNum){
		this.calculator = calculator;
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
	void add(){
		int sum = firstNum+secondNum;
		calculator.add(firstNum, secondNum);
		System.out.println(sum);	
	}
	
	void sub(){
		int sum = firstNum-secondNum;
		calculator.sub(firstNum, secondNum);
		System.out.println(sum);
	}
	
	void mul(){
		int sum = firstNum*secondNum;
		calculator.mul(firstNum, secondNum);
		System.out.println(sum);
	}
	
	void div(){
		int sum = firstNum/secondNum;
		calculator.div(firstNum, secondNum);
		System.out.println(sum);
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
}
