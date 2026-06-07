package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.screens.MainMenuScreen;

	public class ApproveOrDieGame extends Game {

		private SpriteBatch batch;
		private BitmapFont font;
		private int highestCourse;

		public void create() {
			batch = new SpriteBatch();
			font = new BitmapFont(); // use libGDX's default Arial font
			AudioManager.getInstance().load();
			this.setScreen(new MainMenuScreen(this));
		}

		public void render() {
			super.render(); // important!
		}
		
		@Override
		public void dispose() {
			batch.dispose();
			font.dispose();
			AudioManager.getInstance().dispose();
		}

		public SpriteBatch getBatch() {
			return batch;
		}

		public BitmapFont getFont() {
			return font;
		}

		public int getHighestCourse() {
			return highestCourse;
		}

		public void setHighestCourse(int highestCourse) { 
	        this.highestCourse = highestCourse; 
	    }
		

	}
