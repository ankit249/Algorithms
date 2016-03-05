package com.ds.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeArrayList<T> {
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();

	private final List<T> list = new ArrayList<>();

	public void set(T o) {
		writeLock.lock();
		try {
			list.add(o);
			System.out.println("Adding element by thread" + Thread.currentThread().getName());
		} finally {
			writeLock.unlock();
		}
	}

	public T get(int i) {
		readLock.lock();
		try {
			System.out.println("Printing elements by thread" + Thread.currentThread().getName());
			return list.get(i);
		} finally {
			readLock.unlock();
		}
	}

	public static void main(String[] args) {
		ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();
		threadSafeArrayList.set("1");
		threadSafeArrayList.set("2");
		threadSafeArrayList.set("3");

		System.out.println("Printing the First Element : " + threadSafeArrayList.get(1));
	}
}