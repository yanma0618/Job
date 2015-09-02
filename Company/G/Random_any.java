package G;

import java.util.Random;

public class Random_any {
	static Random r=new Random();
	public static void main(String[] args){
		for(int i=0;i<30;i++)
//			System.out.println(five_seven());
			System.out.print(two_six()+" ");
	}
	
	static int five_seven(){
		while(true){
			int n = r.nextInt(5)*5+ r.nextInt(5);
			if(n<21){
				return n%7+1;
			}
		}
	}
	
	static int two_six(){
		while(true){
			int n=( r.nextInt(2)*2 + r.nextInt(2) ) + r.nextInt(2)*4;
			if(n<6){
				return n+1;
			}
		}
	}
}
