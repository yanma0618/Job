package G;

public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list={1, 4, 20, 3, 10, 5};
		
		int[] res=subarraySum(list, 33);
		System.out.println(res[0]);
		System.out.println( res[1]);
	}
	
	static int[] subarraySum(int[] list, int target){
		int cur_sum=list[0];
		int[] res=new int[2];
		int left=0;
		int right=1;
		while(right<list.length){
			while(cur_sum>target && left<right){
				cur_sum-=list[left++];
			}
			if(cur_sum==target){
				res[0]=left;
				res[1]=right-1;
				return res;
			}
			cur_sum+=list[right++];
			
		}
		return null;
	}

}
