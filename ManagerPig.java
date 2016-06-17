package com.trungcs.settingandcontrol;

import com.trungcs.goldrush.PanelDisplayGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by caotr on 12/06/2016.
 */
public class ManagerPig  implements IDraw,IMove{
    public static final int NUM_PIG = 2;
    ArrayList<Pig> listPig;
    private static final Image[] imgPigs= {
            new ImageIcon(ManagerPig.class.getResource("/image/pigleft.png")).getImage()
    };

    public ManagerPig() {
        listPig =new ArrayList<>();
        listPig.add(new Pig(0 , 8* Board.SIZE,imgPigs[0],
                Board.SIZE *2,
                Board.SIZE *2,
                5));
        listPig.add(new Pig(PanelDisplayGame.WIDTH_DISPLAY, 12* Board.SIZE,imgPigs[0],
                Board.SIZE *2,
                Board.SIZE *2,
                5));
    }

    public ArrayList<Pig> getListPig() {

        return listPig;
    }

    public void setListPig(ArrayList<Pig> listPig) {
        this.listPig = listPig;
    }

    @Override
    public void draw(Graphics2D g2d) {
        for(int i  = 0 ; i < listPig.size() ; i++){
            listPig.get(i).draw(g2d);
        }
    }

    @Override
    public void move() {
        for(int  i = 0 ; i < listPig.size() ; i++){
            listPig.get(i).move();
        }
    }
}
