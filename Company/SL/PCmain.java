package SL;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class PCmain {
	public static void main(String[] args){
//		final ProducerConsumer<Integer> queue=new ProducerConsumer<Integer>(4);
		final BlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(4);
		
		class Producer implements Runnable{
			String name;
			Producer(String name){
				this.name=name;
			}
			@Override
			public void run() {
				int loop=1;
				while(loop<10){
					try {
						System.out.print(name+" ");
						queue.put(loop++);
						System.out.println("produce:"+(loop-1));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		class Consumer implements Runnable{
			@Override
			public void run() {
				while(true){
					try {
						
						int ret=queue.take();
						System.out.println("consumer:"+(ret));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		new Thread(new Producer("p1")).start();
		new Thread(new Producer("p2")).start();
		new Thread(new Consumer()).start();
		
	}
}
