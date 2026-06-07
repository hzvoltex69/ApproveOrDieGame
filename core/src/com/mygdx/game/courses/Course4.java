package com.mygdx.game.courses;

public class Course4 implements DropStrategy {
	public float getDropSpeed()     { 
		return 600f; 
	}
	public float getSpawnRate()     {
		return 0.3f; 
	}
	public float getBadDropChance() { 
		return 0.75f; 
	}
	public float getPowerUpChance() { 
		return 0.12f; 
	}
}