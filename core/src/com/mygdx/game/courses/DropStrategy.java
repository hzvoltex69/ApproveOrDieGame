package com.mygdx.game.courses;

public interface DropStrategy {
	float getDropSpeed();
	float getSpawnRate();
	float getBadDropChance();
	float getPowerUpChance();
}