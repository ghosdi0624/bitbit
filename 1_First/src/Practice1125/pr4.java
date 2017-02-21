package Practice1125;

class MyPoint{
	private int x = 0;
	private int y = 0;
	
	public MyPoint(){
		
	}
	public MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int[] getXY(){
		int[] xy = new int[2];
		return xy;
	}
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	public double distance(int x, int y){
		return Math.sqrt((Math.pow((this.x-x),2)+Math.pow((this.y-y),2)));
	}
	public double distance(MyPoint another){
		return Math.sqrt((Math.pow((this.x-another.x),2)+Math.pow((this.y-another.y),2)));
	}
	public double distance(){
		return Math.sqrt((Math.pow((this.x-0),2)+Math.pow((this.y-0),2)));
	}
}

public class pr4 {

	public static void main(String[] args) {

		MyPoint mp1 = new MyPoint(1,1);
		MyPoint mp2 = new MyPoint(3,4);
		
		System.out.println(mp1+"와 "+mp2+"의 거리는"+mp1.distance(mp2));
		System.out.println(mp2+"와 원점과의 거리는 "+mp2.distance());
		
	}

}
