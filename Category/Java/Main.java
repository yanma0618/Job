package Java;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		int[] n={1,2};
		rotate(n,1);
	}

	
	static void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0 ||k==0) return;
        k=k % nums.length;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int pos=(i+k) % (nums.length);
            res[pos]=nums[i];
        }
        nums=res;
        return;
        
    }
}
