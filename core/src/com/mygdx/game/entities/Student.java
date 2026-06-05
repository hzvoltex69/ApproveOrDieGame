package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.audio.AudioManager;

public class Student implements Drawable {

	private Rectangle student;
	private Texture studentImage;
	private int vidas = 3;
	private int puntos = 0;
	private int velx = 400;
	private boolean herido = false;
	private int tiempoHeridoMax = 50;
	private int tiempoHerido;

	public Student(Texture tex) {
		studentImage = tex;
	}

	public void crear() {
		student = new Rectangle();
		student.x = 800 / 2 - 64 / 2;
		student.y = 20;
		student.width = 64;
		student.height = 64;
	}

	public void danar() {
		vidas--;
		herido = true;
		tiempoHerido = tiempoHeridoMax;
		AudioManager.getInstance().playHurt();
	}

	public void addLife() {
		if (vidas < 3) vidas++;
	}


	public void draw(SpriteBatch batch) {
		if (!herido)
			batch.draw(studentImage, student.x, student.y);
		else {
			batch.draw(studentImage, student.x, student.y + MathUtils.random(-5, 5));
			tiempoHerido--;
			if (tiempoHerido <= 0) herido = false;
		}
	}

	public void actualizarMovimiento() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) student.x -= velx * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) student.x += velx * Gdx.graphics.getDeltaTime();
		if (student.x < 0) student.x = 0;
		if (student.x > 800 - 64) student.x = 800 - 64;
	}

	public void sumarPuntos(int pp) { 
		puntos += pp; 
		}
	public boolean estaHerido() { 
		return herido; 
		}
	public int getVidas() { 
		return vidas; 
		}
	public int getPuntos() { 
		return puntos; 
		}
	public Rectangle getArea() { 
		return student; 
		}
	public void destruir() { 
		studentImage.dispose(); 
		}
}