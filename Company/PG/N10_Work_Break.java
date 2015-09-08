package PG;

import java.util.HashSet;
import java.util.Set;

public class N10_Work_Break {
	
	public static void main(String[] args){
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("coded");
		N10_Work_Break s = new N10_Work_Break();
		System.out.print(s.wordBreak("leetcode", wordDict));
	}

	//n2
	public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp= new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int k=0;k<i;k++){
                if(dp[k] && wordDict.contains(s.substring(k,i)) ){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
