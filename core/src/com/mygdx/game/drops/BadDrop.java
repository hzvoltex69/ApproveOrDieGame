package com.mygdx.game.drops;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Student;

public class BadDrop extends Drop {

	public BadDrop(Texture texture, float speed) {
		super(texture, speed);
	}

	@Override
	protected void onCollect(Student student) {
		collected = true;
		student.danar();
	}

	@Override
	protected void animate(SpriteBatch batch) {
		batch.draw(texture, bounds.x, bounds.y);
	}
}