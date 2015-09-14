package SL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PairSet {
	public List<Set<Integer>> find(List<Set<Integer>> sets){
		HashMap<Integer,List<Set<Integer>>> map=new HashMap<Integer,List<Set<Integer>>>();
		
		for(Set<Integer> set:sets){
			Iterator<Integer> itr=set.iterator();
			while(itr.hasNext()){
				int key=itr.next();
				if(map.containsKey(key)){
					map.get(key).add(set);
				}else{
					List<Set<Integer>> tmp=new ArrayList<Set<Integer>>();
					tmp.add(set);
					map.put(key, tmp);
				}
			}
		}
		HashSet<Set<Integer>> visited=new HashSet<Set<Integer>>();
		List<Set<Integer>> ret = new ArrayList<Set<Integer>>();
		for(int key:map.keySet()){
			if(map.get(key).size()>1){
				for(Set<Integer> set:map.get(key)){
					if(!visited.contains(set)){
						ret.add(set);
						visited.add(set);
					}
				}
			}
			
			
		}
		return ret;
	}
	
	public static void main(String[] args){
		Set<Integer> set;
		List<Set<Integer>> sets=new ArrayList<Set<Integer>>();
		for(int i=0;i<3;i++){
			set = new HashSet<Integer>();
			for(int j=0;j<3;j++){
				set.add(new Random().nextInt(20));
			}
			sets.add(set);
		}
		PairSet s = new PairSet();
		
		List<Set<Integer>> ret =s.find(sets); 
		System.out.println(ret);
		
	}
}

