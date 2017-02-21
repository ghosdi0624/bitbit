package Practice1125;

interface Movable{
	void moveUp();
	void moveDown();
	void moveLeft();
	void moveRight();
}

class MovablePoint implements Movable{
	int x;
	int y;
	int xSpeed;
	int ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed){
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	public String toString(){
		return String.format("MovableCircle'center & speed are MovablePoint"
							+ "[x=%d, y=%d, xSpeed=%d, ySpeed=%d]",x,y,xSpeed,ySpeed);
	}
	public void moveUp() {
		y-=ySpeed;
	}
	public void moveDown() {
		y+=ySpeed;
	}
	public void moveLeft() {
		x-=xSpeed;
	}
	public void moveRight() {
		x+=xSpeed;
	}
}

class MovableCircle implements Movable{

	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}
	public String toString(){
		return center.toString()+" radius is "+radius;
	}
	public void moveUp() {
		center.moveRight();
	}
	public void moveDown() {
		center.moveDown();
	}
	public void moveLeft() {
		center.moveLeft();
	}
	public void moveRight() {
		center.moveRight();
	}
	
}

public class hw3 {

	public static void main(String[] args) {

		MovableCircle mc1 = new MovableCircle(271, 0, 1, 1, 3);
		MovableCircle mc2 = new MovableCircle(134, 281, 2, 0, 5);
		MovableCircle mc3 = new MovableCircle(334, 132, 4, 1, 2);
		MovableCircle mc4 = new MovableCircle(348, 195, 4, 1, 4);
		
		System.out.println("이동 전 >>>>>");
		System.out.println(mc1);
		System.out.println(mc2);
		System.out.println(mc3);
		System.out.println(mc4);
		mc1.moveLeft(); mc1.moveDown();
		mc2.moveRight();
		mc3.moveUp();
		mc4.moveLeft(); mc4.moveDown();
		System.out.println("이동 후 >>>>>");
		System.out.println(mc1);
		System.out.println(mc2);
		System.out.println(mc3);
		System.out.println(mc4);
	}

}
