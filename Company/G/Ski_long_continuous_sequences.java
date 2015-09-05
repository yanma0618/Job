package G;

public class Ski_long_continuous_sequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board={{1,2,3},
				       {8,9,10}};
		Ski_long_continuous_sequences s = new Ski_long_continuous_sequences();
		System.out.print(s.long_seq(board));
	}
	
	
	public int long_seq(int[][] board){
		int res=0;
		int[][] dp = new int[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				res = Math.max(res, dfs(board, i,j,dp));
			}
		}
		return res;
	}
	
	public int dfs(int[][] board, int i, int j, int[][] dp){
		
		if(dp[i][j]>0){
			return dp[i][j];
		}
		int ret=1;
		if(i>0 && board[i-1][j]>board[i][j] ) ret=Math.max(ret,dfs(board,i-1,j, dp)+1);
		if(j>0 && board[i][j-1]>board[i][j] ) ret=Math.max(ret,dfs(board,i,j-1, dp)+1);
		if(i<board.length-1 && board[i+1][j]>board[i][j] ) ret=Math.max(ret,dfs(board,i+1,j, dp)+1);
		if(j<board[0].length-1 && board[i][j+1]>board[i][j] ) ret=Math.max(ret,dfs(board,i,j+1, dp)+1);
		dp[i][j]=ret;
		return ret;
	}

}
