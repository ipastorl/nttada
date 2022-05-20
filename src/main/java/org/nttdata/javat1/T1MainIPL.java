package org.nttdata.javat1;

import java.util.Objects;
import java.util.TreeMap;

public class T1MainIPL {
    public static Integer score = 0;
    public static Integer maxScore = 0;
    public static final Ball BALL = new Ball();
    public static void main(String[] args) {
        buildPlayfield();
        buildMissions();
        GUI gui = new GUI();
        while(!Ball.gameOver){

        }
        gui.gameOver();

        if (maxScore==score){
            gui.record();
        } else {
            gui.result();
        }
    }
    public static void buildMissions(){}
    public static void buildPlayfield(){}
    public static void scorePoints(Integer points){
        score += points;
        maxScore = maxScore<score ? score : maxScore;
    }
}
