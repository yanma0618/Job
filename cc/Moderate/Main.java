package Moderate;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* guess 
		String solution="RGGB"; 
		Scanner in = new Scanner(System.in);
		int[] res=new int[2];
		estimate es=new estimate();
		while(in.hasNext()){
			String guess=in.next();
			res=es.run(solution, guess);
			System.out.println("hit: "+res[0]+", pes: "+res[1]);
		}
		*/
		
	/*	NumtoString ns=new NumtoString();
		System.out.println(ns.run(123312123));  
	 */
	/*	Biclose bi=new Biclose();
		int[] arr={1,2,8,15,25};
		int[] brr={4,10,19};
		//assert bi.run(arr, brr)==bi.
		assert bi.mergesearch(arr, brr)==2;
		assert bi.binarysearch(arr, brr)==bi.mergesearch(arr, brr);
	*/
		Heap hp = new Heap();
		int[] arr={95,34,54,31,76,66,45,33,78};
		hp.sort(arr);
	/* 
	 * select kth smallest number from input stream
	 
		Heap hp=new Heap();
		int[] arr={95,34,54,31,76,66,45,33,78};
		//hp.sort(arr);
		int k=4;
		int[] max_heap=Arrays.copyOf(arr, k);
		hp.create(max_heap, k);
		for(int i=4;i<arr.length;i++){
			if(arr[i]>=max_heap[0]) continue;
			max_heap[0]=arr[i];
			hp.adjust(max_heap, k, 0);
		}
		for(int i:max_heap){
			System.out.print(i+" ");
		}
	*/
	}
	
	

}
