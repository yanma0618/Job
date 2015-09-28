package LK;

public class Binary_search_insertion_position {

	public static void main(String[] args) {
		int[] arr={1,3,5,7};
		System.out.println(insertPos(arr, 1));  //0
		System.out.println(insertPos(arr,0)); //0
		System.out.println(insertPos(arr,6)); //3
		System.out.println(insertPos(arr, 8)); //4
		System.out.println(insertPos(arr, 2)); //1
	}
	
	public static int insertPos(int[] arr, int target){
		int ret=arr.length;
		int left=0, right=arr.length-1;
		while(left<=right){
			int m = left + (right-left)/2;
			if(target==arr[m]){
				return m;
			}
			if(target<arr[m]){
				ret=m;
				right=m-1;
			}else{
				left=m+1;
			}
		}
		return ret;
	}
	
	
	
	//
	public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int l=0, r= nums.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target) return m;
            if(nums[m]<target) l=m+1;
            else r=m-1;
        }
        return l;
    }
}
