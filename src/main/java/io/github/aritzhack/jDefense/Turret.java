package io.github.aritzhack.jDefense;

import io.github.aritzhack.aritzh.awt.render.IRender;

/**
 * @author Aritz Lopez
 */
public class Turret {

    private final int radius, damage, cooldown, maxHealth;

    private int health, currCooldown;
    private Tile tile;

    public Turret(int radius, int damage, int cooldown, int maxHealth) {
        this.radius = radius;
        this.damage = damage;
        this.cooldown = cooldown;
        this.maxHealth = maxHealth;
    }

    public void update(Game game) {
        if (currCooldown > 0) currCooldown--;
    }

    public void render(IRender render) {
        
    }
}
