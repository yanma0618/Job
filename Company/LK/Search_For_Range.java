package LK;

public class Search_For_Range {
	public static void main(String[] args){
		int[] nums={2,2,4,8,8,8};
		Search_For_Range s= new Search_For_Range();
		int[] ret= s.searchRange(nums,8);
		System.out.println(ret[0]+" "+ret[1]);
	}
	
	public int[] searchRange(int[] nums, int target) {
        int[] ret= new int[2];
        ret[0]=sleft(nums, target);
        ret[1]=sright(nums,target);
        return ret;
    }
    
    public int sleft(int[] nums, int target){
        int left=0, right=nums.length-1;
        int ret=-1;
        while(left<=right){
            int m = (left+right)/2;
            if(target<=nums[m]){
                if(target==nums[m]){
                    ret=m;
                }
                right=m-1;
            }else{
                left=m+1;
            }
        }
        return ret;
    }
    
    public int sright(int[] nums, int target){
        int left=0, right=nums.length-1;
        int ret=-1;
        while(left<=right){
            int m = (left+right)/2;
            if(target>= nums[m]){
                if(target==nums[m]){
                    ret = m ;
                }
                left=m+1;
            }else{
                right=m-1;
            }
            
        }
        return ret;
    }
}
