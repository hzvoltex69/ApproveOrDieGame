package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.audio.AudioManager;
import com.mygdx.game.builder.Course;
import com.mygdx.game.builder.CourseBuilder;
import com.mygdx.game.courses.Course1;
import com.mygdx.game.courses.Course2;
import com.mygdx.game.courses.Course3;
import com.mygdx.game.courses.Course4;
import com.mygdx.game.entities.GradeRain;
import com.mygdx.game.entities.Student;
import com.mygdx.game.screens.GameOverScreen;
import com.mygdx.game.screens.PauseScreen;
import com.mygdx.game.screens.WinScreen;

public class GameScreen implements Screen {

	final ApproveOrDieGame game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	private Texture background;
	private Student student;
	private GradeRain gradeRain;
	private Course[] courses;
	private int currentCourse;

	public GameScreen(final ApproveOrDieGame game) {
		this.game = game;
		this.batch = game.getBatch();
		this.font = game.getFont();
		this.background = new Texture(Gdx.files.internal("background.png"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		student = new Student(new Texture(Gdx.files.internal("student.png")));
		student.crear();

		gradeRain = new GradeRain(
			new Texture(Gdx.files.internal("drop.png")),
			new Texture(Gdx.files.internal("dropBad.png")),
			new Texture(Gdx.files.internal("powerup.png"))
		);

		courses = new Course[4];
		courses[0] = new CourseBuilder().name("1.-Introducion a la Ingenieria").scoreThreshold(100).strategy(new Course1()).locked(false).build();
		courses[1] = new CourseBuilder().name("2.-Fundamentos de Algoritmos").scoreThreshold(200).strategy(new Course2()).locked(true).build();
		courses[2] = new CourseBuilder().name("3.-Fundamentos de Programacion").scoreThreshold(300).strategy(new Course3()).locked(true).build();
		courses[3] = new CourseBuilder().name("4.-Programacion Avanzada").scoreThreshold(400).strategy(new Course4()).locked(true).build();

		currentCourse = 0;
		gradeRain.setStrategy(courses[currentCourse].getStrategy());
		gradeRain.crear();
	}

	@Override
	public void render(float delta) {
	    ScreenUtils.clear(0, 0, 0.2f, 1);
	    camera.update();
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();
	    batch.draw(background, 0, 0, 800, 400);
	    font.draw(batch, "Gotas totales: " + student.getPuntos(), 5, 475);
	    font.draw(batch, "Vidas: " + student.getVidas(), 670, 475);
	    font.draw(batch, "Highest Course: " + (game.getHighestCourse() == 0 ? "-" : "Course " + game.getHighestCourse()), camera.viewportWidth/2-50, 475);
	    font.draw(batch, courses[currentCourse].getName() + ": " + student.getPuntos() + "/" + courses[currentCourse].getScoreThreshold(), 5, 455);

	    if (!student.estaHerido()) {
	        student.actualizarMovimiento();

	        boolean gameOver = !gradeRain.actualizarMovimiento(student);
	        boolean win = student.getPuntos() >= courses[3].getScoreThreshold();
	        boolean levelUp = currentCourse < 3 && student.getPuntos() >= courses[currentCourse].getScoreThreshold();

	        student.draw(batch);
	        gradeRain.draw(batch);
	        batch.end();

	        if (win) {
	            game.setHighestCourse(4);
	            game.setScreen(new WinScreen(game));
	            dispose();
	            return;
	        }

	        if (gameOver) {
	            if (game.getHighestCourse() < currentCourse + 1)
	                game.setHighestCourse(currentCourse + 1);
	            game.setScreen(new GameOverScreen(game, courses[currentCourse].getName()));
	            dispose();
	            return;
	        }

	        if (levelUp) {
	            currentCourse++;
	            courses[currentCourse].unlock();
	            gradeRain.setStrategy(courses[currentCourse].getStrategy());
	            AudioManager.getInstance().playLevelUp();
	        }

	    } else {
	        student.draw(batch);
	        gradeRain.draw(batch);
	        batch.end();
	    }
	}

	@Override
	public void show() {
		gradeRain.continuar();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {
		gradeRain.pausar();
		game.setScreen(new PauseScreen(game, this));
	}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		student.destruir();
		gradeRain.destruir();
		background.dispose();
	}
}