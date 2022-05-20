package org.nttdata.javat1;

import java.util.Objects;
import java.util.TreeMap;

/**
 * La clase Mission almacena un conjunto de Ítems (Bumpers u Obstacles) y número de veces que debe golpear/pasar la bola
 * para conseguir la meta de la misión.
 *
 * También almacena el nombre de la misión y los puntos obtenidos al completar la misión (done)
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

    // Constructor
    public Mission(String name, TreeMap<Item, Integer> goal, Integer points) {
        this.name = name;
        this.goal = goal;
        this.points = points;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<Item, Integer> getGoal() {
        return goal;
    }

    public void setGoal(TreeMap<Item, Integer> goal) {
        this.goal = goal;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public boolean isDone() {
        return done;
    }

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
