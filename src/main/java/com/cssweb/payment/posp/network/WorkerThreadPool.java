package com.cssweb.payment.posp.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkerThreadPool {
	private static final Logger logger = LogManager
			.getLogger(WorkerThreadPool.class.getName());

	private static WorkerThreadPool instance = null;
	private static Object mutex = new Object();

	private ExecutorService executor;

	private WorkerThreadPool() {

	}

	public static WorkerThreadPool getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null)
					instance = new WorkerThreadPool();
			}
		}
		return instance;
	}

	public void init(int threadPoolSize, int queueSize) {

        //executor = Executors.newFixedThreadPool(threadPoolSize);
        executor  = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), threadPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	}

	public void execute(Runnable task) {
		if (executor == null) {
			System.out.println("executor is null");
			return;
		}

		executor.execute(task);
	}
}
