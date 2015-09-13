package SL;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/*
 * time lease cache, 
 * multi thread
 */
public class ConcurrentTTLCache<K,V extends IValue> {
	long time=5*1000;
	HashMap<K, V> cache=new HashMap<K,V>();
	
	//1 single thread
	public V get_1(K key){
		V value=null;
		if(cache.containsKey(key) && !cache.get(key).isExpired()){
			value = cache.get(key);
		}else{
			value =load(key);
		}		
		return value;
	}
	
	//2 multi thread, for get method, lock(key)
	ConcurrentHashMap<K,ReentrantLock> keyLock=new ConcurrentHashMap<K, ReentrantLock>();
	public V get(K key){
		ReentrantLock lock = keyLock.putIfAbsent(key, new ReentrantLock());
		lock.lock();
		V value=null;
		if(cache.containsKey(key) && !cache.get(key).isExpired()){
			value = cache.get(key);
		}else{
			value =load(key);
		}
		
		lock.unlock();
		return value;
	}
	
	//3 
	public V get_3(K key){
		V value=null;
		if(cache.containsKey(key) && !cache.get(key).isExpired()){
			value = cache.get(key);
		}else{
			ReentrantLock lock = keyLock.putIfAbsent(key, new ReentrantLock());
			lock.lock();
			if(cache.containsKey(key) && !cache.get(key).isExpired()){
				value = cache.get(key);
			}else{
				value =load(key);
			}
			lock.unlock();
		}
		
		
		return value;
		
	}
	
	public V load(K key){
		//locd value;
		V value=null;
		return value;
	}
	
	{
		Thread thread=new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(K key:cache.keySet()){
						if(cache.get(key).isExpired()){
							cache.remove(key);
						}
					}
				}
				
			}
		};
		thread.start();
	}
}

