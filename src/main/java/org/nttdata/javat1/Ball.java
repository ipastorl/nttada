package org.nttdata.javat1;

public class Ball {
    private Integer balls;
    private Item position;
    public static boolean gameOver = false;

    public Ball() {
        Combo start = new Combo(0,0,10);
        setBalls(1);
        setPosition(start);
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Ball.gameOver = gameOver;
    }

    public Integer getBalls() {
        return balls;
    }

    private void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Item getPosition() {
        return position;
    }

    public void setPosition(Item position) {
        this.position = position;
    }

    public void loseBall(){
        if (getBalls()<=1){
            setBalls(0);
            setGameOver(true);
        } else {
            setBalls(getBalls()-1);
        }
    }
    public void extraBall(){
        setBalls(getBalls()+1);
    }
}
