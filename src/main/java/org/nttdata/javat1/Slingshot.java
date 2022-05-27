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

    private static final Integer MINPUNTOS = 5; // Mínimos puntos por rebote
    private static final Integer MAXPUNTOS = 30; // Máximos puntos por rebote

    /**
     * Instantiates a new Item.
     *
     * @param id       the id
     * @param points   the points
     * @param strength the strength
     */
    public Slingshot(String id, Integer points, Integer strength) {
        super(id, points);
        setStrength(strength);
    }

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
    private void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public Integer Bounce() {

        int randomPuntos;
        int totalPuntos = 0;
        int contadorRebotes = getStrength();
        // veces que rebota hasta alcanzar fuerza 1 (puede no rebotar si la fuerza es 1)
        while (contadorRebotes>1){
            randomPuntos = T1MainIPL.random(MAXPUNTOS, MINPUNTOS);
            String info = "la bola rebota con un Bounder, obtienes "
                    .concat(String.valueOf(randomPuntos))
                    .concat(" puntos");
            System.out.println(info);
            totalPuntos += randomPuntos;
            contadorRebotes--;
        }
        return totalPuntos;
    }

    @Override
    void showInfo() {
        String info = "La bola alcanza el reboteador  "
                .concat(super.getId())
                .concat("\n");
        System.out.println(info);
    }
}
