package org.nttdata.javat1;

/**
 * Target: Son las dianas abatibles, suelen servir para desbloquear el acceso a un objeto,
 * hoyo o pasillo, en otras ocasiones para aumentar los multiplicadores o Misiones.
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
    public Target(String id, Integer points) {
        super(id, points);
    }

    @Override
    public void Bounce(Item from, Item to, Integer strength) {
        // TODO: 26/05/2022
    }

    /**
     * Go to item.
     *
     * @return the item
     */
    @Override
    Item goTo() {
        // TODO: 26/05/2022
        return null;
    }
}
