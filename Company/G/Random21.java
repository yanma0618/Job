package G;

import java.util.Random;

public class Random21 {
	public static void main(String[] args){
		Random r=new Random();
		System.out.println(r.nextInt(5)*5+r.nextInt(5));
	}
}
