package com.brian.ninjagold;

import java.util.Random;

public class GoldProcessor {
	public int getAmount(String action) {
		Random rand = new Random();
		int amount = 0;
		
		if(action.equals("farm")) {
			amount = rand.nextInt(10) + 10;
		}
		else if(action.equals("cave")) {
			amount = rand.nextInt(5) + 5;
		}
		else if(action.equals("house")) {
			amount = rand.nextInt(3) + 2;
		}
		else if(action.equals("casino")) {
			if(rand.nextBoolean()) {
				amount = rand.nextInt(50);
			}
			else {
				amount = rand.nextInt(50) * -1;
			}
		}
		else if(action.equals("spa")) {
			amount = (rand.nextInt(15) + 5)*-1;
		}
		
		return amount;
	}
}
