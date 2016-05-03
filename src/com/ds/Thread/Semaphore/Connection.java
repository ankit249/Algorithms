package com.ds.Thread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 
 * Semaphore can be counted, while mutex can only count to 1.
 * 
 * Suppose you have a thread running which accepts client connections. This thread can handle 5 clients simultaneously.
 * Then each new client sets the semaphore until it reaches 5. When the Semaphore has 5 permits, then your thread won't
 * accept new connections
 * 
 * Mutex are usually used for guarding stuff. Suppose your 5 clients can access multiple parts of the system. Then you
 * can protect a part of the system with a mutex so when 1 client is connected to that sub-system, no one else should
 * have access. You can use a Semaphore for this purpose too. A mutex is a "Mutual Exclusion Semaphore".
 */

// semaphores are used for controlling or limiting the access to a resource
// semaphores have available permit, acquire uses the permit and release - relinquish the permit
// semaphore with 1 permit is like a reentrant lock, although the difference is locks has to be release by the same thread
// create a singleton connection class
public class Connection {

	private static Connection instance = new Connection();

	// 10 permits available
	// true - depicts the fairness, the thread which is waiting first will get the connection first
	// Enforcing fairness comes at a performance / concurrency penalty, so don't enable it unless you need it.
	private Semaphore sem = new Semaphore(10, true);

	private Connection() {
	}

	public static Connection getInstance() {
		return instance;
	}

	private int totalConnections;

	public void connect() {
		try {
			// if the 10 permit threshold is reached, it will wail untill the permit is released somewhere
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			totalConnections++;
			System.out.println("Number of Connections: " + totalConnections);
		}

		// do some work
		// simulate by Thread.sleep
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		synchronized (this) {
			totalConnections--;
		}
		
		sem.release();

	}

}
