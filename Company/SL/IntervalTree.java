package SL;

import java.util.Scanner;

public class IntervalTree {
	boolean[] tree;
	int len;
	public IntervalTree(int size){
		tree=new boolean[size*2];
		this.len=size-1;
	}
	
	private void push_up(int index){
		if(index*2+1>=tree.length) return;
		if(tree[index*2+1] && tree[index*2+2]) tree[index]=true;
	}
	
	public void insert(int start, int end){
		insert(0,0,len,start,end);
		
	}
	
	private void insert(int index, int s, int e, int is,int ie){
		if(is==s && ie==e){
			tree[index]=true;
			return;
		}
		int m=s+(e-s)/2;
		if(m>=ie){
			insert(index*2+1, s,m,is,ie);
		}else if(m<is){
			insert(index*2+2,m+1,e,is,ie);
		}else{
			insert(index*2+1,s,m,is,m);
			insert(index*2+2,m+1,e,m+1,ie);
		}
		push_up(index);
	}
	
	public boolean query(int start, int end){
		return query(0,0,len,start, end);
	}
	
	private boolean query(int index, int s, int e, int is, int ie){
		if(tree[index]) return true;
		if(s==is && e==ie) return tree[index];
		int m=s+(e-s)/2;
		if(m>=ie) return query(index*2+1, s, m, is, ie);
		else if(m<is) return query(index*2+2, m+1,e,is, ie);
		return query(index*2+1,s,m,is,m) && query(index*2+2,m+1,e,m+1,ie); 
	}
	
	public static void main(String[] args) {
		// Assuming intervals are between 0 ~ 99
		IntervalTree tree=new IntervalTree(100);
		Scanner in = new Scanner(System.in);
		while (true) {
			int oper = in.nextInt();
			int s = in.nextInt();
			int e = in.nextInt();
			if (oper == 0) {
				// Insert
				tree.insert( s, e);
			} else {
				// Query
				System.out.println(tree.query(s, e));
			}
		}
	}
}


