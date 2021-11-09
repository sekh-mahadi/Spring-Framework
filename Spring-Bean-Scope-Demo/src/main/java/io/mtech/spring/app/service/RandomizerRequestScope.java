package io.mtech.spring.app.service;

public class RandomizerRequestScope {
	private int randomNumber = 10;

	public int getRandomNumber() {
		return randomNumber;
	}

	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}
}
