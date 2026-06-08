package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.ApproveOrDieGame;

public abstract class MenuBase implements Screen {
	protected final ApproveOrDieGame game;
	protected SpriteBatch batch;	   
	protected BitmapFont font;
	protected OrthographicCamera camera;
	protected Texture background;
	
	public MenuBase(ApproveOrDieGame game) {
		this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		background = new Texture(Gdx.files.internal(getBackgroundPath()));
	}
	
	@Override
	public final void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, 800, 480);
		renderContent();
		batch.end();
		handleInput();
	}
	
	protected abstract String getBackgroundPath();
	protected abstract void renderContent();
	protected abstract void handleInput();
	
	@Override
	public void show () {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
