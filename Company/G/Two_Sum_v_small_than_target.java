package G;

import java.util.Arrays;

/*
 * 烙印大叔。 给一个array 和一个 target求出 array里有几组tuple相加是小于等于target的。
 */
public class Two_Sum_v_small_than_target {
	public static void main(String[] args){
		int[] list={1,2,3,5,6,7};
		Arrays.sort(list);
//		System.out.println(pairs(list,5,0));
		System.out.println(kpairs(list,0,3,10));
	}
	
	static int pairs(int[] list, int sum, int start){
		int count=0;
		int left=start, right=list.length-1;
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
	
	static int kpairs(int[] list, int start, int k, int sum){
		int count=0;
		if(k<=2){
			return pairs(list,sum,start);
		}
		for(int i=start;i<list.length-k+1;i++){
			count+=kpairs(list,i+1,k-1,sum-list[i]);
		}
		return count;
	}
}
