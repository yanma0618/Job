package SL;

import java.io.FileFilter;
import java.util.concurrent.Semaphore;

public class Pool_Semaphore {
	private static final int MAX_AVAILABLE=100;
	private final Semaphore available= new Semaphore(MAX_AVAILABLE, true);
	
	
	protected Object[] items = new Object[MAX_AVAILABLE];
	protected boolean[] used= new boolean[MAX_AVAILABLE];
	
	public  Object getItem() throws InterruptedException{
		available.acquire();
		return getNextAvailableItem();
	}
	
	public void putItem(Object x){
		if(markAsUnused(x)){
			available.release();
		}
	}
	
	private boolean markAsUnused(Object x){
		for(int i=0;i<items.length;i++){
			if(items[i]==x){
				if(used[i]){
					used[i]=false;
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	private Object  getNextAvailableItem(){
		for(int i=0;i<items.length;i++){
			if(!used[i]){
				used[i]=true;
				return items[i];
			}
		}
		return null;
	}
}
