package org.nttdata.javat1;

/**
 * La clase Bumper (rampa o pasillo) hereda los atributos de la SuperClase Item (id, points)
 * También almacena el número entero (until) hasta qué máximo puede alcanzar la rampa o pasillo
 * y la escala (climb) hasta dónde ha llegado la bola (este atributo no se crea en el constructor,
 * irá cambiando cada vez que interactúe con la bola
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Bumper extends Item implements Rebounder{

    // Atributos
    private Integer strength;

    // Constructor

    /**
     * Instantiates a new Bumper.
     *
     * @param id       the id
     * @param points   the points
     * @param strength the strength
     */
    public Bumper(Integer id, Integer points, Integer strength) {
        super(id, points);
        this.strength = strength;
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

    // Getters and Setters

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public void Bounce(Item from, Item to, Integer strength) {

    }
}
