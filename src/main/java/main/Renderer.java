package main;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import geometry.GeometricObject;
import geometry.Sphere;
import projection.Perspective;
import projection.Projection;
import scene.World;
import utils.Color;
import utils.Hit;
import utils.Image;
import utils.Point2D;
import utils.Point3D;
import utils.Ray;
import utils.Scatter;
import utils.Vector3D;

import java.awt.image.BufferedImage;

public class Renderer {

    private World world;
    private Image image;
    private int sampleSize;
    private Projection projection;
    private int depth;

    public Renderer() {
        // initialize stuff
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        world = new World(1280, 920, 0.3);
        image = new Image(dateFormat.format(new Date()) + ".png", world.viewPlane.width, world.viewPlane.height);
        projection = new Perspective(new Point3D(0.0, 0.0, 200), new Point3D(0, 0, 0), 30, world.viewPlane.height);
        sampleSize = 8;
        depth = 50;
    }

    public void render() {

        // Define Geometry
        long startTime = System.nanoTime();
        for (int y = 0; y < world.viewPlane.height; y++) {
            System.out.println("Scan Lines Remaining: " + (world.viewPlane.height - y));
            for (int x = 0; x < world.viewPlane.width; x++) {
                // render
                image.buffer.setRGB(x, y, trace(x, y).toInteger());
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Render/Loop Time:" + (endTime - startTime) / 1000000000.0F);
        image.write("PNG");
    }

    private Color trace(int x, int y) {
        Color color = new Color(0.0f, 0.0f, 0.0f);
        for (int row = 0; row < sampleSize; row++) {
            for (int col = 0; col < sampleSize; col++) {
                Point2D point = jitteredSample(row, col, x, y);
                Ray ray = projection.createRay(point);
                color.add(rayColor(ray, world.objects, depth));
            }
        }
        color.divide(sampleSize * sampleSize);
        return color;
    }

    private Point2D regularSample(int row, int col, int x, int y) {
        Point2D point = new Point2D(x - world.viewPlane.width / 2 + (col + 0.5) / sampleSize,
                y - world.viewPlane.height / 2 + (row + 0.5) / sampleSize);
        return point;

    }

    private Point2D jitteredSample(int row, int col, int x, int y) {
        Random random = new Random();
        Point2D point = new Point2D(x - world.viewPlane.width / 2 + (col + random.nextFloat()) / sampleSize,
                y - world.viewPlane.height / 2 + (row + random.nextFloat()) / sampleSize);
        return point;

    }

    private Color rayColor(Ray ray, ArrayList<GeometricObject> worldObjects, int depth) {
        if (depth <= 0) {
            return new Color(0.0f, 0.0f, 0.0f);
        }
        Color color = new Color(0.0f,0.0f,0.0f);
        Hit hit = new Hit();
        double closest = Double.POSITIVE_INFINITY;
        for (GeometricObject geometricObject : worldObjects) {
            Hit temp = geometricObject.getHit(ray, closest, 0.001);
            if(temp.hit){
                hit = temp;
                closest = temp.t;
            }
        }
        if (hit.hit) {
            Scatter scatter = hit.material.scatter(ray, hit);
            if (scatter.scattered) {
                return rayColor(scatter.ray, worldObjects, depth--).multiplyColor(scatter.attenuation);
            } else
                color = new Color(0.0f, 0.0f, 0.0f);
        } else {
            Vector3D unitDirection = ray.direction;
            unitDirection.normalize();
            double t = 0.5 * (unitDirection.y + 1.0);
            Color c1 = new Color(1.0f, 1.0f, 1.0f);
            c1.multiply(1.0 - t);
            Color c2 = new Color(0.5f, 0.7f, 1.0f);
            c2.multiply(t);
            c1.add(c2);
            color = c1;
        }
        return color;
    }

}