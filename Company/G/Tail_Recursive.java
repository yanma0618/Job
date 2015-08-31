package G;

import java.util.ArrayList;
import java.util.List;

public class Tail_Recursive {
	public static void main(String[] args){
		System.out.println(match(6));
	}
	
	static String helper(String t1, String t2){
		return "("+t1+","+t2+")";
	}
	
	static String match(int n){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<=n;i++){
			list.add(String.valueOf(i));
		}
		
		while(list.size()>1){
			int start=0, end=list.size()-1;
			List<String> tmp= new ArrayList<String>();
			while(start<end){
				tmp.add(helper(list.get(start),list.get(end)));
				start++;
				end--;
			}
			list=tmp;
		}
		return list.get(0);
	}
}
