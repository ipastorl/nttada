package org.nttdata.javat1;

/**
 * La clase Flipper (paleta o maneja), implementa la clase Rebounder
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Flipper extends Item implements Rebounder{

    // Atributos
    private Integer strength;

    private static final Integer MINPUNTOS = 10; // Mínimos puntos por rebote
    private static final Integer MAXPUNTOS = 50; // Máximos puntos por rebote

    /**
     * Instantiates a new Item.
     *
     * @param id the id
     */
    public Flipper(String id) {
        // Las manejas no dan puntos
        super(id, 0);
        setStrength();
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
     * Método privado que genera un número aleatorio 1 - 10 (fuerza que es lanzada la bola)
     */
    private void setStrength() {
        this.strength = (int)(Math.random() *11);
    }

    @Override
    void showInfo() {
        String info = " Has pulsado la maneja "
                .concat(super.getId())
                .concat(" con una fuerza : ")
                .concat(String.valueOf(getStrength()));
        System.out.println(info);
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
}
