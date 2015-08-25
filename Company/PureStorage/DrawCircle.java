package PureStorage;

import java.util.ArrayList;
import java.util.List;


public class DrawCircle {
	public static void main(String[] args){
		List<Point> res = draw(5);
		print(res);
	}
	static void print(List<Point> circle){
		for(Point point:circle){
			System.out.println("x:"+point.x+", y:"+point.y);
		}
	}
	static List<Point> draw (int r){
		List<Point> res=new ArrayList<Point>();
		int x=0, y=r;
		while(x<=r){
			if(x*x+y*y==r*r){
				res.add(new Point(x,y));
				if(x!=0&&y!=0) res.add(new Point(0-x,y));
				res.add(new Point(0-x,0-y));
				if(x!=0&&y!=0) res.add(new Point(x,0-y));
				x++;y--;
			}else if(x*x+y*y<r*r){
				x++;
			}else{
				y--;
			}
		}
		
		return res;
	}
}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}