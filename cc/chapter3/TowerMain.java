package chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class TowerMain {
	public static void main(String[] args){
		Tower[] t=new Tower[3];
		int n=3;
		for(int i=0; i<3;i++){
			t[i]=new Tower(i);
		}
		for(int i=n-1;i>=0;i--){
			t[0].add(i);
		}
		//t[0].movedisks(n, t[2], t[1]);
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(1);
		System.out.println(q);
	}
}
