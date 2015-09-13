package SL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer<E> {
	Queue<E> queue = new LinkedList<E>();
	int size;
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	public ProducerConsumer(int size) {
		this.size = size;
	}

	public void put(E value) throws InterruptedException {
		
		lock.lock();
		try {
			while (queue.size() == size) {
				System.out.println("produce:full");
				notFull.await();

				// lock.unlock()
				// thread.sleep()
				// thread.awake();
				// lock.lock()
			}
			queue.add(value);
			
			notEmpty.signal();
		}  finally{
			lock.unlock();
		}
		

	}

	public E take() throws InterruptedException {
		lock.lock();
		try{
			while(queue.isEmpty()){
				System.out.println("consumer:empty");
				notEmpty.await();
			}
			E ret = queue.poll();
			System.out.println("consumer:"+ret);
			notFull.signal();
			
			return ret;
		}finally{
			lock.unlock();
		}
		
	}
}
