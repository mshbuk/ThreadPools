package pgdp.threads;

public class Future {
	private boolean finish = false;
	public synchronized void get() throws InterruptedException {
		while(!finish) {
			wait();
		}
	}

	public synchronized void finish() {
		notifyAll();
		finish = true;
	}
}
