package org.nttdata.javat1;

import java.util.Objects;

/**
 * La clase Item tiene como subclases Combo, Bumper, Slingshot, DropTarget y Flipper
 * Tiene como atributos (id, points)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public abstract class Item {
    private Integer id;
    private Integer points;
    private Integer multiplier;

    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public Item(Integer id, Integer points) {
        this.id = id;
        this.multiplier = 1;
        this.points = points;
        this.points = getPoints(); // puntos * multiplicador
    }

    /**
     * Abstract Method
     * Go to item.
     *
     * @return the item
     */
    abstract Item goTo();

    /**
     * Gets points.
     *
     * @return the points
     */
    public Integer getPoints() {
        this.points *= getMultiplier();
        return points;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Gets multiplier.
     *
     * @return the multiplier
     */
    public Integer getMultiplier() {
        return multiplier;
    }

    /**
     * Sets multiplier.
     *
     * @param multiplier the multiplier
     */
    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
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
