package org.nttdata.javat1;

/**
 * La clase Plunger (Disparador) hereda los atributos de la SuperClase Item (id, points, multiplier)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Plunger extends Item implements Rebounder{
    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public Plunger(Integer id, Integer points) {
        super(id, points);
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
