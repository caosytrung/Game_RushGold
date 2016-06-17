package com.trungcs.settingandcontrol;

import java.awt.*;

/**
 * Created by caotr on 10/06/2016.
 */
public  class ObjectGame implements IDraw {
    public int x;
    public int y;
    public int width;
    public int height;
    public Image image;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

     public void draw(Graphics2D g2d){
         g2d.drawImage(image,x,y,width,height,null);
     }

}
