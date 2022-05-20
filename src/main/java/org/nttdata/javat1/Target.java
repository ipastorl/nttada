package org.nttdata.javat1;

/**
 * La clase Flipper (paleta o maneja), implementa la clase Rebounder. Hereda de la superClase Item
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Target extends Item implements Rebounder {
    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public Target(Integer id, Integer points) {
        super(id, points);
    }

    @Override
    public void Bounce(Item from, Item to, Integer strength) {

    }

    /**
     * Go to item.
     *
     * @return the item
     */
    @Override
    Item goTo() {
        return null;
    }
}
