package org.nttdata.javat1;

/**
 *  Interface Agujero
 *  un método implementable extraBall que retorna si al caer la bola
 *  en el agujero, ha generado otra bola extra o no
 *
 *  un método implementable availableExtraBall que dispone se "enciende o no" el bonus
 *  bola extra (durante un tiempo) de manera que si la bola cae, se consiga la bola extra
 *  @author Isabel Pastor López
 *  @version 1.0
 *  @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public interface Hole {
    /**
     * Extra ball boolean.
     *
     * @return the boolean
     */
    public boolean extraBall();
    public void availableExtraBall(boolean available);
}
