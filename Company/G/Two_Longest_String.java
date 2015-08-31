package G;

import java.util.HashMap;

public class Two_Longest_String {
	public static void main(String[] args){
		String[] strs={"abc","def","defg"};
		strs=find(strs);
		for(String s:strs){
			System.out.println(s);
		}
	}
	
	static String[] find(String[] strs){
		int max=0;
		String[] ret = new String[2];
		HashMap<String , Integer> map = helper(strs);
		for(int i=0;i<strs.length;i++){
			for(int j=i+1;j<strs.length;j++){
				if( (map.get(strs[i]) & map.get(strs[j]))==0){
					if(strs[i].length() * strs[j].length()>max){
						ret[0]=strs[i];
						ret[1]=strs[j];
						max=strs[i].length() * strs[j].length();
					}
				}
			}
		}
		return ret;
	}
	
	static HashMap<String , Integer> helper(String[] s){
		HashMap<String , Integer> map=new HashMap<String, Integer>();
		for(String str:s){
			int val=0;
			for(int i=0;i<str.length();i++){
				val |= 1<<(str.charAt(i)-'a');
			}
			map.put(str, val);
			System.out.println(str+""+val);
		}
		return map;
	}
}

