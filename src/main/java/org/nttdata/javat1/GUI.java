package org.nttdata.javat1;

public class GUI {
    private String gui;

    public void gameOver(){
        setGui("GAME OVER");
        System.out.println(getGui());
    }

    public void record(){
        setGui("CONGRATULATIONS! NEW RECORD : ".concat(Integer.toString(T1MainIPL.maxScore)).concat(" POINTS !!!"));
        System.out.println(getGui());
    }

    public void result(){
        setGui(Integer.toString(T1MainIPL.score).concat(" POINTS"));
    }

    public String getGui() {
        return gui;
    }

    public void setGui(String gui) {
        this.gui = gui;
    }

}
