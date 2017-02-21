import java.util.Vector;

import java.util.Iterator;

public class Iterator1123 {

	public static void main(String[] args) {

		Vector<Integer> v = new Vector<Integer>();
		
		v.add(1);
		v.add(2);
		v.add(100);
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
