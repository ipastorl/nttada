package org.nttdata.javat1;

public class OutHole extends Item implements Hole{
    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public OutHole(Integer id, Integer points) {
        super(id, points);
    }

    @Override
    public boolean extraBall() {
        return false;
    }

    /**
     * Abstract Method
     * Go to item.
     *
     * @return the item
     */
    @Override
    Item goTo() {
        return null;
    }
}
