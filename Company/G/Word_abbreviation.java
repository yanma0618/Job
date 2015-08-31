package G;

import java.util.ArrayList;
import java.util.List;

public class Word_abbreviation {
	static List<String> res;
	public static void main(String[] args){
		res= new ArrayList<String>();
		String s="abbreviation";
		dfs(s,0,"");
		for(String str:res){
			System.out.print(str+" ");
		}
	}
	
	static void dfs(String str, int index, String cur){
		if(index==str.length()){
			res.add(helper(cur));
			return;
		}
		dfs(str,index+1,cur+"1");
		dfs(str,index+1,cur+str.charAt(index));
	}
	
	static String helper(String s){
		int i=0;
		StringBuilder sb = new StringBuilder();
		while(i<s.length()){
			if(s.charAt(i)!='1'){
				sb.append(s.charAt(i++));
			}else{
				int count=0;
				while(i<s.length() && s.charAt(i)=='1'){
					count++;
					i++;
				}
				sb.append(count);
			}
		}
		return sb.toString();
	}
}
