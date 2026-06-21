package com.mygdx.game.courses;

public class Course2 extends DropStrategy {
	@Override
	public float getDropSpeed()     { 
		return 450f; 
	}
	@Override
	public float getSpawnRate()     {
		return 0.7f; 
	}
	@Override
	public float getBadDropChance() { 
		return 0.55f; 
	}
	@Override
	public float getPowerUpChance() { 
		return 0.07f; 
	}
}