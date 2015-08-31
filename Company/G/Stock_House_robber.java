package G;

public class Stock_House_robber {
	public static void main(String[] args){
		int[] prices={1,5,3,4,5,1,5};
		System.out.println(max_profit(prices));
	}
	
	static int max_profit(int[] prices){
		int[] l=new int[prices.length+1];
		int[] g=new int[prices.length+1];
		for(int i=1;i<prices.length;i++){
			int dif=prices[i]-prices[i-1];
			l[i+1]=Math.max(l[i]+dif, g[i-1]);
			g[i+1]=Math.max(g[i], l[i+1]);
			System.out.println("i:"+(i+1)+" g"+g[i+1]+" l"+l[i+1]);
		}
		return g[prices.length];
	}
}
