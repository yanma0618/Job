package PG;

import java.util.Deque;
import java.util.LinkedList;

public class N8_Max_Array {

	public static void main(String[] args) {
		int[] list={1, 2, 5, 10, 3, 4};
		N8_Max_Array s= new N8_Max_Array();
		
		int[] ret=s.minArray(list, 3);
		for(int n:ret){
			System.out.print(n+" ");
		}
	}
	

	public int[] minArray(int[] list, int k){
		int[] ret=new int[list.length-k+1];
		int index=0;
		Deque<Integer> deq=new LinkedList<Integer>();
		
		for(int i=0;i<list.length;i++){
			while(!deq.isEmpty() && list[i]<list[deq.getLast()]){
				deq.removeLast();
			}
			deq.addLast(i);
			if(deq.getFirst()==i-k){
				deq.removeFirst();
			}
			if(i>=k-1){
				ret[index++]=list[deq.getFirst()];
			}
		}
//		while(index<list.length){
//			ret[index++]=list[deq.getFirst()];
//		}
		return ret;
	}
	
	public int[] maxArray(int[] list, int k){
		int[] ret=new int[list.length];
		int index=0;
		Deque<Integer> deq=new LinkedList<Integer>();
		
		for(int i=0;i<list.length;i++){
			while(!deq.isEmpty() && list[i]>list[deq.getLast()]){
				deq.removeLast();
			}
			deq.addLast(i);
			if(deq.getFirst()==i-k){
				deq.removeFirst();
			}
			if(i>=k-1){
				ret[index++]=list[deq.getFirst()];
			}
		}
		while(index<list.length){
			ret[index++]=list[deq.getFirst()];
		}
		return ret;
	}
}
