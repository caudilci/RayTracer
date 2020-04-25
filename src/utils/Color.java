package utils;

/**
 * Not sure if I'll use this over java.awt.Color but it might be of use
 */
public class Color {

    public float r, g, b;

    public Color(){
        r = 0.0f;
        g = 0.0f;
        b = 0.0f;
    }

    public Color(float r, float g, float b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(Color color){
        r = color.r;
        g = color.g;
        b = color.b;
    }

    public void add(Color color) {
        r += color.r;
        g += color.g;
        b += color.b;
    }

    public void divide(int scalar){
        r /= scalar;
        g /= scalar;
        b /= scalar;
    }

    public int toInteger(){
        return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
    }

    /**
     * @TODO add clamp function to handle negative vaues
     */

}