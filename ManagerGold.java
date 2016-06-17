package com.trungcs.settingandcontrol;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by caotr on 10/06/2016.
 */
public class ManagerGold {
    public static  int NUMBER_OF_GOLD =14;
    private String[] mapString ;
    private int number;
    public ArrayList<Gold> listGold ;
    private SetMapFromFile map;
    private static final Image[] IMG_GOLS = {
            new ImageIcon(ManagerGold.class.getResource("/image/gold0.png")).getImage(),
            new ImageIcon(ManagerGold.class.getResource("/image/gold1.png")).getImage(),
            new ImageIcon(ManagerGold.class.getResource("/image/gold2.png")).getImage(),
            new ImageIcon(ManagerGold.class.getResource("/image/gold3.png")).getImage(),
            new ImageIcon(ManagerGold.class.getResource("/image/stone.png")).getImage(),
            new ImageIcon(ManagerGold.class.getResource("/image/diamond.png")).getImage()
    };

    public ManagerGold(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void initGold(String filePth) {
        if(filePth.equals("/File/map2.txt")){
            mapString = new String[15];
            ManagerGold.NUMBER_OF_GOLD =15;
            NUMBER_OF_GOLD =15;
        }
        else {
            mapString = new String[14];
            NUMBER_OF_GOLD =14;
        }
        listGold = new ArrayList<>();
        map = new SetMapFromFile();
        map.getData(mapString,filePth);
        for (int i = 0; i < mapString.length; i++) {
            String str[] = mapString[i].split(" ");
            Gold gold = new Gold(
                    Integer.parseInt(str[1]) * Board.SIZE,
                    Integer.parseInt(str[0]) * Board.SIZE,
                    IMG_GOLS[Integer.parseInt(str[2])],
                    Integer.parseInt(str[3]),
                    Integer.parseInt(str[4]),
                    Integer.parseInt(str[5])
            );
            listGold.add(gold);
        }
    }


    public void drawAllGold(Graphics2D g2d){
        for (int  i = 0 ;i < listGold.size() ; i++){
            listGold.get(i).draw(g2d);
        }
    }

    public void removeGold(int x, int y){
        for (int  i = 0 ; i < listGold.size() ; i++){
            if(listGold.get(i).getX() == x && listGold.get(i).getY() == y){
                listGold.remove(i);
            }
        }
    }




}
