package it.unibo.bmbman.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 * @author lucia
 *
 */
public class BombController {
    private LinkedList<Bomb> amountBombs;
    private final GameController gc;
    /**
     * 
     * @param gc 
     */
    public BombController(final GameController gc) {
        super();
        this.amountBombs = new LinkedList<>();
        this.addBomb();
        this.gc = gc;
    }
    /**
     * 
     * @return bomb
     */
    public LinkedList<Bomb> getBomb() {
        return this.amountBombs;
    }
    /**
     * 
     * @return plantedBombs
     */
    public List<Bomb> getPlantedBomb() {
        return this.amountBombs.stream()
                               .filter(b -> b.isPlanted())
                               .collect(Collectors.toList());
    }
    /**
     * 
     */
    public void addBomb() {
        System.out.println("add bomb");
        final Bomb b = new Bomb(new Dimension(40, 40), this);
        this.amountBombs.add(b);
        //this.gc.addEntity(b, entityView);
    }
    /**
     * 
     * @param pos 
     */
    public void plantBomb(final Position pos) {
        if (this.amountBombs.size() >= 1) {
            final Bomb b = amountBombs.getLast();
            //b.setPosition(pos); mi dà errore
            b.setPlanted(true);
            b.startTimer();
            System.out.println("piantata bomba");
        }
    }
    public void startExplosion() {
        //new Explosion(bomb.getPosition(), null, dimension)
    }
}
