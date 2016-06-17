package com.trungcs.goldrush;

import javax.swing.*;

/**
 * Created by caotr on 10/06/2016.
 */
public abstract class BasePanel extends JPanel {



    public BasePanel(){
        initContainer();
        initCommons();
        initComponents();
    }

    abstract public void initContainer();
    abstract public void initCommons();
    abstract public void initComponents();
}
