package com.sense.test.chapter4;

public class ApppointMent<T> {
	private final T toBeSeen;

	public T getPatient() {
		return toBeSeen;
	}

	public ApppointMent(T toBeSeen) {
		this.toBeSeen = toBeSeen;
	}

}
