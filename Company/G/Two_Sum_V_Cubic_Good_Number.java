package G;

import java.util.ArrayList;
import java.util.List;

public class Two_Sum_V_Cubic_Good_Number {
	public static void main(String[] args){
		List<Integer> res = solution(126);
		for(int n:res){
			System.out.println(n);
		}
	}
	
	static List<Integer> solution(int n){
		List<Integer> res= new ArrayList<Integer>();
		List<Integer> c= new ArrayList<Integer>();
		for(int i=1;i*i*i<n;i++){
			c.add(i*i*i);
		}
		int l=0,r=c.size()-1;
		while(l<r){
			if(c.get(l)+c.get(r)>n){
				r--;
			}else{
				for(int i=l+1;i<=r;i++){
					res.add(c.get(l)+c.get(i));
				}
				l++;
			}
			
		}
		return res;
	}
}
