package com.sense.test.chapter4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Test {
	private static final ExecutorService pool = Executors.newFixedThreadPool(200);
	private static final TransferQueue<ApppointMent<Pet>> bq = new LinkedTransferQueue<ApppointMent<Pet>>();
	public static void main(String[] args) {
		startProducer();
		startConsumer();
	}

	private static class CatProducer implements Runnable{
		
		public void run() {
				while (true) {
					bq.offer(new ApppointMent<Pet>(new Cat("")));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	private static class DogProducer implements Runnable{
		public void run() {
				while (true) {
						bq.offer(new ApppointMent<Pet>(new Dog("")));
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
	}
	private static void startProducer() {
		pool.execute(new DogProducer());
		pool.execute(new CatProducer());
	}

	private static void startConsumer() {
		pool.execute(new Veterinarian(bq, 1000));
		pool.execute(new Veterinarian(bq, 1500));
	}

}
