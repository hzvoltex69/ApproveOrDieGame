package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ApproveOrDieGame;
import com.mygdx.game.GameScreen;
import com.mygdx.game.audio.AudioManager;

public class WinScreen extends MenuBase {

	public WinScreen(final ApproveOrDieGame game) {
		super(game);
	}
	
	@Override
	protected String getBackgroundPath() {
		return "winscreenbackground.png";
	}
	
	@Override
	public void show() {
		AudioManager.getInstance().playLevelUp();
	}

	@Override
	protected void renderContent() {
		font.draw(batch, "Ganaste!!!", 100, 300);
		font.draw(batch, "Felicidades por aprobar todos tus ramos!", 100, 250);
		font.draw(batch, "Highest Course: Course " + game.getHighestCourse(), 100, 200);
		font.draw(batch, "Toca en cualquier lado para reiniciar.", 100, 100);
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}
}
