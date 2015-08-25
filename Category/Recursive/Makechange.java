package Recursive;

import java.util.ArrayList;

public class Makechange {
	ArrayList<ArrayList<Integer>> res;
	int way=0;
	public ArrayList<ArrayList<Integer>> dfsmakechange(int[] money, int n){
		res = new ArrayList<ArrayList<Integer>>();
		dfs(money, n, 0);
		return res;
	}
	public int dpmakechange(int[] money, int n){
		int[][] dp=new int[n+1][money.length];
		return dpmakechange(money, n, 0, dp);
	}
	public void dfs(ArrayList<Integer> cur,int[] money, int amount, int index){
		if(amount<0) return;
		if(amount == 0) {
			res.add(new ArrayList<Integer>(cur));
			way++;
			return;
		}
		for(int i=index;i<money.length;i++){
			cur.add(money[i]);
			dfs(cur,money, amount-money[i], i);
			cur.remove(cur.size()-1);
		}
	}
	public int dpmakechange(int[] money, int amount, int index, int[][] dp) {
		if(dp[amount][index]>0) return dp[amount][index];
		int res=0;
		if(index>=money.length-1) return 1;
		for(int i=0;i*money[index]<=amount;i++){
			res+=dpmakechange(money, amount-i*money[index], index+1, dp );
		}
		dp[amount][index]=res;
		return res;
	}
	
	
	public void dfs(int[] money, int n, int index){
		if(n==0) way++;
		if(n<0) return;
		for(int i=index;i<money.length;i++){
			dfs(money, n-money[i], i);
		}
	}
}
