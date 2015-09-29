package LK;

import java.util.ArrayList;
import java.util.List;

public class Factors {
	public static void main(String[] args){
		System.out.println(factor(24));
	}
	
	public static List<String> factor(int n){
		List<String> res =new ArrayList<String>();
		res.add(n+"");
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%i!=0) continue;
			
			List<String> remain=factor(n/i);
			for(String str:remain){
				res.add(i+"*"+str);
			}
		}
		return res;
	}
	
}
