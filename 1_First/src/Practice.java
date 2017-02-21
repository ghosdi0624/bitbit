class Point {
	int x;
	int y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Shape {
	Point p;

	public Shape() {
		this(new Point(0, 0));
	}

	public Shape(Point p) {
		this.p = p;
	}

	public void setPosition(Point p) {
		this.p = p;
	}
	
	public Point getPosition() {
		return p;
	}
	public double calcArea() {
		return 0;
	}
}

class Circle extends Shape {
	public double r;
	private final double PI = Math.PI;

	public Circle(double r)
	{
		this.r = r;
	}
	public double calcArea() {
		return r*r*PI;
	}
}

class Rectangle extends Shape {
	public double width;
	public double height;

	public Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	public double calcArea() {
		return width * height;
	}
}

public class Practice {

	public static void main(String[] args) {

		Circle c1 = new Circle(5.0);
		Rectangle r1 = new Rectangle(3,4);
		Circle c2 = new Circle(1);
		
		System.out.println(c1.calcArea()+r1.calcArea()+c2.calcArea());
		
		Shape[] arr = {new Circle(5.0),new Rectangle(3,4),new Circle(1)};
		
		double sum=0;
		
		for(int i=0; i<arr.length; i++)
		{
			sum+=arr[i].calcArea();
		}
		
		System.out.println(sum);
		
		
	}

}
