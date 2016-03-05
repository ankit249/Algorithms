package com.ds.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSample2 implements Callable<String> {

	public String call() {
		return Thread.currentThread().getName() + " executing ...";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		Future<String> future1 = executor.submit(new CallableSample2());
		Future<String> future2 = executor.submit(new CallableSample2());

		System.out.println(Thread.currentThread().getName() + " executing ..."); // main thread

		System.out.println(future1.get()); // pool 1 - thread 1
		System.out.println(future2.get()); // pool 1 - thread 2
	}

}
