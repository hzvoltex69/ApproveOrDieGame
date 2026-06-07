package com.mygdx.game.courses;

public class Course2 implements DropStrategy {
	public float getDropSpeed()     { 
		return 450f; 
	}
	public float getSpawnRate()     {
		return 0.7f; 
	}
	public float getBadDropChance() { 
		return 0.55f; 
	}
	public float getPowerUpChance() { 
		return 0.07f; 
	}
}