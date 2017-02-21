package java1;

class Cal
{
	int a, b;
	public Cal(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public void add()
	{
		System.out.println(a+b);
	}
	public void sub()
	{
		System.out.println(a-b);
	}
	public void mul()
	{
		System.out.println(a*b);
	}
	public void div()
	{
		System.out.println(a/b);
	}
}

public class Calculator {

	public static void main(String[] args) {

		Cal c1 = new Cal(4,2);
		c1.add();
		c1.sub();
		c1.mul();
		c1.div();
		
	}

}
