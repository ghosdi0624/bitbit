import java.net.URL;

public class URLInfo {

	public static void main(String[] args) {

		if(args.length != 1){
			System.out.println("args 잘못입력");
			System.exit(1);
		}
		
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (Exception e) {
			System.out.println("잘못된 URL입니다.");
			System.exit(1);
		}
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		
	}

}
