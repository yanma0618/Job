package SL;

import java.util.ArrayList;
import java.util.List;



public class IntervalTotalCover {
	
	List<Interv> list;
	
	public IntervalTotalCover(List<Interv> input){
		list=new ArrayList<Interv>();
		Interv pre=input.get(0);
		for(int i=1;i<input.size();i++){
			if(input.get(i).start>pre.end){
				list.add(pre);
				pre=input.get(i);
			}else{
				pre.end=Math.max(pre.end, input.get(i).end);
			}
		}
		list.add(pre);
	}
	
	public boolean query(Interv itv){
		int left=0, right=list.size()-1;
		while(left<=right){
			int m=(left+right)/2;
			if(itv.start>=list.get(m).start && itv.end<=list.get(m).end){
				return true;
			}else if(itv.end<list.get(m).start){
				right=m-1;
			}else if(itv.start>list.get(m).end){
				left=m+1;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		List<Interv> input=new ArrayList<Interv>();
		input.add(new Interv(1, 4));
		input.add(new Interv(2, 8));
		IntervalTotalCover s=new IntervalTotalCover(input);
		System.out.print(s.query(new Interv(3, 9)));
	}
	
}

class Interv{
	int start;
	int end;
	public Interv(int start, int end){
		this.start=start;
		this.end=end;
	}
}
