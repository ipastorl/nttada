package org.nttdata.javat1;

/**
 * La interfaz Rebounder permite implementar a los ítems el método Bounce
 * (dependiendo de la fuerza que ha alcanzado la bola, rebotará contra otro Bounce n veces (aleatorio))
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public interface Rebounder {

    /**
     * Fuerza con la que la bola se lanza, dependiendo de su fuerza rebotará en reboteadores n veces
     * consiguiendo en cada rebote n puntos (aleatorio)
     *
     * @return Integer
     */
    Integer Bounce();
}
