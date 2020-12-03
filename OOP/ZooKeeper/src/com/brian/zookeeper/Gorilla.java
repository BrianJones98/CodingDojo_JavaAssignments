package com.brian.zookeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla has thrown something!");
	}
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("The gorilla enjoys a banana.");
	}
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla climbs a tree");
	}
}
