package G;

/*
 * 国人小哥。特别nice！给一个数字的array，两个数字间只用+或者* 算出最大的值。
 */
public class DP_Caculate_max_value_multiple_plus {
	public static void main(String[] args){
		int[] list={1,-2,-2};
		System.out.println(maxValue(list));
	}
	
	public static int maxValue(int[] list){
		int max=list[0];
		int min=list[0];
		for(int i=1;i<list.length;i++){
			int tmp=max;
			max=Math.max(Math.max(max+list[i],min*list[i]),max*list[i]);
			min= Math.min(Math.min(min+list[i], min*list[i]), tmp*list[i]);
		}
		return max;
	}
}
