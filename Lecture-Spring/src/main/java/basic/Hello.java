package basic;

public class Hello {
	
	private String msg;
	
	public Hello(){
		System.out.println("로딩완료...");
		msg = "Hello";
	}
	
	public void printMsg(){
		System.out.println("msg : " + msg);
	}
}
