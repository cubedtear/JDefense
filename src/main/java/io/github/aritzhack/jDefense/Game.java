package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.gameEngine.CanvasEngine;
import io.github.aritzhack.aritzh.awt.render.BufferedImageRenderer;
import io.github.aritzhack.aritzh.awt.render.IRender;
import io.github.aritzhack.aritzh.gameEngine.IGame;
import io.github.aritzhack.aritzh.logging.ILogger;
import io.github.aritzhack.aritzh.logging.SLF4JLogger;

import java.awt.Graphics;

/**
 * @author Aritz Lopez
 */
public class Game implements IGame {

    public static final int WIDTH = 1280, HEIGHT = 720;
    public static final ILogger LOG = new SLF4JLogger("Game");
    private final IRender render = new BufferedImageRenderer(WIDTH, HEIGHT);
    private final CanvasEngine engine;

    public Game() {
        this.engine = new CanvasEngine(this, WIDTH, HEIGHT, false, Game.LOG);
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

        // Render code here

        g.drawImage(this.render.getImage(), 0, 0, WIDTH, HEIGHT, null);
    }

    @Override
    public void onUpdate() {

    }

    @Override
    public String getGameName() {
        return "JDefense";
    }

    @Override
    public void onUpdatePS() {
        Game.LOG.d("FPS: {}, UPS: {}", engine.getFPS(), engine.getUPS());
    }
}
