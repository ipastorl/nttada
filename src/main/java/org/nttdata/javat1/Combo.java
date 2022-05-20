package org.nttdata.javat1;

/**
 * La clase Combo (rampa o pasillo) hereda los atributos de la SuperClase Item (id, points, multiplier)
 * También almacena el número entero (until) hasta qué máximo puede alcanzar la rampa o pasillo
 * y la escala (climb) hasta dónde ha llegado la bola (este atributo no se crea en el constructor,
 * irá cambiando cada vez que interactúe con la bola
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Combo extends Item{

    // Atributos

    private Integer until;
    private Integer climb;
    private static final Integer MIN = 1;

    // Constuctor

    public Combo(Integer id, Integer points, Integer until) {
        super(id, points);
        this.until = until;
    }

    // Getters and Setters

    public Integer getUntil() {
        return until;
    }

    public void setUntil(Integer until) {
        this.until = until;
    }

    public Integer getClimb() {
        return climb;
    }

    public void setClimb(Integer climb) {
        this.climb = climb;
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
