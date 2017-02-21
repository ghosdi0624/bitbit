import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

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
				String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("전송받은 문자열 : "+msg);
				if(msg.equals("quit"))
					break;
				
				DatagramPacket sendPacket = new DatagramPacket(
						receivePacket.getData(),
						receivePacket.getData().length,
						receivePacket.getAddress(),
						receivePacket.getPort());
				dsock.send(sendPacket);
			}
			System.out.println("UDPEchoServer를 종료 합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(dsock != null)
				dsock.close();
		}
		

		
		
	}

}
