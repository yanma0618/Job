package Math;

import java.util.LinkedList;
import java.util.Queue;

public class Getkthmagic {
	public int getkthmagic(int k){
		if(k<=0) return 0;
		Queue<Integer> q3=new LinkedList<Integer>();
		Queue<Integer> q5=new LinkedList<Integer>();
		Queue<Integer> q7=new LinkedList<Integer>();
		q3.add(3);
		q5.add(5);
		q7.add(7);
		int val=1;
		for(--k;k>0;--k){
			val=Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
			if(val == q7.peek()){
				q7.poll();
			}else{
				if(q5.peek()==val){
					q5.poll();
				}else{
					q3.poll();
					q3.add(val*3);
				}
				q5.add(val*5);
			}
			q7.add(val*7);
		}
		return val;
	}
}
