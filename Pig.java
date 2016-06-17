package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import java.awt.*;

/**
 * Created by caotr on 12/06/2016.
 */
public class Pig extends ObjectGame implements IMove{

    private int value;
    int pos;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    public Pig(int x, int y, Image imgPig, int width,int height,int value){
        this.x = x;
        this.y =y;
        this.image = imgPig;
        this.width = width;
        this.height = height;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void biKeo(Lasso lasso){
        if( y < 70){
            y = -100;

        }
        else {
            x = lasso.getxCur() + Lasso.X_START  - lasso.getRadiusCur() - width /2;
            y= lasso.getyCur() + Lasso.Y_START;
        }
    }

    @Override
    public void move() {
        switch (pos) {
            case LEFT:
                x--;
                if (x <= 0) {
                    pos = RIGHT;
                }
                break;
            case RIGHT:
                x++;
                if (x >= PanelDisplayGame.WIDTH_DISPLAY) {
                    pos = LEFT;
                }
                break;
            default:
                break;
        }
    }
}
