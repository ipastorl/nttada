package org.nttdata.javat1;

public class OutHole extends Item implements Hole{
    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public OutHole(String id, Integer points) {
        super(id, points);
    }

    @Override
    public boolean extraBall() {
        // TODO: 26/05/2022
        return false;
    }

    @Override
    public void availableExtraBall(boolean available) {
        // TODO: 26/05/2022
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
