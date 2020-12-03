package com.brian.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("flap flap flap");
	}
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("*screech* Aaaaaaahhhhh!!!!");
	}
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("*bat screeching* *sirens wailing* *flames roaring* *people screaming*");
	}
}
