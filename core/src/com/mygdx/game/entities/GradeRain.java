package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.courses.DropStrategy;
import com.mygdx.game.drops.BadDrop;
import com.mygdx.game.drops.Drop;
import com.mygdx.game.drops.GoodDrop;
import com.mygdx.game.drops.PowerUpDrop;

public class GradeRain implements Drawable {

	private Array<Drop> drops;
	private long lastDropTime;
	private Texture goodTexture;
	private Texture badTexture;
	private Texture powerUpTexture;
	private DropStrategy strategy;

	public GradeRain(Texture goodTexture, Texture badTexture, Texture powerUpTexture) {
		this.goodTexture = goodTexture;
		this.badTexture = badTexture;
		this.powerUpTexture = powerUpTexture;
	}

	public void setStrategy(DropStrategy strategy) {
		this.strategy = strategy;
	}

	public void crear() {
		drops = new Array<Drop>();
		crearGrades(3);
		AudioManager.getInstance().playGameSong();
	}

	private void crearGrades(int vidas) {
		float rand = MathUtils.random();
		Drop drop;
		if (rand < strategy.getBadDropChance())
			drop = new BadDrop(badTexture, strategy.getDropSpeed());
		else if (vidas < 3 && rand < strategy.getBadDropChance() + strategy.getPowerUpChance())
			drop = new PowerUpDrop(powerUpTexture, strategy.getDropSpeed());
		else
			drop = new GoodDrop(goodTexture, strategy.getDropSpeed());

		drop.getBounds().x = MathUtils.random(0, 800 - 64);
		drop.getBounds().y = 480;
		drops.add(drop);
		lastDropTime = TimeUtils.nanoTime();
	}

	public boolean actualizarMovimiento(Student student) {
		if (TimeUtils.nanoTime() - lastDropTime > (long)(strategy.getSpawnRate() * 1000000000f))
			crearGrades(student.getVidas());

		for (int i = 0; i < drops.size; i++) {
			Drop drop = drops.get(i);
			drop.update(student);
			if (drop.isOffScreen() || drop.isCollected()) {
				drops.removeIndex(i);
				i--;
			}
			if (student.getVidas() <= 0)
				return false;
		}
		return true;
	}

	public void draw(SpriteBatch batch) {
		for (Drop drop : drops)
			drop.draw(batch);
	}

	public void destruir() {
		AudioManager.getInstance().stopGameSong();
		goodTexture.dispose();
		badTexture.dispose();
		powerUpTexture.dispose();
	}

	public void pausar() { AudioManager.getInstance().stopGameSong(); }
	public void continuar() { AudioManager.getInstance().playGameSong(); }
}