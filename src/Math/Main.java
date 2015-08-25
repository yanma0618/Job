package Math;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Getkthmagic gm=new Getkthmagic();
		System.out.println(gm.getkthmagic(13));
	}
	 public static int divide(int dividend, int divisor) {
	        if(divisor==0) return 0;
	        int a=Math.abs(dividend);
	        int b=Math.abs(divisor);
	        int product=0;
	        int count=0;
	        while((product+b)<=a){
	            int x=b;
	            int multi=1;
	            while((product+x)<=a){
	                product = product+x;
	                count = count+multi;
	                x =x+x;
	                multi=multi+multi;
	            }
	        }
	        int sign=1;
	        if(dividend<0) sign*=-1;
	        if(divisor<0) sign*=-1;
	        return count*sign;
	        
	    }

}
