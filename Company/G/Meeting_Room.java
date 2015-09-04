package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Meeting_Room {
	public static void main(String[] args){
		List<Schedule> s=new ArrayList<Schedule>();
		s.add(new Schedule(1, 3));
		s.add(new Schedule(2, 3));
		s.add(new Schedule(2, 5));
		s.add(new Schedule(4, 6));
		s.add(new Schedule(5, 8));
		System.out.println(count(s));
	}
	
	static int count(List<Schedule> s){
		List<Point> points=new ArrayList<Point>();
		for(Schedule t:s){
			points.add(new Point(t.start, true));
			points.add(new Point(t.end, false));
		}
		
		Collections.sort(points, new Comparator<Point>(){

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.time==o2.time){
					if(o1.isStart){
						return 1;
					}else{
						return -1;
					}
				}
				return Integer.compare(o1.time, o2.time);
			}
			
		});
		
		int ret=0;
		int num=0;
		for(Point p:points){
			if(p.isStart){
				num++;
				ret=Math.max(num,ret);
			}else{
				num--;
			}
		}
		return ret;
		
	}
}

class Schedule{
	int start;
	int end;
	public Schedule(int start, int end){
		this.start=start;
		this.end=end;
	}
}


class Point{
	int time;
	boolean isStart;
	public Point(int t, boolean i){
		time=t;
		isStart=i;
	}
}