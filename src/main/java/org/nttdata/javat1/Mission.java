package org.nttdata.javat1;

import java.util.Objects;
import java.util.TreeMap;

/**
 * La clase Mission almacena un conjunto de Ítems (Bumpers u Obstacles) y número de veces que debe golpear/pasar la bola
 * para conseguir la meta de la misión.
 * <p>
 * También almacena el nombre de la misión y los puntos obtenidos al completar la misión (done)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Mission {
    // Atributos
    private String name;
    private TreeMap<Item,Integer> goal;
    private Integer points;
    private boolean done;

    /**
     * Instantiates a new Mission.
     *
     * @param name   the name
     * @param goal   the goal
     * @param points the points
     */
// Constructor
    public Mission(String name, TreeMap<Item, Integer> goal, Integer points) {
        this.name = name;
        this.goal = goal;
        this.points = points;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
// Getters and Setters
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets goal.
     *
     * @return the goal
     */
    public TreeMap<Item, Integer> getGoal() {
        return goal;
    }

    /**
     * Sets goal.
     *
     * @param goal the goal
     */
    public void setGoal(TreeMap<Item, Integer> goal) {
        this.goal = goal;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * Is done boolean.
     *
     * @return the boolean
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets done.
     *
     * @param done the done
     */
    public void setDone(boolean done) {
        this.done = done;
    }
    // Overrides
    @Override
    public String toString() {
        return "Mission{" +
                "name='" + name + '\'' +
                ", goals=" + goal +
                ", points=" + points +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mission)) return false;
        Mission mission = (Mission) o;
        return getName().equals(mission.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
