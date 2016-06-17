package com.trungcs.goldrush;

import com.trungcs.settingandcontrol.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by caotr on 10/06/2016.
 */
public class PanelDisplayGame extends  BasePanel implements Runnable {

    public static final  int WIDTH_DISPLAY = 600;
    public static final  int HEIGHT_DISPLAY = 480;


    private long timeStart;


    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    private Image imgBackground1;
    private Image imgBackground2;
    private Board board;
    private ManagerGold managerGold;
    private ManagerBoyRushGold managerBoyRushGold;
    private Lasso lasso;
    private KeyAdapter keyAdapter;
    private boolean check;
    private Anchor anchor;
    private ManagerPig managerPig;
    private Taget taget;




    @Override
    public void initContainer() {
        setSize(WIDTH_DISPLAY,HEIGHT_DISPLAY);
        setLocation((GUI.WIDTH_FRAME - WIDTH_DISPLAY) /2 ,(GUI.HEIGHT_FRAME - HEIGHT_DISPLAY)/ 2);
        setLayout(null);
        setBackground(Color.GREEN);
    }


  //  long tim1;
    @Override
    public void initCommons() {
        imgBackground1 = (new ImageIcon(getClass().
                getResource("/image/bg.png"))).getImage();

        imgBackground2 = (new ImageIcon(getClass().getResource("/image/bgmenu.png"))).getImage();
        board = new Board();
        managerGold = new ManagerGold();
        managerGold.initGold("/File/map1.txt");
        managerBoyRushGold = new ManagerBoyRushGold();
        managerBoyRushGold.init();
        managerPig = new ManagerPig();
        anchor = new Anchor();
        taget = new Taget();
        canNang = 4;
        lasso = new Lasso();
        check =true;

    }

    public void startGame(){
        (new Thread(this)).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        board.drawBoard(g2d);
        g2d.drawImage(imgBackground2,0,0,WIDTH_DISPLAY , ManagerBoyRushGold.SIZE ,null) ;
        g2d.drawImage(imgBackground1,0 ,
                ManagerBoyRushGold.SIZE,
                WIDTH_DISPLAY,
                HEIGHT_DISPLAY -ManagerBoyRushGold.SIZE,
                null
        );
        managerGold.drawAllGold(g2d);
        managerBoyRushGold.drawBoy(g2d);
        managerPig.draw(g2d);

        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, ManagerBoyRushGold.SIZE ,
                ManagerBoyRushGold.X -10,ManagerBoyRushGold.SIZE);
        g2d.drawLine(ManagerBoyRushGold.X +
                ManagerBoyRushGold .SIZE + 10,
                ManagerBoyRushGold.SIZE,
                WIDTH_DISPLAY,
                ManagerBoyRushGold.SIZE );
        lasso.draw(g2d);
        anchor.draw(g2d);

        Font font = new Font("Magneto Bold", Font.BOLD, 20);
        g2d.setColor(Color.RED);
        g2d.setFont(font);
        managerBoyRushGold.drawPoint(g2d);
        taget.draw(g2d);

    }

    @Override
    public void initComponents() {

    }

    @Override
    public void run() {

        while (true){
            long curentTime = System.currentTimeMillis();
            if((curentTime - timeStart) / 1000 >= 15){
                if(managerBoyRushGold.getPoint() > Taget.TAGET){

                    int i = JOptionPane.showConfirmDialog(this, " Congratulation     " , " Exit !!!!!",JOptionPane.YES_OPTION);
                    if(i == JOptionPane.YES_OPTION){
                        managerGold.listGold.clear();
                        managerGold.initGold("/File/map2.txt");
                        managerBoyRushGold.init();
                        lasso.setRadiusCur(20);
                        timeStart =  curentTime;
                        managerBoyRushGold.setPoint(0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null , "You Lose");
                    System.exit(1);
                }
            }
            if(check){
                lasso.move();
            }
           if(managerBoyRushGold.isQuay()){
               managerBoyRushGold.quayCan();
           }
            managerBoyRushGold.dungQuay(lasso);
            managerBoyRushGold.computeScore(managerGold, managerPig);
            managerPig.move();
            moveToGold();
            toGold();
            lasso.duocKeoVang(managerGold,this);
            lasso.keoPig(managerPig,this,managerBoyRushGold);
            for(int i = 0 ; i < managerGold.listGold.size() ; i++){
                if(lasso.danhDau1[i]){
                    managerGold.listGold.get(i).diChuyen(lasso);
                }
            }

            for(int i = 0 ; i < managerPig.getListPig().size() ; i++){
                if(lasso.danhDau2[i]){
                    managerPig.getListPig().get(i).biKeo(lasso);
                }
            }
            anchor.move(lasso);

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PanelDisplayGame.this.repaint();
        }
    }
    int choose ;

    private void moveToGold(){
        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_SPACE :
                        pos = 0;
                        managerBoyRushGold.setQuay(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);

    }
    private int pos = 2;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    public int canNang;
    private void toGold(){
        if(pos == 0){
            check =false;
            lasso.setRadiusCur(lasso.getRadiusCur() +3);
            double pi = Math.PI;
            double ra = lasso.getAngle() / (180 / pi);
            double rad =lasso.getRadiusCur();
            double x = rad - rad * Math.cos(ra);
            double y = rad * Math.sin(ra);
            lasso.setxCur((int)x);
            lasso.setyCur((int)y);
            if(lasso.getRadiusCur()  >= 500){
                pos =1;
            }
        }
        if(pos == 1){
            lasso.setRadiusCur(lasso.getRadiusCur() - canNang);
            double pi = Math.PI;
            double ra = lasso.getAngle() / (180 / pi);
            double rad =lasso.getRadiusCur();
            double x = rad - rad * Math.cos(ra);
            double y = rad * Math.sin(ra);
            lasso.setxCur((int)x);
            lasso.setyCur((int)y);
            if(lasso.getRadiusCur()  <= 20){
                pos =2;
                lasso.setRadiusCur(Lasso.RADIUS_DEFAULT);
            }

        }
        if(pos == 2){
            check =true;
            canNang =4;
        }
    }
 }
