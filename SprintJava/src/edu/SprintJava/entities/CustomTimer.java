/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.SprintJava.entities;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author moete
 */
public class CustomTimer extends TimerTask {

    private int time = 10;

    @Override
    public void run() {
        System.out.println("time="+time);
        if(time==5){
            System.out.println("Attention!!");
        }
        if (time == 0) {
            Random r=new Random();
            int alea=r.nextInt(6-1)+1;
            System.out.println("Valeur de des = "+alea);
            cancel();
        }
        time--;
    }
}
