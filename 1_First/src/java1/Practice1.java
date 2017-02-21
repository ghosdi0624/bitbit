package java1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// -는 private, +는 public, :오른쪽은 리턴타입, getLength는 둘레,

class Point{
	private int x = 0;
	private int y = 0;
	
	public Point(){
		
	}
	public Point(int x, int y){
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
	public String toString(){
		return "("+x+","+y+")";
	}
	public double distance(int x, int y){
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
	public double distance(Point another){
		return Math.sqrt(Math.pow(this.x-another.x, 2)+Math.pow(this.y-another.y, 2));
	}
	public double distance(){
		return Math.sqrt(Math.pow(0-x, 2)+Math.pow(0-y, 2));
	}
}

class PolyLine{
	private List<Point> points;
	
	public PolyLine(){
		points = new ArrayList<Point>();
	}
	public PolyLine(List<Point> points){
		points = new ArrayList<Point>();
		this.points = points;
	}
	public void appendPoint(int x, int y){
		points.add(new Point(x, y));
	}
	public void appendPoint(Point point){
		points.add(new Point(point.getX(), point.getY()));
	}
	public String toString(){
		Iterator<Point> it = points.iterator();
		String str = "";
		while(it.hasNext())
		{
			str += it.next();
		}
		return "{"+str+"}";
	}
	public double getLength(){
		double sum = 0;
		
		for(int i = 0; i<points.size(); i++)
			 sum += points.get(i).distance(points.get((i+1)%(points.size())));
		
		
//		for(int i = 0; i<points.size()-1; i++)
//		 sum += points.get(i).distance(points.get(i+1));
//		sum += points.get(points.size()-1).distance(points.get(0));
		
		
//		for(int i=0; i<points.size(); i++){
//			sum += p.distance(points.get(i));
//			p = points.get(i);
//			p.setXY(p.getX(),p.getY());
//			if(i==points.size()-1){
//				p = points.get(0);
//				p.setXY(p.getX(),p.getY());
//				sum += p.distance(points.get(i));
//				break;
//			}
//		}
		return sum;
	}
}

public class Practice1 {

	public static void main(String[] args) {

		Point p = new Point(0,0);
		Point p1 = new Point(0,4);
		Point p2 = new Point(3,0);
		
		System.out.println(p1.distance(p2));
		System.out.println(p2.distance());
		System.out.println("======================");
	
		PolyLine po = new PolyLine();
		po.appendPoint(p);
		po.appendPoint(p1);
		po.appendPoint(p2);
		System.out.println(po+"다각형의 둘레는 : "+po.getLength());
		
		PolyLine pol = new PolyLine();
		pol.appendPoint(p);
		pol.appendPoint(p1);
		pol.appendPoint(p2);
		pol.appendPoint(3,4);
		System.out.println(pol+"다각형의 둘레는 : "+pol.getLength());
	}

}

