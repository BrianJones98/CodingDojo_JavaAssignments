package com.brian.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human human1 = new Human();
		Human human2 = new Human();
		
		human1.attack(human2);
		System.out.println(human2.health);
		
		Wizard wizard1 = new Wizard();
		wizard1.fireball(human2);
		System.out.println(human2.health);
		
		Ninja ninja1 = new Ninja();
		ninja1.steal(wizard1);
		System.out.println(wizard1.health + " " + ninja1.health);
		
		Samurai samurai1 = new Samurai();
		System.out.println(samurai1.howMany());
		Samurai samurai2 = new Samurai();
		System.out.println(samurai2.howMany());
		samurai1.deathBlow(samurai2);
		samurai1.meditate();
		System.out.println(samurai1.health + " " + samurai2.health);
	}

}
