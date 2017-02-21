
public class GeneralBookAssign {

	public static void main(String[] args) {
		
		String[] names = {"Sam","Rhee","Kim"};
		String[] records = {"1111","2222","3333"};
		
		ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);
		
		gb.remove("Sam", "1111");
		gb.print();
		System.out.println(gb.get("Rhee"));
		
		
		
		
		
		
	}

}
