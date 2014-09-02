package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.gameEngine.CanvasEngine;
import io.github.aritzhack.aritzh.logging.ILogger;
import io.github.aritzhack.aritzh.logging.SLF4JLogger;

/**
 * Created by Aritz on 02/09/2014.
 */
public class Main {

    public static final ILogger LOG = new SLF4JLogger("Main");
    public static CanvasEngine engine;

    public static void main(String[] args) {
        Game game = new Game();

        engine = new CanvasEngine(game, 1280, 720, false, LOG);
        engine.start();
    }
}
