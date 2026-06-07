package com.mygdx.game.builder;

import com.mygdx.game.courses.DropStrategy;

public class Course {

	private String name;
	private int scoreThreshold;
	private DropStrategy strategy;
	private boolean locked;

	public Course(String name, int scoreThreshold, DropStrategy strategy, boolean locked) {
		this.name = name;
		this.scoreThreshold = scoreThreshold;
		this.strategy = strategy;
		this.locked = locked;
	}
	public boolean isLocked() { 
		return locked; 
		}
	public void unlock() { 
		locked = false; 
		}
	public String getName() { 
		return name; 
		}
	public int getScoreThreshold() { 
		return scoreThreshold; 
		}
	public DropStrategy getStrategy() { 
		return strategy; 
		}


}