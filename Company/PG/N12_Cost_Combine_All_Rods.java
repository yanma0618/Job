package PG;

import java.util.PriorityQueue;

public class N12_Cost_Combine_All_Rods {
	public static void main(String[] args){
		int[] n={3,4,6,12};
		N12_Cost_Combine_All_Rods s = new N12_Cost_Combine_All_Rods();
		System.out.print(s.cal(n));
	}
	
	public int cal(int[] n){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(n.length);
		for(int tmp:n){
			queue.add(tmp);
		}
		int ret=0;
		while(queue.size()>1){
			int sum=queue.poll()+queue.poll();
			ret+=sum;
			queue.add(sum);
		}
		return ret;
	}
}
