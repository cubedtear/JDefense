package io.github.aritzhack.jDefense;

import com.google.common.collect.Sets;
import io.github.aritzhack.aritzh.awt.render.IRender;

import java.util.Set;

/**
 * @author Aritz Lopez
 */
public class Field {

    private final int SIZE = 720;

    private final Set<Turret> turrets = Sets.newHashSet();
    private final Set<Enemy> enemies = Sets.newHashSet();

    public Field() {

    }

    public void update() {
        for (Turret t : this.turrets) {
            t.update();
        }

        for(Enemy e : this.enemies) {
            e.update();
        }
    }

    public void render(IRender render) {

    }
}
