package org.nttdata.javat1;


/**
 * Agujero de salida, puede ser central o lateral (izquierda y derecha)
 * los agujeros laterales pueden tener "encendida" la opción de extraBall
 * de manera que cuando la bola pase, si está encendida, generará una bola extra
 */
public class OutHole extends Item {

    // atributo
    private boolean extraBall;

    /**
     * Instantiates a new Item.
     *
     * @param id the id
     */
    public OutHole(String id) {
        // Los agujeros de salida no generan puntos al caer la bola
        super(id,0);
        setExtraBall(false);
    }

    /**
     * Is extra ball boolean
     *
     * @return the boolean
     */
    public boolean isExtraBall() {
        return extraBall;
    }

    /**
     * Es agujero lateral
     *
     * @return boolean boolean
     */
    public boolean isSideHole(){
        return super.getId().equals("Agujero de la izquierda")
                || super.getId().equals("Agujero de la derecha");
    }

    /**
     * Sets extra ball. No se puede cambiar a true, si no es un agujero lateral
     *
     * @param extraBall the extra ball
     */
    public void setExtraBall(boolean extraBall) {
        // sólo se puede establecer una bola extra para agujeros laterales
        if(isSideHole()){
            this.extraBall = extraBall;
        }
    }


    /**
     * Available extra ball. Si la bola pasa por este agujero, generará una bola extra si available es true
     *
     * @param available Boolean
     */
    public void availableExtraBall(boolean available) {
        setExtraBall(available);
    }

    @Override
    void showInfo() {
        String info = " La bola ha caído en el agujero "
                .concat(super.getId())
                .concat("\n")
                .concat("**********************************")
                .concat("********* BOLA PERDIDA ***********")
                .concat("**********************************");
        System.out.println(info);
    }
}
