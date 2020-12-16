package utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Image {
    public BufferedImage buffer;
    public File image;


    public Image(String filename, int width, int height){
        image = new File(filename);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public void write(String fileType){
        try {
            ImageIO.write(buffer, fileType, image);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("could not write image");
            System.exit(1);
        }
    }
}