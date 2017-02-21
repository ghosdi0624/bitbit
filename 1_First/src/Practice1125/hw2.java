package Practice1125;

interface GeometricObject{
	public abstract double getPerimeter();
	public abstract double getArea();
}
interface Resizable{
	public abstract void resize(int percent);
}

class Circle implements GeometricObject{
	protected double radius = 1.0;
	
	public Circle(double radius){
		this.radius = radius;
	}
	public double getPerimeter(){
		return radius*2*Math.PI;
	}
	public double getArea(){
		return radius*radius*Math.PI;
	}
	public String toString(){
		return String.format("%s[radius=%.1f, area=%.2f, perimeter=%.2f]",
							this.getClass(),radius,getArea(),getPerimeter());
	}
}

class ResizableCircle extends Circle implements Resizable{
	public ResizableCircle(double radius){
		super(radius);
	}
	public void resize(int percent){
		radius = radius-radius*((double)percent/100);
	}
}

public class hw2 {

	public static void check(Circle c){

		if(c instanceof Resizable){
			System.out.println("리싸이즈 가능...");
			((Resizable) c).resize(20);
			System.out.println(c);
		}
		else{
			System.out.println("리싸이즈 불가...");
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
			
		Circle c1 = new Circle(1.0);
		Circle c2 = new ResizableCircle(2.0);
		ResizableCircle c3 = new ResizableCircle(3.0);
		
		check(c1);
		check(c2);
		check(c3);		
	}

}
