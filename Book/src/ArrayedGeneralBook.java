public class ArrayedGeneralBook implements GeneralBook {

	private String[] names;
	private String[] records;

	public ArrayedGeneralBook(String[] names, String[] records) {
		this.names = names;
		this.records = records;
	}

	public int size() {
		return names.length;
	}

	public void names() {
		for (int i = 0; i < names.length; i++)
			System.out.print(names[i]);
	}

	public void records() {
		for (int i = 0; i < names.length; i++)
			System.out.println(records[i]);
	}

	public boolean nameExist(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == name)
				return true;
		}
		return false;
	}

	public void add(String name, String record) {
		int num = size();
		String[] temp = new String[num + 1];
		String[] temp1 = new String[num + 1];
		for (int i = 0; i < names.length; i++) {
			if (names[i].compareTo(name) == 0) {
				System.out.println("해당 이름이 존재 합니다.");
				return;
			}
		}
		for (int i = 0; i < names.length; i++) {
			temp[i] = names[i];
			temp1[i] = records[i];
		}
		temp[num] = name;
		temp1[num] = record;

		names = temp;
		records = temp1;
	}

	public void remove(String name, String record) {
		int num = size();
		String[] temp = new String[num - 1];
		String[] temp1 = new String[num - 1];
		for (int i = 0; i < names.length; i++) {
			if (names[i].compareTo(name) == 0) {
				for (int j = i; j < (names.length) - 1; j++) {
					temp[j] = names[j + 1];
					temp1[j] = records[j + 1];
				}
				break;
			} else {
				temp[i] = names[i];
				temp1[i] = records[i];
			}
		}
		names = temp;
		records = temp1;
	}

	public String get(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == name)
				return records[i];
		}
		return "해당 이름이 없습니다";
	}

	public String find(String record) {
		for (int i = 0; i < names.length; i++) {
			if (records[i] == record)
				return names[i];
		}
		return "해당 기록이 없습니다";
	}

	public void print() {
		String temp;
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < i; j++) {
				if (names[i].compareTo(names[j]) < 0) {
					temp = names[i];
					names[i] = names[j];
					names[j] = temp;
					temp = records[i];
					records[i] = records[j];
					records[j] = temp;
				}
			}
		}
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " " + records[i]);
			System.out.println("");
		}
	}

}
