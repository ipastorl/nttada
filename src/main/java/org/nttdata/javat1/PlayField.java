package org.nttdata.javat1;

import java.util.ArrayList;
import java.util.List;

/**
 * Build playfield.
 * Incorpora al juego los parámetros (Items) que contendrá
 * el tablero de juego
 * El constructor colocará en la posición 0 de la lista la rampa de salida (Combo)
 * seguido de dos manejas (Flipper)
 * y de los tres agujeros por los que se perderá la bola
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class PlayField {
    // Atributo
    private List<Item> items = new ArrayList<>();

    /**
     * Instantiates a new Play field.
     */
// Constructor
    public PlayField() {
        // añade la rampa de salida (donde sale la bola)
        Combo c = new Combo("RampaSalida",0,10);
        addItem(c);
        // añade las dos manejas (Flippers) izquierda y derecha
        Flipper rightFlipper = new Flipper("rightFlipper");
        Flipper leftFlipper = new Flipper("leftFlipper");
        addItem(rightFlipper);
        addItem(leftFlipper);
        // añade los tres agujeros por los que la bola puede perderse: centro, izquierda y derecha
        OutHole centerOutHole = new OutHole("Agujero del centro");
        OutHole rightOutHole = new OutHole("Agujero de la derecha");
        OutHole leftOutHole = new OutHole("Agujero de la izquierda");
        addItem(centerOutHole);
        addItem(rightOutHole);
        addItem(leftOutHole);
        setItems(items);
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    private void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item){
        this.items.add(item);
    }
}
