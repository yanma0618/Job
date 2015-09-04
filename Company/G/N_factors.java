package G;

import java.util.ArrayList;
import java.util.List;

public class N_factors {
	public List<Integer> generateFactors(int n){
		List<Integer> ret=new ArrayList<Integer>();
		for(int i=1;i<=(int)Math.sqrt(n);i++){
			if(n%i==0){
				ret.add(i);
				if(n/i!=i) ret.add(n/i);
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		N_factors f=new N_factors();
		List<Integer> res= f.generateFactors(4);
		for(int n:res){
			System.out.print(n+" ");
		}
	}
}
