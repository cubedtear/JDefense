package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.gameEngine.CanvasEngine;
import io.github.aritzhack.aritzh.gameEngine.IGame;

import java.awt.*;

/**
 * Created by Aritz on 02/09/2014.
 */
public class Game implements IGame {

    private CanvasEngine engine;

    @Override
    public void onStart() {
        engine = Main.engine;
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRender() {
        Graphics g = engine.getGraphics();

        g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
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
        Main.LOG.e("FPS: {}, UPS: {}", engine.getFPS(), engine.getUPS());
        System.out.println("Hola"); // Does not work
    }
}
