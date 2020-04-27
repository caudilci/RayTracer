package main;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import geometry.GeometricObject;
import geometry.Sphere;
import projection.Perspective;
import projection.Projection;
import scene.World;
import utils.Color;
import utils.Image;
import utils.Point2D;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

import java.awt.image.BufferedImage;

public class Renderer {

    private World world;
    private Image image;
    private int sampleSize;
    private Projection projection;
    
    public Renderer(){
        //initialize stuff
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        world = new World(1280, 920, 0.3);
        image = new Image(dateFormat.format(new Date()) + ".png", world.viewPlane.width, world.viewPlane.height);
        projection = new Perspective(new Point3D(0.0, 0.0, 600),new Point3D(0,0,0), 30, world.viewPlane.height);
        sampleSize = 8;
    }

    public void render(){

        //Define Geometry
        long startTime = System.nanoTime();
        for (int y = 0; y < world.viewPlane.height; y++) {
            for (int x = 0; x < world.viewPlane.width; x++) {
                // render
                image.buffer.setRGB(x, y, trace(x, y).toInteger());
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Render/Loop Time:" + (endTime-startTime)/1000000000.0F);
        image.write("PNG");
    }

    //currently doesn't work
    private Color trace(int x, int y){
        Color color = new Color(0.0f,0.0f,0.0f);
        Boolean hit = false;
        for(int row = 0; row < sampleSize; row++ ){
            for(int col = 0; col<sampleSize; col++){
                Point2D point = regularSample(row, col, x, y);
                Ray ray = projection.createRay(point);
                double min = Double.MAX_VALUE;
                Color temp = new Color(world.background);
                for (GeometricObject geometricObject : world.objects) {
                    double hitVal = geometricObject.hit(ray);
                    if(hitVal != 0.0 && hitVal <min){
                        min = hitVal;
                        temp = geometricObject.color;
                        hit = true;
                    }
                }
                color.add(temp);
            }
        }
        color.divide(sampleSize*sampleSize);
        return hit ? color: new Color(world.background);
    }

    private Point2D regularSample(int row, int col, int x, int y){
        Point2D point = new Point2D(x-world.viewPlane.width/2+(col+0.5)/sampleSize, y-world.viewPlane.height/2 + (row + 0.5)/sampleSize);
        return point;

    }

    private Point2D jitteredSample(int row, int col, int x, int y){
        Random random = new Random();
        Point2D point = new Point2D(x-world.viewPlane.width/2+(col+random.nextFloat())/sampleSize, y-world.viewPlane.height/2 + (row + random.nextFloat())/sampleSize);
        return point;

    }


}