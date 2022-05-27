package org.nttdata.javat1;

/**
 * Muestra un menú interactivo con las opciones :
 * - INSERT COIN
 * - LANZAR BOLA
 * Muestra la puntuación total cuando finaliza el juego
 * Muestra los puntos obtenidos en cada ítem
 * Muestra si hemos alcanzado un nuevo récord
 * <p>
 * Tiene como único parámetro una cadena de texto (gui) que irá cambiando para mostrar mensajes
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class GUI {
    private String gui;

    /**
     * Instantiates a new Gui.
     */
    public GUI() {
        System.out.println(menu());
    }

    /**
     * Menu.
     *
     * @return the string
     */
    public String menu(){
        // TODO: 26/05/2022
        setGui(""
                .concat("==========================================")
                .concat("\n")
                .concat("============== MENU ======================")
                .concat("\n")
                .concat("==========================================")
                .concat("\n")
                .concat("========  1 - INSERTAR MONEDA    =========")
                .concat("\n")
                .concat("========  2 - LANZAR BOLA        =========")
                .concat("\n")
                .concat("==========================================")
                .concat("\n")
                .concat("==========================================\n")
                .concat("TECLEE OPCIÓN (1 o 2)"));
         return getGui();
    }

    /**
     * Game over.
     */
    public void gameOver(){
        setGui("GAME OVER");
        System.out.println(getGui());
    }

    /**
     * Record.
     */
    public void record(){
        setGui("CONGRATULATIONS! NEW RECORD : ".concat(Integer.toString(T1MainIPL.maxScore)).concat(" POINTS !!!"));
        System.out.println(getGui());
    }

    /**
     * Jackpot.
     *
     * @param points the points
     */
    public void jackpot(Integer points){
        setGui(         "*********** ¡¡¡ JACKPOT !!! *************"
                .concat("\n")
                .concat("*** ¡¡¡ ")
                .concat(String.valueOf(points))
                .concat(" PUNTOS CONSEGUIDOS !!! ****"));
        System.out.println(getGui());
    }

    /**
     * Result.
     */
    public void result(){
        setGui(Integer.toString(T1MainIPL.score).concat(" POINTS"));
        System.out.println(getGui());
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public String getGui() {
        return gui;
    }

    /**
     * Sets gui.
     *
     * @param gui the gui
     */
    public void setGui(String gui) {
        this.gui = gui;
    }


}
