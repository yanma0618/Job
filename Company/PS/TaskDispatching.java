package PS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task {
	int i;

	public void run() {
		System.out.println(i);
	}
}

public class TaskDispatching {
	Queue<Task> queue = new LinkedList<Task>();
	boolean isTrigger = false;
	Lock lock = new ReentrantLock();

	public void trigger() {
		isTrigger = true;//2
		lock.lock(); //3
		while (queue.isEmpty()) {
			queue.poll().run();
		}
		lock.unlock();
		isTrigger=false;
	}

	public void addTask(Task task) {
		if (isTrigger) { 
			task.run();
		} else {		//1
			lock.lock();//4
			queue.add(task);
			lock.unlock();
		}
	}
}
