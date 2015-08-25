package MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer_Buffer {
	private int last=-1;
	private int[] buffer=new int[8];
	
	Lock lock=new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	
	public void add(int num){
		lock.lock();
		while(last==buffer.length-1){
			try {
				notFull.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		last++;
		buffer[last]=num;
		System.out.println("add: "+last+":"+buffer[last]);
		notEmpty.signal();
		lock.unlock();
			
	}
	
	public  int remove(){
		lock.lock();
		while(last==-1){
			try {
				notEmpty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int ret=buffer[last];
		System.out.println("remove: "+last+":"+buffer[last]);
		last--;
		notFull.signal();
		lock.unlock();
		return ret;
		
	}
}
