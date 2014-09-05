package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.render.IRender;
import io.github.aritzhack.aritzh.util.Nullable;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author Aritz Lopez
 */
public class Tile {

    public static final int SIZE = 68;

    private final int x;
    private final int y;
    private final int windowX, windowY;
    private final Rectangle bounds;

    @Nullable
    private Turret turret;
    private boolean hover = false;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.windowX = Field.CELL_X_OFFSET + this.x * SIZE;
        this.windowY = Field.CELL_Y_OFFSET + this.y * SIZE;

        this.bounds = new Rectangle(this.windowX, this.windowY, SIZE, SIZE);
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

    public boolean hasTurret() {
        return turret != null;
    }

    @Nullable
    public Turret getTurret() {
        return turret;
    }

    public void render(IRender render) {
        render.draw(this.windowX, this.windowY, hover ? "cellHighlit" : "cell");

        if(this.turret != null) this.turret.render(render);
    }

    public void update(Game game) {
        if (this.turret != null) this.turret.update(game);

        Point p = game.getEngine().getInputHandler().getMousePos();

        this.hover = this.bounds.contains(p);
    }
}
