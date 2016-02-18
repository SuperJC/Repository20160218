package com.sense.test.chapter4;

import java.util.concurrent.BlockingQueue;

public class Veterinarian extends Thread {

	protected final BlockingQueue<ApppointMent<Pet>> appts;
	protected String text="";
	protected final int restTime;
	protected boolean shutdown = false;
	public Veterinarian(BlockingQueue<ApppointMent<Pet>> appts, int restTime) {
		super();
		this.appts = appts;
		this.restTime = restTime;
	}
	public synchronized void shutdown(){
		this.shutdown = true;
	}
	@Override
	public void run() {
		while(!shutdown){
			seePatient();
			try {
				Thread.sleep(restTime);
			} catch (InterruptedException e) {
				shutdown=true;
			}
		}
	}
	public void seePatient() {
		try {
			ApppointMent<Pet> ap = appts.take();
			Pet petient  = ap.getPatient();
			petient.examine();
		} catch (InterruptedException e) {
			shutdown=true;
		}
	}
}
