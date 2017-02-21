package Practice1125;

class MyCircle{
	private MyPoint center = new MyPoint(0,0);
	private int radius = 1;
	
	public MyCircle(){
		super();
	}
	public MyCircle(int x, int y, int radius){
		this.center.setX(x);
		this.center.setY(y);
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public MyCircle(MyPoint center, int radius){
		this.center = center;
		this.radius = radius;
	}
	public MyPoint getCenter() {
		return center;
	}
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	public int getCenterX(){
		return this.center.getX();
	}
	public void setCenterX(int x){
		this.center.setX(x);
	}
	public int getCenterY(){
		return this.center.getY();
	}
	public void setCenterY(int y){
		this.center.setX(y);
	}
	public int[] getCenterXY(){
		return this.center.getXY();
	}
	public void setCenterXY(int x, int y){
		this.center.setXY(x,y);
	}
	public String toString(){
		return this.getClass()+"[radius="+this.radius+", center="+center.toString()+"]";
	}
	public double getArea(){
		return radius*radius*Math.PI;
	}
	public double getCircumference(){
		return radius*2*Math.PI;
	}
	public double distance(MyCircle another){
		return Math.sqrt((Math.pow((this.center.getX()-another.center.getX()),2)+Math.pow((this.center.getY()-another.center.getY()),2)));
	}
}
public class pr5 {

	public static void main(String[] args) {

		MyPoint mp1 = new MyPoint(1,1);
		MyPoint mp2 = new MyPoint(3,4);
		MyCircle mc1 = new MyCircle(mp1, 2);
		MyCircle mc2 = new MyCircle(mp2, 2);
		
		System.out.println(mc1.distance(mc2));
		System.out.println(mc1);
		System.out.println(mc2);
		
	}

}
