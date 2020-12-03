package com.brian.zookeeper;

public class Mammal {
	protected int energyLevel = 100;

	//Getters
	public int displayEnergy() {
		System.out.println(energyLevel);
		return this.energyLevel;
	}
}
