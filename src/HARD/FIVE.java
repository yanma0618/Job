package HARD;

public class FIVE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,7,9};
		int t=3;
		System.out.println(search(t,arr));
	}
	static int search(int target, int[] arr){
		int h=0, l=arr.length-1;
		int res = Integer.MAX_VALUE;
		int m;
		while(h<=l){
			m=(h+l)/2;
			res=Math.min(res, Math.abs(target-arr[m]));
			if(target<arr[m]) l=m-1;
			else h=m+1;
		}
		return res;
		
	}
}
