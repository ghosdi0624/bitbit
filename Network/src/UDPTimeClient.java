import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTimeClient {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("사용법 : java UDPEchoClient ip port");
			System.exit(1);
		}
		String ip = args[0];
		int port = 0;
		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println("port번호는 양의정수로 입력");
			System.exit(1);
		}

		InetAddress inetaddr = null;

		try {
			inetaddr = InetAddress.getByName(ip);
		} catch (Exception e) {
			System.out.println("잘못된 도메인이나 ip입니다");
			System.exit(1);
		}

		DatagramSocket dsock = null;
		try {
			dsock = new DatagramSocket();
			String line = null;
			DatagramPacket sendPacket = new DatagramPacket(
					"".getBytes(),
					"".getBytes().length,
					inetaddr,
					port);
			dsock.send(sendPacket);
			
			byte[] buffer = new byte[200];
			DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
			dsock.receive(receivePacket);
			String msg = new String(receivePacket.getData(),0,receivePacket.getData().length);
			System.out.println("서버로 부터 전달받은 시간 : "+msg.trim());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dsock != null)
				dsock.close();
		}

	}

}
