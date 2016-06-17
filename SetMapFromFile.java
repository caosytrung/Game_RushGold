package com.trungcs.settingandcontrol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by caotr on 10/06/2016.
 */
public class SetMapFromFile {
    private RandomAccessFile randomAccessFile;

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    public void setRandomAccessFile(RandomAccessFile randomAccessFile) {
        this.randomAccessFile = randomAccessFile;
    }
    public void getData(String data[],String filePath){
        filePath = getClass().getResource(filePath).getPath();
        try {
            randomAccessFile = new RandomAccessFile(filePath, "rw");
            int i = 0;
            String currentLine;
            while ((currentLine = randomAccessFile.readLine()) != null){
                data[i] = currentLine;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
