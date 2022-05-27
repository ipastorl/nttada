package org.nttdata.javat1;

import java.util.Objects;

/**
 * La clase Item tiene como subclases Combo, Bumper, Slingshot, DropTarget y Flipper
 * Tiene como atributos (id, points)
 * y el atributo multiplier que irá cambiando dependiendo de los bonus y multiplicará los puntos de cada
 * ítem por una cantidad (Ej: 2x, 3x .. nx)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public abstract class Item {
    private String id;
    private Integer points;

    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public Item(String id, Integer points) {
        setId(id);
        setPoints(points);
    }

    /**
     * Show info.
     */
    abstract void showInfo();

    /**
     * Gets points.
     *
     * @return the points
     */
    public Integer getPoints() {
        return this.points;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    private void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
