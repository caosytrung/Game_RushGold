package com.trungcs.goldrush;

import sound.SoundManager;

import java.awt.*;

/**
 * Created by caotr on 10/06/2016.
 */
public class MyContainer extends BasePanel implements IShowPanel{
    private SoundManager soundManager;
    private CardLayout cardLayout;
    private PanelMenu panelMenu;
    private PanelDisplayGame panelDisplayGame;
    private static final String MENU = "MENU";
    private static final String PLAY = "PLAY";
    @Override
    public void initContainer() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBackground(Color.YELLOW);
        soundManager = new SoundManager();
        soundManager.getNhacNen().play();
    }

    @Override
    public void initCommons() {

    }

    @Override
    public void initComponents() {
        panelMenu = new PanelMenu();
        panelDisplayGame = new PanelDisplayGame();
        panelMenu.setiShowPanel(this);
        add(panelMenu,MENU);
        add(panelDisplayGame ,PLAY);
        cardLayout.show(this,MENU);

    }

    @Override
    public void showPanel() {
        cardLayout.show(this,PLAY);
        soundManager.getNhacNen().stop();
        panelDisplayGame.startGame();
        panelDisplayGame.setTimeStart(System.currentTimeMillis() );

    }

    @Override
    public void focus() {
        panelDisplayGame.requestFocus();

    }
}
