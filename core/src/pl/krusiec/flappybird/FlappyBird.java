package pl.krusiec.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;

    private Texture[] birds;
    private int flapState = 0;
    private float birdY = 0;
    private float velocity = 0;

    private int gameState = 0;
    private float gravity = 2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        birds = new Texture[2];
        birds[0] = new Texture("bird.png");
        birds[1] = new Texture("bird2.png");
        birdY = Gdx.graphics.getHeight() / 2 - birds[0].getHeight() / 2;
    }

    @Override
    public void render() {

        if (gameState != 0) {

            if (Gdx.input.justTouched()) {
                velocity = -30;
            }

            if (birdY > 0 || velocity < 0) {
                velocity += gravity;
                birdY -= velocity;
            }

        } else {
            if (Gdx.input.justTouched()) {
                gameState = 1;
            }
        }

        if (flapState == 0) {
            flapState = 1;
        } else {
            flapState = 0;
        }

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2, birdY);
        batch.end();
    }
}
