import java.io.File;

public class FileClassTest2 {

	public static void dir(File fd) {
		String[] filenames = fd.list();
		for (String s : filenames) {
			File f = new File(fd, s);
			long t = f.lastModified(); // 마지막으로 수정된 시간
			System.out.print(s);
			System.out.print("\t파일크기 : " + f.length()); // 파일크기
			System.out.printf("\t수정한 시간 : %tb %td %ta %tT\n", t, t, t, t);
		}
	}

	public static void main(String[] args) {

		File f2 = new File("C:/My_Test_dir");
		File f3 = new File("src");

		String res;
		if (!f2.exists()) {
			if (!f2.mkdirs()) {
				System.out.println("디렉토리 생성 실패");
			}
		}

		if (f2.isFile()) {
			res = "파일";
		} else {
			res = "디렉토리";
		}
		System.out.println(f2.getPath() + "은" + res);
		
//		dir(f3);
		f2.renameTo(new File("C:/My_Test_dir_change"));

	}

}
