package G;

import java.util.HashMap;

public class Find_first_of {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b ="cb";
		System.out.println(find(a,b));
		
	}
	
	static int find(String a , String b){
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<a.length();i++){
			if(!map.containsKey(a.charAt(i))){
				map.put(a.charAt(i), i);
			}
		}
		int ret=a.length();
		for(int i=0;i<b.length();i++){
			if(map.containsKey(b.charAt(i))){
				ret=Math.min(ret, map.get(b.charAt(i)));
			}
		}
		return ret;
	}

}
