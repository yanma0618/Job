package G;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_minimize_target_location {
	public static void main(String[] args){
		char[][] board={{'*', ' '},
						{' ', ' '},
						{'*', ' '},
						{' ', ' '}};
		Graph_minimize_target_location s= new Graph_minimize_target_location();
		System.out.println(s.minCost(board));
	}
	
	public int minCost(char[][] map){
		
		int[][] dp=new int[map.length][map[0].length]; 
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j]=='*'){
					boolean[][] visited=new boolean[map.length][map[0].length];
					bfs(map,i*map.length+j,visited,dp);
				}
			}
		}
		int ret=map.length*2;
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+" ");
				if(dp[i][j]>0){
					ret=Math.min(ret,dp[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
		return ret;
	}
	
	public void bfs(char[][] map, int cord, boolean[][] visited, int[][] sum){
		int[][] dp=new int[map.length][map[0].length];
		Queue<Integer> queue = new LinkedList<Integer>();
		int len=map.length;
		queue.add(cord);
		visited[cord/len][cord%len]=true;
		int[] xdir={-1,1,0,0};
		int[] ydir={0,0,-1,1};
		while(!queue.isEmpty()){
			int cur = queue.poll();
			int r = cur/len, c=cur%len;
			for(int i=0;i<4;i++){
				int rr=r+xdir[i];
				int cc=c+ydir[i];
				if(rr <0||cc<0||rr>=len||cc>=map[0].length || visited[rr][cc] 
					||  map[rr][cc]=='#' || map[rr][cc]=='*'){
						continue;
					}
				dp[rr][cc]=1+dp[r][c];
				queue.add( (rr)*len+cc );
				visited[rr][cc]=true;
			}
			

		}
		for(int i=0;i<sum.length;i++){
			for(int j=0;j<sum[0].length;j++){
				sum[i][j]+=dp[i][j];
			}
		}
		
	}
	
	
}



//if( r > 0 && !visited[r-1][c] && map[r-1][c]!='#' && map[r-1][c]!='*'){
//	dp[r-1][c]=1+dp[r][c];
//	queue.add( (r-1)*len+c );
//	visited[r-1][c]=true;
//}
//if( c > 0 && !visited[r][c-1] && map[r][c-1]!='#' && map[r][c-1]!='*'){
//	dp[r][c-1]=1+dp[r][c];
//	queue.add( (r)*len+c-1 );
//	visited[r][c-1]=true;
//	
//}
//if( r < len-1 && !visited[r+1][c] && map[r+1][c]!='#' && map[r+1][c]!='*'){
//	dp[r+1][c]=1+dp[r][c];
//	queue.add( (r+1)*len+c );
//	visited[r+1][c]=true;
//}
//if( c < map[0].length-1 && !visited[r][c+1] && map[r][c+1]!='#' && map[r][c+1]!='*'){
//	dp[r][c+1]=1+dp[r][c];
//	queue.add( r*len+c+1 );
//	visited[r][c+1] = true;
//}