package main;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import geometry.Sphere;
import utils.Color;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

import java.awt.image.BufferedImage;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        int sampleSize = 8;
        int imageHeight = 920;
        int imageWidth = 1280;
        long startTime = System.nanoTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File image = new File(dateFormat.format(new Date()) + "render.png");
        BufferedImage buffer = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        //Define Geometry
        Sphere sphere = new Sphere(new Point3D(), 60.0, new Color(1.0F, 0.0F, 0.0F));

        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                // render
                Color color = new Color(0.0f, 0.0f, 0.0f);
                for(int row = 0; row < sampleSize; row++ ){
                    for(int col = 0; col<sampleSize; col++){

                        Ray ray = new Ray(new Point3D(0.25*(x-imageWidth/2 + (col+random.nextFloat())/8), 0.25*(y-imageHeight/2 + (row*random.nextFloat())/8), 100), new Vector3D(0.0, 0.0, -1.0));
                        if(sphere.hit(ray) != 0.0){
                            color.add(sphere.color);
                        }
                        else{
                        }
                    }
                }
                color.divide(64);
                buffer.setRGB(x, y, color.toInteger());
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