package com.trungcs.settingandcontrol;

import java.awt.*;

/**
 * Created by caotr on 17/06/2016.
 */
public class Taget implements  IDraw {

    public static final int TAGET = 50;
    private static final int X = 20;
    private static final int Y = 130;

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawString("Taget : " + TAGET,X,Y);
    }
}
