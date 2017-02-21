package java1;

class Person{
	String name;
	String id;
	Person(String name){
		this.name = name;
	}
}

class Student extends Person{
	String grade;
	String department;
	
	Student(String name){
		super(name);
	}
}
public class Upcasting {

	public static void main(String[] args) {

		Student stu1 = new Student("ÄÚ³­");
		stu1.grade = "A";
		stu1.department = "CS";
		stu1.id = "11111";
		
		Person p1 = stu1;
		System.out.println(p1.name);
		System.out.println(p1.id);
		
		Student stu2;
		stu2 = (Student)p1;
		
		
		
		
	}

}
