package SL;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Bi_direcitional_LRU<K, V> {
	DoubleLinkedList<K,V> eldest;
	DoubleLinkedList<K,V> latest;
	ConcurrentHashMap<K,DoubleLinkedList<K,V>> keyValue;
	ConcurrentHashMap<V,DoubleLinkedList<K,V>> valueKey;
	Lock lock = new ReentrantLock();
	
	public V getValue(K key){
		if(keyValue.containsKey(key)){
			return keyValue.get(key).value;
		}else{
			lock.lock();
			if(keyValue.contains(key)){
				return keyValue.get(key).value;
			}
		}
		
		
	}
	
	public K getKey(V value){
		return keyValue.get(value).key;
	}
	
	 
}

class DoubleLinkedList<K,V>{
	K key;
	V value;
	DoubleLinkedList<K,V> pre;
	DoubleLinkedList<K,V> next;
	
	public DoubleLinkedList(K key, V value){
		this.key=key;
		this.value=value;
	}
}