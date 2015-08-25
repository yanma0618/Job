package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class SortAnagram {
	public ArrayList<String> sortana(ArrayList<String> ori){
		Hashtable<String, ArrayList<String>> ht=new Hashtable<String, ArrayList<String>>();
		for(int i=0;i<ori.size();i++){
			String cur=ori.get(i);
			String sorted=sortstring(cur);
			if(ht.containsKey(sorted)){
				ht.get(sorted).add(cur);
			}else{
				ht.put(sorted, new ArrayList<String>(Arrays.asList(cur)));
			}
		}
		ArrayList<String> res=new ArrayList<String>();
		for(ArrayList<String> item : ht.values()){
			res.addAll(item);
		}
		return res;
	}
	
	public String sortstring(String s){
		char[] ch=s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
