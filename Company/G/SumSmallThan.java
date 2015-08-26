package G;

import java.util.Arrays;

public class SumSmallThan {
	public static void main(String[] args){
		int[] list={7, 2, 5, 1, 6, 3};
		System.out.println(pairs(list,5));
	}
	
	static int pairs(int[] list, int sum){
		int count=0;
		int left=0, right=list.length-1;
		Arrays.sort(list);
		while(left<right){
			if(list[left]+list[right]>sum){
				right--;
			}else {
				count+=right-left;
				left++;
			}
		}
		return count;
	}
}
