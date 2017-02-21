import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;



public class DorianTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		FileReader in = null;
		BufferedReader br = null;
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		FileWriter out = null;
		BufferedWriter bw = null;

		String s;
		try {

			ArrayList<String[]> arr = new ArrayList<String[]>();

			String[] str = null;
			in = new FileReader("C:/dorian.txt");
			br = new BufferedReader(in);
			out = new FileWriter("src/t11.txt");
			bw = new BufferedWriter(out);
			while ((s = br.readLine()) != null) {
				str = s.split(" ");
				arr.add(str);
			}

			int l = 0;
			while (l < 10) {
				System.out.print("찾고 싶은 단어는 ? ");
				String word = scan.next();
				int count = 0;
				for (int i = 0; i < arr.size(); i++) {
					for (int j = 0; j < arr.get(i).length; j++) {
						if (arr.get(i)[j].equals(word))
							count++;
					}
				}
				tm.put(word, count); // 트리맵에 k,v 담기
				// String total = word+" : "+count+" 번 출현..";
				// bw.write(total);
				// bw.newLine();
				// bw.flush();
				System.out.println(count + " 번 출현");
				l++;
			}

			NavigableSet<String> navi = tm.navigableKeySet();
			Iterator<String> it = navi.iterator();
			String next = null;
			String total = null;
			while (it.hasNext()) {
				next = it.next(); // String에 next담아서 다음으로 넘어가지 않게..
				total = next + " : " + tm.get(next) + " 번 출현..";
				bw.write(total);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
