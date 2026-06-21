package com.mygdx.game.courses;

public class Course1 extends DropStrategy {
	@Override
	public float getDropSpeed()     { 
		return 350f; 
	}
	@Override
	public float getSpawnRate()     {
		return 0.6f; 
	}
	@Override
	public float getBadDropChance() { 
		return 0.45f; 
	}
	@Override
	public float getPowerUpChance() { 
		return 0.05f; 
	}
}