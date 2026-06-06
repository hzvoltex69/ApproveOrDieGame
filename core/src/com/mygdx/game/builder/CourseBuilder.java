package com.mygdx.game.builder;

import com.mygdx.game.courses.DropStrategy;

public class CourseBuilder {

	private String name;
	private int scoreThreshold;
	private DropStrategy strategy;
	private boolean locked;

	public CourseBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CourseBuilder scoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
		return this;
	}

	public CourseBuilder strategy(DropStrategy strategy) {
		this.strategy = strategy;
		return this;
	}

	public CourseBuilder locked(boolean locked) {
		this.locked = locked;
		return this;
	}

	public Course build() {
		return new Course(name, scoreThreshold, strategy, locked);
	}
}