package io.github.aritzhack.jDefense;

/**
 * @author Aritz Lopez
 */
public class Turret {

    private final int radius, damage, cooldown, maxHealth;

    private int health, currCooldown, x, y;

    public Turret(int radius, int damage, int cooldown, int maxHealth) {
        this.radius = radius;
        this.damage = damage;
        this.cooldown = cooldown;
        this.maxHealth = maxHealth;
    }

    public void update() {
        if (currCooldown > 0) currCooldown--;
    }
}
