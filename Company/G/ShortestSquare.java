package G;

public class ShortestSquare {
	public static void main(String[] args){
		System.out.println(fun(14));
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
}
