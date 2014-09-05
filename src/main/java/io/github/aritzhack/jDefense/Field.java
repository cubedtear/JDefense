package io.github.aritzhack.jDefense;

import com.google.common.collect.Sets;
import io.github.aritzhack.aritzh.awt.render.IRender;

import java.util.Set;

/**
 * @author Aritz Lopez
 */
public class Field {

    public static final int SIZE = 720;
    public static final int X_OFFSET = (Game.WIDTH - SIZE) / 2;
    public static final int BORDER_SIZE = 20;

    public static final int CELL_X_OFFSET = X_OFFSET + BORDER_SIZE;
    public static final int CELL_Y_OFFSET = BORDER_SIZE;


    private static final int TILE_AMOUNT = 10;

    private final Set<Enemy> enemies = Sets.newHashSet();

    private final Tile[][] tiles;

    public Field() {
        this.tiles = new Tile[TILE_AMOUNT][TILE_AMOUNT];

        for (int x = 0; x < TILE_AMOUNT; x++) {
            for (int y = 0; y < TILE_AMOUNT; y++) {
                this.tiles[x][y] = new Tile(x, y);
            }
        }
    }

    public void update(Game game) {

        for (Enemy e : this.enemies) {
            e.update(game);
        }

        for (Tile[] row : this.tiles) {
            for (Tile t : row) {
                t.update(game);
            }
        }
    }

    public void render(IRender render) {
        render.draw(X_OFFSET, 0, "field");

        for (Tile[] row : this.tiles) {
            for (Tile t : row) {
                t.render(render);
            }
        }
    }
}
