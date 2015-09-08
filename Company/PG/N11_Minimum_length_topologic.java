package PG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N11_Minimum_length_topologic {
	
	public static void main(String[] args){
		N11_Minimum_length_topologic s = new N11_Minimum_length_topologic();
		String[] str={"gcd", "jd", "fcj"};
		System.out.print( s.convert(str));
	}
	
	 
	public String convert(String[] strs){
		HashMap<Character, Integer> map=new HashMap<Character,Integer>();
		List<CPair> list=new ArrayList<CPair>();
		for(String str:strs){
			char pre=str.charAt(0);
			if(!map.containsKey(pre)){
				map.put(pre, 0);
			}
			for(int i=1;i<str.length();i++){
				
				char cur=str.charAt(i);
				list.add(new CPair(pre, cur));
				
				if(map.containsKey(cur)){
					map.put(cur, map.get(cur)+1);
				}else{
					map.put(cur, 1);
				}
				pre=cur;
			}
		}
		
		Queue<Character> queue=new LinkedList<Character>();
		StringBuilder sb=new StringBuilder();
		for(Character c:map.keySet()){
			if(map.get(c)==0) queue.add(c);
		}
		
		while(!queue.isEmpty()){
			char c=queue.poll();
			sb.append(c);
			for(CPair cp:list){
				if(cp.c1==c){
					int num=map.get(cp.c2)-1;
					map.put(cp.c2, num);
					if(num==0){
						queue.add(cp.c2);
					}
				}
			}
		}
		return sb.toString();
	}
}

class CPair{
	char c1;
	char c2;
	public CPair(char c1, char c2){
		this.c1=c1;
		this.c2=c2;
	}
}
