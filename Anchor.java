package com.trungcs.settingandcontrol;

import javax.swing.*;
import java.awt.*;

/**
 * Created by caotr on 11/06/2016.
 */
public class Anchor extends ObjectGame implements  IMove {
    private static final Image imgAnchor = new ImageIcon(Anchor.class.getResource("/image/anchor.png/")).getImage();
    public Anchor(){
        this.x = Lasso.X_START  -Lasso.RADIUS_DEFAULT;
        this.y = Lasso.Y_START ;
        this.image = imgAnchor;
        this.width =this.height = 15;

    }
    public void move(Lasso lasso) {
        x = lasso.getxCur() +  Lasso.X_START  -lasso.getRadiusCur() -7;
        y = lasso.getyCur() + Lasso.Y_START +1;
    }

    @Override
    public void move() {

    }
}
