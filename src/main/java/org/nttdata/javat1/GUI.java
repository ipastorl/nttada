package org.nttdata.javat1;

/**
 * Muestra un menú interactivo con las opciones :
 *      - INSERT COIN
 *      - LANZAR BOLA
 * Muestra la puntuación total cuando finaliza el juego
 * Muestra los puntos obtenidos en cada ítem
 * Muestra si hemos alcanzado un nuevo récord
 *
 * Tiene como único parámetro una cadena de texto (gui) que irá cambiando para mostrar mensajes
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class GUI {
    private String gui;

    /**
     * Menu.
     */
    public void menu(){
        // TODO: 26/05/2022
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
     * Result.
     */
    public void result(){
        setGui(Integer.toString(T1MainIPL.score).concat(" POINTS"));
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
