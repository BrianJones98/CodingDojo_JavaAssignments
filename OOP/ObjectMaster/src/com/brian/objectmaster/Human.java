package com.brian.objectmaster;

public class Human {
	protected int strength = 3;
	protected int stealth = 3;
	protected int intelligence = 3;
	public int health = 100;
	
	public void attack(Human target) {
		target.health -= this.strength;
	}
}
