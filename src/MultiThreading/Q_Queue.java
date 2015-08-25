package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class Q_Queue {
	Queue<Integer> queue; 
	int work;
	public Q_Queue(){
		queue= new LinkedList<Integer>();
		work=0;
	}
	public synchronized void add(int v){
		
	}
	
	public synchronized int poll(){
		while(queue.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int ret=queue.poll();
		notifyAll();
		return ret;
	}
}
