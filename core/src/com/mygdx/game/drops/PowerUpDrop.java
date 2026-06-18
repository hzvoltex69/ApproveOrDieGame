package com.mygdx.game.drops;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.entities.Student;

public class PowerUpDrop extends Drop {

	public PowerUpDrop(Texture texture, float speed) {
		super(texture, speed);
	}

	protected void onCollect(Student student) {
	    collected = true;
	    student.addLife();
	    AudioManager.getInstance().playHeart();
	}
}