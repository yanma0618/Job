package AP;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
	
	public static void main(String[] args){
		MergeInterval s = new MergeInterval();
		List<Interval> l1=new ArrayList<Interval>();
		l1.add(new Interval(1, 3));
		l1.add(new Interval(6, 9));
		l1.add(new Interval(10, 13));
		
		List<Interval> l2=new ArrayList<Interval>();
		l2.add(new Interval(1, 2));
		l2.add(new Interval(3, 7));
		l2.add(new Interval(8, 9));
		
		List<Interval> res = s.merge(l1, l2);
		for(Interval i:res){
			System.out.println("["+i.start+", "+i.end+"]");
		}
	}
	
	
	public List<Interval> merge(List<Interval> l1, List<Interval> l2){
		int idx1=0;
		int idx2=0;
		List<Interval> ret=new ArrayList<Interval>();
		boolean[] v1=new boolean[l1.size()];
		boolean[] v2=new boolean[l2.size()];
		while(idx1<l1.size() && idx2<l2.size()){
			Interval i1=l1.get(idx1);
			Interval i2=l2.get(idx2);
			if(i1.end<=i2.start){
				idx1++;
			}else if(i2.end<=i1.start){
				idx2++;
			}else{
				if(!v1[idx1]){
					ret.add(i1);
					v1[idx1]=true;
				}
				if(!v2[idx2]){
					ret.add(i2);
					v2[idx2]=true;
				}
				
				if(i1.end<=i2.end){
					idx1++;
				}else{
					idx2++;
				}
			}
		}
		return ret;
	}
}

class Interval{
	int start;
	int end;
	public Interval(int s, int e){
		start=s;
		end=e;
	}
}
