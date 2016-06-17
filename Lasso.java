package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by caotr on 11/06/2016.
 */
public class Lasso implements IDraw,IMove {
    public static final int X_START = PanelDisplayGame.WIDTH_DISPLAY /2;
    public static final int Y_START = 40;
    public static final int RADIUS_DEFAULT = 20;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private int pos ;

    private int xCur;
    private int yCur;
    private int radiusCur;
    private int angle;

    public int getxCur() {
        return xCur;
    }

    public void setxCur(int xCur) {
        this.xCur = xCur;
    }

    public int getyCur() {
        return yCur;
    }

    public void setyCur(int yCur) {
        this.yCur = yCur;
    }

    public int getRadiusCur() {
        return radiusCur;
    }

    public void setRadiusCur(int radiusCur) {
        this.radiusCur = radiusCur;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Lasso(){
        xCur = 0;
        yCur = 0;
        pos = LEFT;
        radiusCur =RADIUS_DEFAULT;
        angle = 0;
        for (int i= 0 ; i < danhDau1.length ; i++){
            danhDau1[i] = false;
        }
    }


    @Override
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(X_START,Y_START,X_START - radiusCur + xCur,Y_START + yCur );

    }

    @Override
    public void move() {
        if(pos == LEFT){
            angle =angle +2;
            double pi = Math.PI;
            double ra = angle / (180 / pi);
            double x = radiusCur - radiusCur * Math.cos(ra);
            double y = radiusCur * Math.sin(ra);
            xCur = (int)x;
            yCur = (int) y;
            if(angle >= 180){
                pos =RIGHT;
            }
        }
       if(pos == RIGHT){
            angle = angle -2;
           double pi = Math.PI;
           double ra = angle / (180 / pi);
           double x = radiusCur - radiusCur * Math.cos(ra);
           double y = radiusCur * Math.sin(ra);
           xCur = (int)x;
           yCur = (int) y;
            if(angle <= 0 ){
                pos = LEFT;
            }
        }
    }
    private void compute(int xCur, int yCur,double angleD){
        double pi = Math.PI;
        double ra = angleD / (180 / pi);
        double x = radiusCur - radiusCur * Math.cos(ra);
        double y = radiusCur * Math.sin(ra);
        xCur = (int)x;
        yCur = (int) y;
        System.out.println(x + "  " + y + "  " + Math.sin(ra));
    }
    public boolean[] danhDau1 = new boolean[100];

    public void duocKeoVang(ManagerGold managerGold,
                            PanelDisplayGame panelDisplayGame
                           ){
        for(int i = 0 ; i < managerGold.listGold.size() ; i++){
            int x = managerGold.listGold.get(i).getX() - (X_START - radiusCur);
            int y = managerGold.listGold.get(i).getY() - Y_START;
            int width = managerGold.listGold.get(i).getWidth();
            int height = managerGold.listGold.get(i).getHeight();

            if((xCur >= x) && (xCur <= x + width) && (yCur >= y) && (yCur <= y + height)){
                danhDau1[i] = true;
                panelDisplayGame.setPos(1);
                panelDisplayGame.canNang = 5 - managerGold.listGold.get(i).getWidth() /20;
                break;

            }
        }
    }
    public boolean[] danhDau2 = new boolean[2];
    public void keoPig(ManagerPig managerPig,
                       PanelDisplayGame panelDisplayGame ,
                       ManagerBoyRushGold managerBoyRushGold){
        for(int  i = 0 ; i < managerPig.listPig.size(); i++){
            int x = managerPig.listPig.get(i).getX() - (X_START - radiusCur);
            int y = managerPig.listPig.get(i).getY() - Y_START;
            int width = managerPig.listPig.get(i).getWidth();
            if((xCur >= x) && (xCur <= x + width) && (yCur >= y) && (yCur <= y + width)){
                danhDau2[i] = true;
                panelDisplayGame.setPos(1);
                panelDisplayGame.canNang =1;

            }
        }
    }
}
