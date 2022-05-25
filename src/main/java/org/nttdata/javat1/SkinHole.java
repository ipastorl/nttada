package org.nttdata.javat1;
/**
 * La clase SkinHole (Agujero que lleva al modo de juego ruleta)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class SkinHole extends Item implements Hole, Rebounder{
    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public SkinHole(String id, Integer points) {
        super(id, points);
    }

    public Integer Roulette (){
        // TODO: 26/05/2022
        return 0;
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
        // TODO: 26/05/2022
        return null;
    }

    @Override
    public void Bounce(Item from, Item to, Integer strength) {
        // TODO: 26/05/2022
    }
}
