package org.nttdata.javat1;

/**
 * La interfaz Rebounder permite implementar a los ítems el método Bounce
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public interface Rebounder {

    public void Bounce(Item from, Item to, Integer strength);
}
