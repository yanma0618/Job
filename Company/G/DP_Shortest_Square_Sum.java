package G;

public class DP_Shortest_Square_Sum {
	public static void main(String[] args){
		System.out.println(fun(14));
		System.out.println(solution(14));
	}
	
	static int fun(int n){
		int[] helper= new int[n+1];
		for(int i=1;i<=n;i++){
			int num=1;
			int j=i;
			int min=i+1;
			while(j>=num*num){
				min=Math.min(min,helper[j-num*num])+1;
				num++;
			}
			helper[i]=min;
			System.out.println(i+":"+min);
		}
		return helper[n];
	}
	
	static int solution(int n){
		int[] dp=new int[n+1];
		for(int i=1;i<=n;i++){
			int k=1;
			int min=i+1;
			while(i>=k*k){
				min=Math.min(min, dp[i-k*k]+1);
				k++;
			}
			dp[i]=min;
			System.out.println(i+":"+min);
		}
		return dp[n];
	}
}
