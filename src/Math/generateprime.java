package Math;

import java.util.ArrayList;

public class generateprime {
	boolean[] generate(int max){
		boolean[] flags=new boolean[max+1];
		for(int i=0;i<=max;i++) flags[i]=true;
		int prime=2;
		while(prime<=Math.sqrt(max)){
			crossoff(prime, flags);
			prime=getnextprime(flags,prime);
			if(prime>max) break;
		}
		return flags;
	}
	
	void crossoff(int prime, boolean[] flags){
		for(int i=prime*prime; i<flags.length;i+=prime){
			flags[i]=false;
		}
	}
	
	int getnextprime(boolean[] flags, int prime){
		int i=prime+1;
		while(i<flags.length && !flags[i]){
			i++;
		}
		return i;
	}
	
	
	
}
