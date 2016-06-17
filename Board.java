package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import java.awt.*;

/**
 * Created by caotr on 10/06/2016.
 */
public class Board {
    public static final int SIZE = 20;
    public static final int COL = PanelDisplayGame.WIDTH_DISPLAY /SIZE;
    public static final int ROW = PanelDisplayGame.HEIGHT_DISPLAY /SIZE;

    public void drawBoard(Graphics2D g2d){
        for (int  i = 0 ; i <= ROW   ; i++){
            g2d.drawLine(0 , i * SIZE, PanelDisplayGame.WIDTH_DISPLAY, i * SIZE);
        }

        for (int i = 0 ; i <= COL ; i++){
            g2d.drawLine(i * SIZE, 0, i * SIZE, PanelDisplayGame.HEIGHT_DISPLAY);
        }
    }
}
