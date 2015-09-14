package SL;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Bi_direcitional_LRU<K, V> extends LinkedHashMap<K,V> {
	
	LinkedHashMap<K,V> cache;
	Lock lock = new ReentrantLock();
	int capacity;
	
	public Bi_direcitional_LRU(final int capacity){
		this.capacity=capacity;
		cache = new LinkedHashMap<K, V>(capacity){
			/**
			 * 
			 */
			private static final long serialVersionUID = 8927473639114693102L;

			@Override
			public boolean removeEldestEntry(Map.Entry<K,V> eldest){
				return size()>capacity;
			}
		};
	}
	
	public V getValue(K key){
		if(cache.containsKey(key))
			return cache.get(key);
		return load(key);
		
	}
	
	public V load(K key){
		V value =null;
		cache.put(key, value);
		return value;
	}
	
	
	
	 
}

//class DoubleLinkedList<K,V>{
//	K key;
//	V value;
//	DoubleLinkedList<K,V> pre;
//	DoubleLinkedList<K,V> next;
//	
//	public DoubleLinkedList(K key, V value){
//		this.key=key;
//		this.value=value;
//	}
//}