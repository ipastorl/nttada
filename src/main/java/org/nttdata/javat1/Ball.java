package org.nttdata.javat1;

/**
 *  Clase Bolo recibe como atributos
 *        la posición (Item) donde se encuentra
 *        un atributo boolean estático que muestra si la bola está en juego o se ha colado (Game Over)
 *  @author Isabel Pastor López
 *  @version 1.0
 *  @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class Ball {
    private Item position;
    public static boolean lostBall = false;

    public Ball() {
        // La bola siempre se crea (aparece) en la rampa de salida con los mismos parámetros
        // Item id "RampaSalida" (rampa de salida donde se lanza la bola)
        // En el momento de la creación tiene 0 puntos
        // puede alcanzar una escala de uno a diez
        Combo start = new Combo("RampaSalida",0,10);
        setPosition(start);
    }

    public static boolean isGameOver() {
        return lostBall;
    }

    public static void setGameOver(boolean gameOver) {
        Ball.lostBall = gameOver;
    }

    public Item getPosition() {
        return position;
    }

    public void setPosition(Item position) {
        this.position = position;
    }

}
