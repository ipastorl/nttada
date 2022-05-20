package org.nttdata.javat1;
/**
 * La clase Slingshot (Reboteadores) hereda los atributos de la SuperClase Item (id, points, multiplier)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Slingshot extends Item implements Rebounder{

    private Integer strength;

    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public Slingshot(Integer id, Integer points) {
        super(id, points);
    }

    @Override
    public void Bounce(Item from, Item to, Integer strength) {

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
