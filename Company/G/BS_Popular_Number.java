package G;

public class BS_Popular_Number {
	public static void main(String[] args){
		int[] n = {1,1,2,2,2,3,3,4};
		
		System.out.println(solution(n));
	}
	
	static int solution(int[] num){
		for(int i=0;i<=4;i++){
			int target=num[(i*(num.length-1))/4];
			int left=search_left(num,0,num.length-1,target);
			int right=search_right(num,0,num.length-1,target);
			System.out.println("target"+target+", left"+left+", right"+right);
			if((right-left+1)>(num.length/4)){
				return target;
			}
		}
		
		return -1;
	}
	
	static int search_left(int[] num, int start, int end, int target){
		int ret=-1;
		while(start<=end){
			int m = (start+end)/2;
			if(num[m]>=target){
				if(num[m]==target){
					ret=m;
				}
				end=m-1;
			}else{
				start=m+1;
			}
		}
		return ret;
	}
	
	static int search_right(int[] num, int start, int end, int target){
		int ret=-1;
		while(start<=end){
			int m = (start+end)/2;
			if(num[m]<=target){
				if(num[m]==target){
					ret=m;
				}
				start=m+1;
			}else{
				end=m-1;
			}
		}
		return ret;
	}
}
