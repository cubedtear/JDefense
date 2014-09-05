package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.gameEngine.CanvasEngine;
import io.github.aritzhack.aritzh.awt.render.BufferedImageRenderer;
import io.github.aritzhack.aritzh.awt.render.IRender;
import io.github.aritzhack.aritzh.awt.render.Sprite;
import io.github.aritzhack.aritzh.awt.render.SpriteSheetLoader;
import io.github.aritzhack.aritzh.gameEngine.IGame;
import io.github.aritzhack.aritzh.logging.ILogger;
import io.github.aritzhack.aritzh.logging.SLF4JLogger;

import java.awt.Graphics;
import java.util.Map;

/**
 * @author Aritz Lopez
 */
public class Game implements IGame {

    public static final int WIDTH = 1280, HEIGHT = 720;
    public static final ILogger LOG = new SLF4JLogger("Game");
    private static final Map<String, Sprite> sprites = SpriteSheetLoader.load("sheet.sht");
    private final IRender render = new BufferedImageRenderer(WIDTH, HEIGHT, sprites);
    private final CanvasEngine engine;
    private final Field field;

    public Game() {
        this.engine = new CanvasEngine(this, WIDTH, HEIGHT, false, Game.LOG);
        this.field = new Field();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.engine.start();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onRender() {
        Graphics g = this.engine.getGraphics();

        this.render.clear();

        this.field.render(this.render);

        g.drawImage(this.render.getImage(), 0, 0, WIDTH, HEIGHT, null);
    }

    @Override
    public void onUpdate() {
        this.field.update(this);
    }

    @Override
    public String getGameName() {
        return "JDefense";
    }

    @Override
    public void onUpdatePS() {
        Game.LOG.d("FPS: {}, UPS: {}", engine.getFPS(), engine.getUPS());
    }

    public CanvasEngine getEngine() {
        return engine;
    }
}
