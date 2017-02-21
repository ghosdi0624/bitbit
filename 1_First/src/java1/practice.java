package java1;

import java.util.Scanner;

class Employee
{
	int id;
	String name;
	int salary;
	
	int increaseMoney()
	{
		return (id*salary)/10;
	}
	int totalSalary()
	{
		return salary+increaseMoney();
	}
}

public class practice {

	public static void main(String[] args) {

		Employee[] emp = new Employee[3];
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<emp.length; i++)
		{
			emp[i] = new Employee();
			emp[i].id = i+1;
			emp[i].name = scan.next();
			emp[i].salary = scan.nextInt();
		}
		for(int i=0; i<emp.length; i++)
		{
			System.out.println("Employee[id="+emp[i].id+", name="+emp[i].name+", salary="+emp[i].salary+"]");
			System.out.println("의 연봉은 "+emp[i].totalSalary()+" 월급 인상분은 "+emp[i].increaseMoney());
		}		
	}
}
