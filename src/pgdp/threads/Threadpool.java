package pgdp.threads;

import java.lang.reflect.Array;
import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {
	Thread[] workers;
	LinkedBlockingQueue<Task> queue;

	public Threadpool(int numWorkers) throws IllegalArgumentException {
		if(numWorkers <= 0) {
			throw new IllegalArgumentException("Should be more than 0");
		}

		queue = new LinkedBlockingQueue<>();
		workers = new Thread[numWorkers];

		Runnable worker = () -> {

			try {
				Task task = queue.take();
				task.getRunnable().run();
				task.getFuture().finish();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Thread(worker);
			workers[i].start();
		}
	}

	public Future submit(Runnable job) {
		// TODO
		return null;
	}

	public void shutdownNow() {
		// TODO
	}
}
