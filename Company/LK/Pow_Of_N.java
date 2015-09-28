package LK;

public class Pow_Of_N {
	public static void main(String[] args) {
		System.out.println(pow(2,2)); //4
		System.out.println(pow(2,-2)); //0.25
		System.out.println(pow(2,0)); //1
		System.out.println(pow(2,1)); //2
		System.out.println(pow(3,3)); //27
		System.out.println(pow(-3,3)); //-27
		System.out.println(pow(-3,2)); //9
	}
	
	public static double pow(double x, int n){
		if(n==0) return 1;
		double tmp=pow(x,Math.abs(n)/2);
		double ret=0;
		if(n%2==0){
			ret= tmp* tmp;
		}else{
			ret = tmp * tmp * x;
		}
		return n>0 ? ret : 1/ret;
	}
	
}
