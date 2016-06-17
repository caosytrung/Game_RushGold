package com.trungcs.goldrush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by caotr on 13/06/2016.
 */
public class PanelMenu extends  BasePanel implements ActionListener {
    private JButton btnStart;
    public static final int WIDTH_MENU= GUI.WIDTH_FRAME;
    public static final int HEIGHT_MENU = GUI.HEIGHT_FRAME;
    private Image imgSt;
    private IShowPanel iShowPanel;
    long tim1;
    MouseAdapter mouseAdapter;

    @Override
    public void initContainer(){
        setSize(WIDTH_MENU,HEIGHT_MENU);
        setBackground(Color.YELLOW);
        setLayout(null);
    }

    @Override
    public void initCommons() {
        imgSt = new ImageIcon(getClass().getResource("/image/bgStart.jpg")).getImage();
    }

    @Override
    public void initComponents() {
        Font font = new Font("Magneto Bold",Font.BOLD,30);
        btnStart = new JButton("Start Game");
        btnStart.setFont(font);
        btnStart.setBounds(200,200,250,30);
        add(btnStart);
        btnStart.setActionCommand("MENU");
        btnStart.addActionListener(this);
    }

    public void setiShowPanel(IShowPanel iShowPanel){
        this.iShowPanel = iShowPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(imgSt,0,0,PanelMenu.WIDTH_MENU, PanelMenu.HEIGHT_MENU,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("MENU") ){
            iShowPanel.showPanel();
            iShowPanel.focus();
        }
    }
}

