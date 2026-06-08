package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ApproveOrDieGame;
import com.mygdx.game.GameScreen;

public class MainMenuScreen extends MenuBase {
	
	public MainMenuScreen(final ApproveOrDieGame game) {
		super(game);
	}
	
	@Override
	public void show() {}
	
	@Override
	protected void renderContent() {
	    font.getData().setScale(2, 2);
	    font.draw(batch, "Bienvenido a Approve or Die!!!", 100, camera.viewportHeight/2+50);
	    font.draw(batch, "Este juego consiste en aprobar 4 ramos, ", 100, camera.viewportHeight/2+10);
	    font.draw(batch, "necesitas 100pts para aprobar", 100, camera.viewportHeight/2-20);
	    font.draw(batch, "cada uno, buena suerte!", 100, camera.viewportHeight/2-50);
	    font.draw(batch, "Toca en cualquier lugar para comenzar!", 100, camera.viewportHeight/2-100);
	    font.getData().setScale(1, 1); // reset!
	}
	
	@Override
	protected String getBackgroundPath() {
		return "mainmenubackground.png";
	}
	@Override
	protected void handleInput() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

}
