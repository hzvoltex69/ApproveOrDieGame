package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ApproveOrDieGame;
import com.mygdx.game.GameScreen;

public class PauseScreen extends MenuBase {

	private GameScreen juego;

	public PauseScreen(final ApproveOrDieGame game, GameScreen juego) {
		super(game);
		this.juego = juego;
	}
	@Override
	public void show() {}
	
	@Override
	protected void renderContent() {
		font.draw(batch, "Juego en Pausa ", 100, 150);
		font.draw(batch, "Toca en cualquier lado para continuar !!!", 100, 100);
	}

	@Override
	protected void handleInput() {
		if (Gdx.input.isTouched()) {
			game.setScreen(juego);
			dispose();
		}
	}
}