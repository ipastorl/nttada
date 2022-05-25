package org.nttdata.javat1;

import java.util.Objects;
import java.util.TreeMap;

/**
 * Clase principal que almacena los puntos (score), la bola (que está en juego), contador de bolas extras (extraBallCounter), la máxima puntuación
 * contiene los métodos buildPlayfield que importa de una DB los parámetros del juego (Items) que contendrá
 * el tablero de juego y sus reglas y misiones con el método buildMissions
 *
 * Inicializa una GUI con el menú
 * Mantendrá el juego activo subiendo puntos según Ítems y misiones alcanzadas y finalizará con
 * el atributo estático lostBall del Objeto Ball sea true y además no existan bolas extras
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class T1MainIPL {
    /**
     * The constant score (puntuación)
     */
    public static Integer score = 0;
    /**
     * The constant maxScore (récord)
     */
    public static Integer maxScore = 0;
    /**
     * The constant extraBallCounter (contador de bolas extras)
     */
    public static Integer extraBallCounter = 0;
    /**
     * The constant ball (bola actual en juego)
     */
    public static Ball ball = new Ball();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        buildPlayfield();
        buildMissions();
        GUI gui = new GUI();
        while(!Ball.lostBall && extraBallCounter <= 0){
            // TODO: 26/05/2022
        }
        gui.gameOver();

        if (maxScore==score){
            gui.record();
        } else {
            gui.result();
        }
    }

    /**
     * Build missions.
     * Importa de una DB las misiones que contendrá
     * el tablero de juego
     */
    public static void buildMissions(){// TODO: 26/05/2022
         }

    /**
     * Build playfield.
     * Importa de una DB los parámetros del juego (Items) que contendrá
     * el tablero de juego
     */
    public static void buildPlayfield(){// TODO: 26/05/2022
         }

    /**
     * Score points.
     * suma puntos al atributo score
     * Si la puntuación actual (score) supera el récord (maxScore), entonces
     * maxScore será igual a la puntuación actual
     * @param points the points
     */
    public static void scorePoints(Integer points){
        score += points;
        maxScore = maxScore<score ? score : maxScore;
    }
}
