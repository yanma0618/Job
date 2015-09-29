package LK;

/*
 * follow up：如果输入时Stream怎么办
 */
public class Max_Subarray {
	
	public static void main(String[] args){
		int[] nums={-1,1,2,3,4};
		System.out.println(maxSubArray(nums)); //10
	}

	public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int sum=nums[0];
        int tmp=0;
        for(int i=0;i<nums.length;i++){
            tmp+=nums[i];
            sum= Math.max(sum, tmp);
            if(tmp<0) tmp=0;
        }
        return sum;
    }
}
