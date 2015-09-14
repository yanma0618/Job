package SL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryHashMap<K,V> {
	HashMap<K, List<Pair<V>>> map =new HashMap<K,List<Pair<V>>>();
	
	public void put(K key,V value, long time){
		List<Pair<V>> his=null;
		if(map.containsKey(key)){
			his=map.get(key);
		}else{
			his=new ArrayList<Pair<V>>();
			map.put(key, his);
		}
		his.add(new Pair<V>(value, time));
	}
	
	public V get(K key, long ts) {
		V ret=null;
		if (map.containsKey(key)) {

			List<Pair<V>> his = map.get(key);
			int left = 0;
			int right = his.size() - 1;
			
			while (left <= right) {
				int m = (left + right) / 2;

				if (ts <= his.get(m).time) {
					ret=his.get(m).value;
					right=m-1;
				}else {
					left=m+1;
				}
			}
		}
		return ret;
	}
	
	
	public static void main(String[] args){
		HistoryHashMap<String,String> hhm=new HistoryHashMap<String,String>();
		hhm.put("1","1",1);
		hhm.put("3","3",3);
		hhm.put("3","5",5);
		hhm.put("3","3",7);
		hhm.put("7","7",9);
		System.out.println(hhm.get("3", 2));
	}
	
}

class Pair<V>{
	V value;
	long time;
	public Pair(V value, long time){
		this.value=value;
		this.time=time;
	}
}
