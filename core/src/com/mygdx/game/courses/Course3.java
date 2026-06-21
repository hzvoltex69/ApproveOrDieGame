package com.mygdx.game.courses;

public class Course3 extends DropStrategy {
	@Override
	public float getDropSpeed()     { 
		return 550f; 
	}
	@Override
	public float getSpawnRate()     {
		return 0.5f; 
	}
	@Override
	public float getBadDropChance() { 
		return 0.65f; 
	}
	@Override
	public float getPowerUpChance() { 
		return 0.1f; 
	}
}