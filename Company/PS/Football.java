package PS;

import java.util.ArrayList;
import java.util.List;

public class Football {
	static List<List<Integer>> res;
	static int[] scores;
	public static void main(String[] args){
		
		scores=new int[4];
		scores[0]=3;scores[1]=6;scores[2]=7;scores[3]=8;
		System.out.println(countNum(24));
		
		count(24);
		
		for(List<Integer> list:res){
			for(int n:list){
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println(res.size());
	}
	
	static int countNum(int score){
		int[] dp=new int[score+1];
		dp[0]=1;
		for(int i=3;i<=score;i++){
			int val=0;
			for(int sc:scores){
				if(i-sc>=0){
					val+=dp[i-sc];
				}
			}
			dp[i]=val;
		}
		return dp[score];
		
	}
	
	static void count(int score){
		res=new ArrayList<List<Integer>>();
		
		helper(score, new ArrayList<Integer>());
	}
	
	static void helper(int remain, List<Integer> cur){
		if(remain==0){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if(remain<0) return;
		for(int score:scores){
			if(remain-score>=0){
				cur.add(score);
				helper(remain-score,cur);
				cur.remove(cur.size()-1);
			}
		}
		
	}
}
