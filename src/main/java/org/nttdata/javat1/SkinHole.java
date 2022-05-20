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
    public SkinHole(Integer id, Integer points) {
        super(id, points);
    }

    public Integer Roulette (){
        return 0;
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

    @Override
    public void Bounce(Item from, Item to, Integer strength) {

    }
}
