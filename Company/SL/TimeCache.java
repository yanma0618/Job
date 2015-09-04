package SL;

import java.util.HashMap;

public class TimeCache {
	private HashMap<String,String> cacheMap ;
	long expiredTime;
	public TimeCache(){
		cacheMap = new HashMap<String, String>();
	}
	
	public TimeCache(long et){
		cacheMap = new HashMap<String, String>();
		expiredTime = et;
	}
	public void set(final String key, String value){
		cacheMap.put(key,value);
		Thread t = new Thread(){
			public void run(){
				try{
					Thread.sleep(expiredTime);
				}catch(Exception e){
					e.printStackTrace();
				}
				cacheMap.remove(key);
			}
		};
		t.start();
		
	}
	
	public String get(String key){
		String ret =cacheMap.get(key);
		return ret;
	}
	
	public static void main(String[] args){
		long time=2*1000;
		TimeCache tc = new TimeCache(time);
		tc.set("java","javac");
		
		 try
         {
                 Thread.currentThread();
				 Thread.sleep(time+1);
         }
         catch (InterruptedException e)
         {
                 e.printStackTrace();
         }
		 tc.set("c","ritche");
         System.out.println(tc.get("java"));
         System.out.println(tc.get("c"));
	}
	
}
