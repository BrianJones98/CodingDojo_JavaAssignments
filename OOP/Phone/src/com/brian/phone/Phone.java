package com.brian.phone;

public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private String carrier;
	private String ringTone;
	
	public Phone(String versionNumber, int batteryPercentage, String carrier, String ringtone) {
		this.versionNumber = versionNumber;
		this.batteryPercentage = batteryPercentage;
		this.carrier = carrier;
		this.ringTone = ringtone;
	}
	public abstract void displayInfo();
	//Getters
	public String getVersionNumber() {
		return this.versionNumber;
	}
	public int getBatteryPercentage() {
		return this.batteryPercentage;
	}
	public String getCarrier() {
		return this.carrier;
	}
	public String getRingtone() {
		return this.ringTone;
	}
	//Setters
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public void charge(int amount) {
		if(amount < 0) {
			System.out.println("charge amount must be positive");
		}
		else if(this.batteryPercentage + amount >= 100) {
			this.batteryPercentage = 100;
		}
		else {
			this.batteryPercentage += amount;
		}
	}
	public void changeCarrier(String carrier) {
		this.carrier = carrier;
	}
	public void changeRingtone(String ringtone) {
		this.ringTone = ringtone;
	}
}
