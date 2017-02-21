import java.io.IOException;

public class RunningProcess {

	public static void main(String[] args) {
		
		try {
			Process proc = Runtime.getRuntime().exec("java FirstAWTExitEvent");
			proc.waitFor();
			
			if(proc.exitValue()==0)
				System.out.println("잘 종료되었군!");
			else
				System.out.println("무엇인가 문제가 있어!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
