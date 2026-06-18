package com.mygdx.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

	private static AudioManager instance;
	
	private Music gameMusic;
	private Music gameOverMusic;
	private Sound dropSound;
	private Sound hurtSound;
	private Sound levelUpSound;
	private Sound heartSound;

	private AudioManager() {}

	public static AudioManager getInstance() {
		if (instance == null)
			instance = new AudioManager();
		return instance;
	}

	public void load() {
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("gamesong.mp3"));
		gameMusic.setLooping(true);
		gameOverMusic = Gdx.audio.newMusic(Gdx.files.internal("gameover.mp3"));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
		levelUpSound = Gdx.audio.newSound(Gdx.files.internal("levelup.ogg"));
		heartSound = Gdx.audio.newSound(Gdx.files.internal("heart.ogg"));
	}

	public void playGameSong() { 
		gameMusic.play(); 
		}
	public void stopGameSong() { 
		gameMusic.stop(); 
		}
	public void playGameOver() { 
		gameOverMusic.play(); 
		}
	public void stopGameOver() { 
		gameOverMusic.stop(); 
		}
	public void playDrop() { 
		dropSound.play(); 
		}
	public void playHurt() { 
		hurtSound.play(); 
		}
	public void playLevelUp() { 
		levelUpSound.play(); 
		}
	public void playHeart() { 
		heartSound.play(); 
		}

	public void dispose() {
		gameMusic.dispose();
		gameOverMusic.dispose();
		dropSound.dispose();
		hurtSound.dispose();
		levelUpSound.dispose();
		heartSound.dispose();
		instance = null;
	}
}
