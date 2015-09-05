package G;

import java.util.Random;

public class Minesweeper {
	static char[][] board;
	final static int size= 10;
	public static void main(String[] args){
		build(20);
		print();
	}
	
	static void print(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print( board[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	static void build(int n){
		board=new char[size][size]; 
		int[] mark=new int[size*size];
		for(int i=0;i<mark.length;i++){
			mark[i]=i;
		}
		Random r = new Random();
		int index=mark.length;
		for(int i=0;i<n;i++){
			int pos=r.nextInt(index);
			swap(mark,pos,--index);
		}
		
		for(int i=mark.length-1;i>=mark.length-n;i--){
			int tmp=mark[i];
			board[tmp/size][tmp%size]='*';
		}
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(board[i][j]=='*') continue;
				board[i][j]=calMines(i,j);
			}
		}
		
	}
	
	static char calMines(int i, int j){
		int count=0;
		count+=helper(i-1,j);
		count+=helper(i-1,j-1);
		count+=helper(i-1,j+1);
		count+=helper(i,j-1);
		count+=helper(i,j+1);
		count+=helper(i+1,j-1);
		count+=helper(i+1,j);
		count+=helper(i+1,j+1);	
		return (char)(count+'0');
	}
	
	static int helper(int i, int j){
		if(i<0 || j<0 ||i>=size || j>=size || board[i][j]!='*'){
			return 0;
		}
		return 1;
		
	}
	
	static void swap(int[] n, int i , int j){
		int tmp=n[i];
		n[i]=j;
		n[j]=tmp;
	}
}


