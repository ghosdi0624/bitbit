
public interface GeneralBook {
	public int size();
	public void records();
	public boolean nameExist(String name);
	void add(String name, String record);
	void remove(String name, String record);
	String get(String name);
	String find(String record);
	void print();
}
