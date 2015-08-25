package Moderate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import HARD.maxHeapComparator;

public class Heap {
	public void sort(int[] arr){
		maxHeapComparator max=new maxHeapComparator();
		PriorityQueue<Integer> q=new PriorityQueue<Integer>(20, max);
		for(int item:arr){
			q.offer(item);
		}
		System.out.println(q.toString());
		int index=0;
		while(!q.isEmpty()){
			arr[index++]=q.poll();
		}
		for(int item:arr){
			System.out.print(item+" ");
		}
	}
	
	public int[] ksmallest(int[] arr, int k){
		int[] res=new int[k];
		create(arr, arr.length);
		int len=arr.length;
		for(int i=0;i<k;i++){
			res[i]=arr[0];
			arr[0]=arr[len-1];
			--len;
			adjust(arr, len, 0);
		}
		return res;
	}
	
	public void adjust(int[] heap, int length, int i){
		int left=2*i+1;
		int right=2*i+2;
		int tmp;
		int big=i;
		while(left<length || right <length){
			if(left<length && heap[left]>heap[big]){
				big=left;
			}
			if(right<length && heap[right]>heap[big]){
				big=right;
			}
			if(big==i) break;
			tmp=heap[i];
			heap[i]=heap[big];
			heap[big]=tmp;
			i=big;
			left=2*i+1;
			right=2*i+2;
		}
	}
	
	public void create(int[] heap, int length){
		for(int i=length/2-1; i>=0;i--){
			adjust(heap, length, i);
		}
	}
}
