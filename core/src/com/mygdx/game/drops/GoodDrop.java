package com.mygdx.game.drops;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.entities.Student;

public class GoodDrop extends Drop {

	public GoodDrop(Texture texture, float speed) {
		super(texture, speed);
	}

	@Override
	protected void onCollect(Student student) {
		collected = true;
		student.sumarPuntos(10);
		AudioManager.getInstance().playDrop();
	}
}