package SL;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {
	private  ConcurrentHashMap<String,Entry> cache;
	private long expiration;
	
	public ConcurrentCache(long expiration){
		cache=new ConcurrentHashMap<String,Entry> ();
		this.expiration=expiration;
	}
	
	public String get(String key){
		if(cache.containsKey(key)){
			Entry e= cache.get(key);
//			if(e.isExpired(expiration)){
//				cache.remove(key);
//				return null;
//			}
			return e.value;
		}
		return null;
	}
	
	public void put(String key, String value){
		Entry e=new Entry(value);
		cache.put(key, e);
	}

	{
		Thread t = new Thread(){
			public void run(){
				try{
					while(true){
						Thread.sleep(expiration);
						for(String key:cache.keySet()){
							if(cache.get(key).isExpired(expiration)){
								cache.remove(key);
							}
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
	
	
	public static void  main(String[] args){
		long time = 2*1000;
		ConcurrentCache c = new ConcurrentCache(time);
		c.put("a", "a");
		try {
			Thread.sleep(time+time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.put("b", "b");
		System.out.println(c.get("a"));
		System.out.println(c.get("b"));
	}
	
	
}

class Entry{
	String value;
	long time_stamp;

	public Entry(String value){
		this.value=value;
		this.time_stamp=System.currentTimeMillis();
	}
	
	public boolean isExpired(long expiration){
		return time_stamp+expiration < System.currentTimeMillis();
	}
	
}