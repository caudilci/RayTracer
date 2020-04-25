package main;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        int imageHeight = 920;
        int imageWidth = 1280;
        long startTime = System.nanoTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File image = new File(dateFormat.format(new Date()) + "render.png");
        BufferedImage buffer = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                // render
                buffer.setRGB(x, y, random.nextInt());
            }
        }
        try {
            ImageIO.write(buffer, "PNG", image);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("could not write image");
            e.printStackTrace();
        }
        
        long endTime = System.nanoTime();
        System.out.println("Render/Loop Time:" + (endTime-startTime)/1000000000.0F);
    }
}