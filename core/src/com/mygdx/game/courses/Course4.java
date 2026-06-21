package com.mygdx.game.courses;

public class Course4 extends DropStrategy {
	@Override
	public float getDropSpeed()     { 
		return 600f; 
	}
	@Override
	public float getSpawnRate()     {
		return 0.3f; 
	}
	@Override
	public float getBadDropChance() { 
		return 0.75f; 
	}
	@Override
	public float getPowerUpChance() { 
		return 0.12f; 
	}
}