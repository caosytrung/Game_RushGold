package com.trungcs.goldrush;

import javax.swing.*;

/**
 * Created by caotr on 10/06/2016.
 */
public class GUI extends JFrame{
    public static final int WIDTH_FRAME = 600;
    public static final int HEIGHT_FRAME = 510;

    public GUI(){
        initGUI();
        initComponent();
    }

    private void initGUI(){
        setTitle("Rush Gold" );
        setSize(WIDTH_FRAME,HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponent(){
        add(new MyContainer());
    }
}
