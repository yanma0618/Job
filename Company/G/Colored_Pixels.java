package G;

import java.util.Random;

public class Colored_Pixels {
	static int size=5;
	static int[][] board=new int[size][size];
	public static void main(String[] args){
		build();
		print();
		System.out.println(perimeter());
	}
	
	static void build(){
		Random r= new Random();
		for(int i=0;i<size-2;i++){
			for(int j=0;j<size-2;j++){
				board[i][j]=1;
			}
		}
		board[2][3]=1;
		board[3][3]=1;
		board[3][2]=1;
	}
	
	static void print(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int count =0;
	static boolean[][] visited=new boolean[size][size];
	static int perimeter(){
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(board[i][j]==1){
					dfs(i,j,1);
				}
			}
		}
		return count;
		
	}
	
	static void dfs(int i, int j, int p){
		if(i<0 || j<0 ||i>=size || j>=size || visited[i][j] || board[i][j]!=p) return;
		visited[i][j]=true;
		if(check(i,j)){
			count++;
		}
		dfs(i-1,j,p);
		dfs(i+1,j,p);
		dfs(i,j-1,p);
		dfs(i,j+1,p);
	}
	
	static boolean check(int i, int j){
		if(i==0 || board[i-1][j]!=board[i][j]) return true;
		if(j==0 || board[i][j-1]!=board[i][j]) return true;
		if(i==size-1 || board[i+1][j]!=board[i][j]) return true;
		if(j==size-1 || board[i][j+1]!=board[i][j]) return true;
		return false;
	}
}
