package G;

/*
 * 第二题是一个array里面只有0-9的digits, 有一个target， 判断是否存在一种组合可以等于target。
 * eg: [6,3,1,0,5]  target=78,这个return True. 63+10+5 = 78 
 * 如果target= 636 return True. 631+0+5 = 636
 */
public class DFS_target_combination {
	public static void main(String[] args){
		int[] list={6,3,1,0,5};
		System.out.print(dfs(list,69,0));
	}
	
	public static boolean dfs(int[] nums, int target, int index){
		
		if(index==nums.length && target==0) return true;
		if(target<=0 || index==nums.length) return false;
		int value=0;
		for(int i=index;i<nums.length;i++){
			value=value*10+nums[i];
			if(dfs(nums,target-value,i+1)){
				return true;
			}
		}
		return false;
	}
}
