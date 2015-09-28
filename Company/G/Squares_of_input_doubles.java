package G;

/*
 * given sorted array of doubles, return the another sorted array of doubles where all elements are the squares from the input array， 然后optimize一下到O(n)。
 */
public class Squares_of_input_doubles {
	public static void main(String[] args){
		double[] list={-5,-2,0,1,4};
		double[] ret=cal(list);
		for(double d:ret){
			System.out.print(d+" ");
		}
	}
	
	public static double[] cal(double[] list){
		double[] ret= new double[list.length];
		int left=0, right=list.length-1;
		int idx=ret.length-1;
		while(left<=right){
			if(list[left]*list[left]<list[right]*list[right]){
				ret[idx--]=list[right]*list[right];
				right--;
			}else{
				ret[idx--]=list[left]*list[left];
				left++;
			}
		}
		return ret;
	}
}
