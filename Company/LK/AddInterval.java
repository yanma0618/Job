package LK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddInterval {
	
	public static void main(String[] args){
		List<Interval> list=new ArrayList<Interval>();
		list.add(new Interval(3,4));
		list.add(new Interval(8,9));
		list.add(new Interval(1,8));
		AddInterval s= new AddInterval();
		System.out.println(s.addInterval(list));
	}
	
	public int addInterval(List<Interval> list){
		Collections.sort(list, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
			
		});
		
		
		Interval pre= list.get(0);
		int res=list.get(0).end-list.get(0).start+1;
		for(int i=1;i<list.size();i++){
			if(list.get(i).start<=pre.end){
				pre.end=Math.max(pre.end, list.get(i).end);
			}else{
				res = Math.max(res, pre.end-pre.start+1);
				pre=list.get(i);
			}
		}
		res = Math.max(res, pre.end-pre.start+1);
		return res;
	}
}

class Interval{
	int start;
	int end;
	
	public Interval(int s, int e){
		this.start=s;
		this.end=e;
	}
}
