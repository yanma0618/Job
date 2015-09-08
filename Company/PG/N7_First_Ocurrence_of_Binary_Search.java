package PG;

public class N7_First_Ocurrence_of_Binary_Search {
	public static void main(String[] args){
		int[] n={0,1,3,4,4,5,6,6,6,7,9};
		N7_First_Ocurrence_of_Binary_Search s= new N7_First_Ocurrence_of_Binary_Search();
		System.out.print(s.first(n,1));
	}
	
	public int first(int[] n, int target){
		int left=0;
		int right=n.length-1;
		int ret=-1;
		while(left<=right){
			int m=(left+right)/2;
			if(n[m]==target){
				ret=m;
				right=m-1;
			}else if(n[m]>target){
				right=m-1;
			}else{
				left=m+1;
			}
		}
		return ret;
	}
}
