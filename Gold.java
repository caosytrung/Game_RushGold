package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import java.awt.*;

/**
 * Created by caotr on 10/06/2016.
 */
public class Gold extends ObjectGame {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Gold(int x, int y, Image imgGold,int width, int height,int value){
        this.x = x;
        this.y = y;
        this.image = imgGold;
        this.width = width;
        this.height = height;
        this.value = value;
    }


    public void diChuyen(Lasso lasso){

        if( y < 60){
            y =- 100;
        }
        else {
            x = lasso.getxCur() + Lasso.X_START  - lasso.getRadiusCur() - width /2;
            y= lasso.getyCur() + Lasso.Y_START;
        }
    }

}
