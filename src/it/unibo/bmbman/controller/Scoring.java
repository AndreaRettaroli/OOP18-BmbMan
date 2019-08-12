package it.unibo.bmbman.controller;

import java.util.List;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityType;

/**
 *
 */
public enum Scoring {
        BONUS(50),
        MALUS(-50),
        MONSTER(100),
        //LIFE_REMOVED (-200),
        DOOR(200);

    private final int value;
    /**
     * 
     * @param value 
     */
    Scoring(final int value) {
        this.value = value;
    }
    /**
     * 
     * @param e 
     * @return point
     */
    public static int getPoint(final Entity e) {
        if (e.toString().startsWith("Bonus")) {
            return BONUS.value;
        } else if (e.toString().startsWith("Malus")) {
            return MALUS.value;
        } else if (e.toString().equals("Door")) {
            return DOOR.value;
        } else if (e.getType().equals(EntityType.MONSTER)) {
            return MONSTER.value;
        }
        return 0;
    }
}
