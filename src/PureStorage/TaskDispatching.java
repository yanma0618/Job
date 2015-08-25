package PureStorage;

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
		isTrigger = true;
		lock.lock();
		while (queue.isEmpty()) {
			queue.poll().run();
		}
		lock.unlock();
	}

	public void addTask(Task task) {
		if (isTrigger) {
			task.run();
		} else {
			lock.lock();
			queue.add(task);
			lock.unlock();
		}
	}
}
