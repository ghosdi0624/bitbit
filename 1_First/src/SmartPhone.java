interface MobilePhone
{
	public boolean sendCall();
	public boolean receiveCall();
	public boolean sendSMS();
	public boolean receriveSMS();
}
interface MP3{
	public void play();
	public void stop();
}
class PDA{
	public int calculate(int x, int y){
		return x+y;
	}
}


public class SmartPhone extends PDA implements MobilePhone, MP3{

	public boolean sendCall() {
		System.out.println("전화걸기");
		return true;
	}
	public boolean receiveCall() {
		System.out.println("전화받기");
		return true;
	}
	public boolean sendSMS() {
		System.out.println("SMS 보내기");
		return true;
	}
	public boolean receriveSMS() {
		System.out.println("SMS 받기");
		return true;
	}
	public void play() {
		System.out.println("음악 재생");
	}
	public void stop() {
		System.out.println("재생 중지");
	}
	public void schedule(){
		System.out.println("일정 관리");
	}
	public void applicationManager(){
		System.out.println("앱 설치/삭제");
	}
	
	public static void main(String[] args) {

	}

}
