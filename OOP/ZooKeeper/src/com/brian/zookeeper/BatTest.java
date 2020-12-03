package com.brian.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat unfriendlyBat = new Bat();
		
		unfriendlyBat.attackTown();
		unfriendlyBat.attackTown();
		unfriendlyBat.attackTown();
		unfriendlyBat.eatHumans();
		unfriendlyBat.eatHumans();
		unfriendlyBat.fly();
		unfriendlyBat.fly();
		
		unfriendlyBat.displayEnergy();
	}

}
