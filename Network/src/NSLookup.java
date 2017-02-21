import java.net.*;

public class NSLookup {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("IP주소나 도메인 주소를 인자로 지정하세요.");
			System.exit(0);
		}
		
		InetAddress inetaddr[] = null;
		
		try {
			inetaddr = InetAddress.getAllByName(args[0]);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<inetaddr.length; i++){
			System.out.println(inetaddr[i].getHostName());
			System.out.println(inetaddr[i].getHostAddress());
			System.out.println(inetaddr[i].toString());
			System.out.println("--------------------------------------------");
		}
		System.out.println(inetaddr.length);
	}

}
