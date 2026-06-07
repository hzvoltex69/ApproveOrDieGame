package com.mygdx.game.courses;

public class Course1 implements DropStrategy {
	public float getDropSpeed()     { 
		return 350f; 
	}
	public float getSpawnRate()     {
		return 0.6f; 
	}
	public float getBadDropChance() { 
		return 0.45f; 
	}
	public float getPowerUpChance() { 
		return 0.05f; 
	}
}