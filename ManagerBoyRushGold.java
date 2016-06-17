package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by caotr on 10/06/2016.
 */
public class ManagerBoyRushGold {
    private static final int XPOINT = 20;
    private static final int YPOINT = 100;
    private boolean isQuay = false;

    public boolean isQuay() {
        return isQuay;
    }

    public void setQuay(boolean quay) {
        isQuay = quay;
    }


    BoyRushGold boyRushGold;
    public static final Image IMG_BOYS[] = {
            new ImageIcon(ManagerBoyRushGold.class.getResource("/image/onggia1.png")).getImage(),
            new ImageIcon(ManagerBoyRushGold.class.getResource("/image/onggia2.png")).getImage(),
            new ImageIcon(ManagerBoyRushGold.class.getResource("/image/onggia3.png")).getImage(),
            new ImageIcon(ManagerBoyRushGold.class.getResource("/image/onggia4.png")).getImage()
    };
    private int point =0;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public static final int SIZE = 60;
    public static final int X = (PanelDisplayGame.WIDTH_DISPLAY - SIZE) /2;
    public static final int Y = 0;
    public ManagerBoyRushGold(){
        boyRushGold = new BoyRushGold((PanelDisplayGame.WIDTH_DISPLAY - 60) / 2 , 0,60,60,IMG_BOYS[0]);

        for (int  i = 0 ; i < checkPig.length; i ++){
            checkPig[i] = true;
        }
    }

    public void drawBoy(Graphics2D g2d){

        boyRushGold.draw(g2d);
        //g2d.drawImage(IMG_BOYS[0],X,Y,SIZE,SIZE,null);
    }
    public void drawPoint(Graphics2D g2d){
        g2d.drawString("Score :  " + point +"",20,100);
    }
    private boolean[] checkGold ;
    private boolean[] checkPig = new boolean[ManagerPig.NUM_PIG];
    public void init(){
        checkGold = new boolean[ManagerGold.NUMBER_OF_GOLD];
        for(int  i = 0 ; i < checkGold.length; i ++){
            checkGold[i] = true;
        }
    }
    public void computeScore(ManagerGold managerGold, ManagerPig managerPig){

        for (int i= 0 ; i < managerGold.listGold.size() ; i++){
            if(checkGold[i]){
                if(managerGold.listGold.get(i).getY() == -100){
                    setPoint(getPoint() + managerGold.listGold.get(i).getValue());
                    checkGold[i] = false;
                }
            }
        }

        for (int  i = 0 ; i < managerPig.listPig.size() ; i++){
            if(checkPig[i]){

                if(managerPig.listPig.get(i).getY() == -100){

                    setPoint(getPoint() + managerPig.listPig.get(i).getValue());
                    checkPig[i] = false;

                }
            }
        }
    }
    private int speed =0;
    private  int index = 0;
    public void quayCan(){
        if(speed == 20){
            index ++;
            if(index >=0 && index <=3){
                boyRushGold.setImage(IMG_BOYS[index]);
            }
            if (index  > 3){
                index = 0;
            }
        }
        speed ++;
        if(speed > 20){
            speed = 0;
        }
    }

    public void dungQuay(Lasso lasso){
        if(lasso.getRadiusCur() == Lasso.RADIUS_DEFAULT){
            isQuay =false;
        }
        else {
            isQuay = true;
        }
    }

}
