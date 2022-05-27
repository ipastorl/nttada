package org.nttdata.javat1;

/**
 * Clase Bolo recibe como atributos
 * la posición (Item) donde se encuentra
 * un atributo boolean estático que muestra si la bola está en juego o se ha colado (Game Over)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Ball {

    /**
     * The constant lostBall.
     */
    public static boolean lostBall = false;

    /**
     * The constant position.
     */
// La bola siempre parte de la posición rampa de salida
    public static Item position = new Combo("RampaSalida",0,10);


    // Getters and Setters

    /**
     * Is lost ball boolean.
     *
     * @return the boolean
     */
    public static boolean isLostBall() {
        return lostBall;
    }

    /**
     * Sets lost ball.
     *
     * @param lostBall the lost ball
     */
    public static void setLostBall(boolean lostBall) {
        Ball.lostBall = lostBall;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Item getPosition() {
        return position;
    }

    /**
     * Sets position.
     * Si la bola está en la posición OutHole o SkinHole (agujeros) se establece como lostball true
     *
     * @param position the position
     */
    public void setPosition(Item position) {
        Ball.position = position;
        if (position instanceof OutHole || position instanceof SkinHole){ // si cae en un agujero
            setLostBall(true);
        }
    }

}
