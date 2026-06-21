package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ApproveOrDieGame;
import com.mygdx.game.GameScreen;
import com.mygdx.game.audio.AudioManager;

public class GameOverScreen extends MenuBase {

	private String courseName;

	public GameOverScreen(final ApproveOrDieGame game, String courseName) {
		super(game);
		this.courseName = courseName;
	}
	
	@Override
	protected String getBackgroundPath() {
		return "gameoverbackground.png";
	}

	@Override
	public void show() {
		AudioManager.getInstance().playGameOver();
	}

	@Override
	protected void renderContent() {
		font.draw(batch, "REPROBASTE " + courseName + ", you are died JAJAJAJA", 100, 200);
		font.draw(batch, "Toca en cualquier lado para reiniciar.", 100, 100);
		font.draw(batch, "Mejor ramo: " + game.getHighestCourse(), 100, 180);
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}
}