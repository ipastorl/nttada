package org.nttdata.javat1;

import java.util.Scanner;

/**
 * La clase SkinHole (Agujero que lleva al modo de juego ruleta)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class SkinHole extends Item{
    private static final Integer BONUSROULETTE = 500;

    /**
     * Instantiates a new Item.
     *
     * @param id     the id
     * @param points the points
     */
    public SkinHole(String id, Integer points) {
        super(id, points);
    }
    @Override
    void showInfo() {
        String info = " La bola ha caído en el agujero "
                .concat(super.getId())
                .concat("\n")
                .concat("**********************************")
                .concat("********* BOLA PERDIDA ***********")
                .concat("**********************************")
                .concat("\n");
        System.out.println(info);
    }

    /**
     * Roulette Cuando la bola cae en este agujero, pasa a otra dimensión de juego (ruleta)
     * si no hay disponibles bolas extras, después de salir del agujero, será el final de la partida (GAME OVER)
     *
     * @return the integer
     */
    public Integer roulette (){
        Scanner sc = new Scanner(System.in);
        String info =  ("**********************************")
                .concat(" ¡ JUEGO DE LA RULETA DISPONIBLE !")
                .concat("**********************************")
                .concat("\n")
                .concat("Lance con una fuerza del 1 al 10 (Teclee la fuerza) : ");
        System.out.println(info);
        int fuerza = sc.nextInt();
        Integer bonus = T1MainIPL.random( fuerza * BONUSROULETTE, 1 );
        info = "¡ Bien tirado ! Has conseguido + ".concat(String.valueOf(bonus)).concat(" puntos");
        System.out.println(info);
        return bonus;
    }

}
