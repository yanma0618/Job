package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void main(String[] args){
		int[] a = {0,1,0,1,0,1,0,1,0,1,0,1};
		
		System.out.println(maxone(a));
	}
	
	static int maxone(int[] nums){
		int res = 0;
		int pre=0;
		for(int n:nums){
			if(n==0) pre=0;
			else{
				pre++;
				res = Math.max(res, pre);
			}
		}
		return res;
	}
}
	
	
