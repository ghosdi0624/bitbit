// -는 private, +는 public, :오른쪽은 리턴타입, getLength는 둘레,

class Point1{
	private int x = 0;
	private int y = 0;
	
	public Point1(){
		
	}
	public Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){return x;}
	public void setX(int x){this.x = x;}
	public int getY(){return y;}
	public void setY(int y){this.y = y;}
	public int[] getXY(){
		int[] arr = new int[2];
		arr[0] = this.x;
		arr[1] = this.y;
		return arr;
	}
	public void setXY(int x, int y){
		this.x=x; this.y=y;
	}
	public String toSting(){
		return "("+x+","+y+")";
	}
	public double distance(int x, int y){
		return x+y;
	}
	public double distance(Point1 another){
		return (another.x)+(another.y);
	}
	public double distance(){
		return 0;
	}
}


public class Practice {

	public static void main(String[] args) {

		
		Point1 p1 = new Point1(1,1);
		Point1 p2 = new Point1(3,4);
		
		System.out.println(p1.distance(p2));
	}

}
