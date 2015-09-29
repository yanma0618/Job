package LK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Minimum_distance_word_list {
	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	public static void main(String[] args){
		
		Minimum_distance_word_list s = new Minimum_distance_word_list();
		String[] strs={"a","b","c","f","a","c","b","f"};
		System.out.println(s.min_dis(strs, "b", "f"));
		System.out.println(s.min_dis_multi_query(strs, "b", "f"));
	}
	
	public int min_dis(String[] strs, String a, String b){
		int idxa=-1, idxb=-1;
		int min = strs.length;
		for(int i=0;i<strs.length;i++){
			if(strs[i].equals(a)){
				if(idxb!=-1){
					min = Math.min(min, Math.abs(i-idxb));
				}
				idxa=i;
			}else if(strs[i].equals(b)){
				if(idxa!=-1){
					min = Math.min(min, Math.abs(i-idxa));
				}
				idxb=i;
			}
		}
		return min;
	}
	
	public void preprocess(String[] strs){
		for(int i=0;i<strs.length;i++){
			if(map.containsKey(strs[i])){
				map.get(strs[i]).add(i);
			}else{
				List<Integer> tmp=new ArrayList<Integer>();
				tmp.add(i);
				map.put(strs[i], tmp);
			}
		}
	}
	
	public  int min_dis_multi_query(String[] strs, String a, String b){
		preprocess(strs);
		List<Integer> lista=map.get(a);
		List<Integer> listb=map.get(b);
		int idxa=0, idxb=0;
		int min=strs.length;
		while(idxa<lista.size() && idxb<listb.size()){
			min = Math.min(min, Math.abs(lista.get(idxa)-listb.get(idxb)));
			if(lista.get(idxa)< listb.get(idxb)){
				idxa++;
			}else{
				idxb++;
			}
		}
		return min;
	}
}
