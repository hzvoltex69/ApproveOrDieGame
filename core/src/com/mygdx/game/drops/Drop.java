package com.mygdx.game.drops;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.entities.Student;

public abstract class Drop {

	protected Rectangle bounds;
	protected Texture texture;
	protected float speed;
	protected boolean collected = false;

	public Drop(Texture texture, float speed) {
		this.texture = texture;
		this.speed = speed;
		bounds = new Rectangle();
		bounds.width = 64;
		bounds.height = 64;
	}
	
	public final void update(Student student) {
		fall();
		if (!student.estaHerido() && bounds.overlaps(student.getArea()))
			onCollect(student);
	}

	private void fall() {
		bounds.y -= speed * Gdx.graphics.getDeltaTime();
	}

	protected abstract void onCollect(Student student);
	
	protected void animate(SpriteBatch batch) {
    batch.draw(texture, bounds.x, bounds.y);
	}

	public void draw(SpriteBatch batch) {
		animate(batch);
	}

	public boolean isOffScreen() { 
		return bounds.y + 64 < 0; 
		}
	public boolean isCollected() { 
		return collected; 
		}
	public Rectangle getBounds() { 
		return bounds; 
		}
}