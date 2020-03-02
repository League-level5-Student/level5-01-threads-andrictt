package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue;
	public ThreadPool(int number) {
		// TODO Auto-generated constructor stub
		threads = new Thread[number];
		taskQueue = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < number; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}
	public void addTask(Task a) {
		taskQueue.add(a);
	}
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for(int i = 0; i <threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
