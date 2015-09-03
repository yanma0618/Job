package SL;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {
	private  ConcurrentHashMap<String,String> cache=new ConcurrentHashMap<String,String> ();
	
	public String getCache(String key){
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		return putCache(key);
	}
	
	public String putCache(String key){
		String value="date from db";

		cache.put(key, value);
		return value;
	}
}
