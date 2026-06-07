package com.mygdx.game.courses;

public class Course3 implements DropStrategy {
	public float getDropSpeed()     { 
		return 550f; 
	}
	public float getSpawnRate()     {
		return 0.5f; 
	}
	public float getBadDropChance() { 
		return 0.65f; 
	}
	public float getPowerUpChance() { 
		return 0.1f; 
	}
}