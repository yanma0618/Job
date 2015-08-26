package G;

public class SqureRoot {
	public static void main(String[] args){
		System.out.println(squreroot(9, 2));
	}
	
	static double squreroot(double num, int precise){
		double p=1;
		precise++;
		while(precise>0){
			p=p/10;
			precise--;
		}
		
		double left=0;
		double right=(num>1?num:1) + 1;
		while(right - left >= p){
			double m=(left+right)/2;
			if(m*m<=num){
				left=m;
			}else{
				right=m;
			}
		}
		return left;
	}
}
