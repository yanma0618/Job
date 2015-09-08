package PG;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class N2_K_Most_Frequently_Occuring_Number {
	
	
	public static void main(String[] args){
		N2_K_Most_Frequently_Occuring_Number s = new N2_K_Most_Frequently_Occuring_Number();
		int[] list = {3,3,4,2,2,2,4,4,6,6,6,6,6,6};
		int[] res=s.topK(list, 3);
		for(int n:res){
			System.out.print(n+" ");
		}
		
	}
	
	public int[] topK(int[] list, int k){
		HashMap<Integer, Pair> map = new HashMap<Integer,Pair>();
		for(int n:list){
			if( map.containsKey(n)){
				map.get(n).freq+=1;
			}else{
				map.put(n, new Pair(n,1));
			}
		}
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
			public int compare(Pair p1, Pair p2){
				return p1.freq-p2.freq;
			}
		});
		
		int i=0;
		for(Pair p:map.values()){
			if(i<k){
				queue.add(p);
			}else{
				if(p.freq> queue.peek().freq){
					queue.poll();
					queue.add(p);
				}
			}
			i++;
		}
		int[] ret = new int[k];
		i=0;
		while(!queue.isEmpty()){
			ret[i++]=(queue.poll().val);
		}
		return ret;
	}
}

class Pair{
	int val;
	int freq;
	public Pair(int v, int f){
		this.val=v;
		this.freq=f;
	}
}
