package G;

import java.util.HashMap;

public class Plus_Minus_Game {
	HashMap<String, Boolean> map = new HashMap<String, Boolean>();   
	
	public boolean Judge(char[] ch){
		String tmp=String.valueOf(ch);
		if(map.containsKey(tmp)){
			return map.get(tmp);
		}
		int i=0;
		while(i<ch.length-1){
			if(ch[i]=='-' && ch[i+1]=='-'){
				ch[i]='+';
				ch[i+1]='+';
				boolean ret=Judge(ch);
				ch[i]='-';
				ch[i+1]='-';
				if(!ret){
					map.put(tmp, true);
					return true;
				}
			}
			i++;
		}
		map.put(tmp, false);
		return false;
	}
	
	
	public static void main(String[] args){
		Plus_Minus_Game s= new Plus_Minus_Game();
		String str="----+++++++++++++++++++------------------+++++----++++++-------+++++++++++++++++++------------------+++++----++++++---";
		System.out.println(s.Judge(str.toCharArray()));
	}
	
	
}
