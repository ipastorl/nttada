package org.nttdata.javat1;

/**
 * La interfaz Rebounder permite implementar a los ítems el método Bounce
 * (de dónde recibe la bola y hacia dónde se dirige)
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public interface Rebounder {

    /**
     *
     * @param from Desde qué Item vino la bola
     * @param to Hacia qué Item se dirige la bola
     * @param strength Fuerza con la que la bola entra
     */
    public void Bounce(Item from, Item to, Integer strength);
}
