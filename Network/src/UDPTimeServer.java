import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {

	public static void main(String[] args) {

		if(args.length != 1){
			System.out.println("args 잘못입력");
			System.exit(1);
		}
		
		int port = 0;
		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("양의정수로 입력");
			System.exit(1);
		}
		
		DatagramSocket dsock = null;
		
		try {
			System.out.println("접속 대기 상태 입니다.");
			dsock = new DatagramSocket(port);
			String line = null;
			while(true){
				byte[] buffer = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss a");
				String sdate = format.format(new Date());
				System.out.println(receivePacket.getAddress().getHostAddress()
												+" 에 현재시간 "+sdate+" 을 전송합니다.");
				
				DatagramPacket sendPacket = new DatagramPacket(
						sdate.getBytes(),
						sdate.getBytes().length,
						receivePacket.getAddress(),
						receivePacket.getPort());
				dsock.send(sendPacket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(dsock != null)
				dsock.close();
		}
		

		
		
	}

}
