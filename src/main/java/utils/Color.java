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

    public void multiply(double val){
        r *= val;
        g *= val;
        b *= val;
    }

    public Color multiplyColor(Color color){
        return new Color(r*color.r, g*color.g, b*color.b);
    }

    public void clamp(){
        r = Math.max(r, 0f);
        r = Math.min(r, 0.999f);
        g = Math.max(g, 0f);
        g = Math.min(g, 0.999f);
        b = Math.max(b, 0f);
        b = Math.min(b, 0.999f);
    }

    public int toInteger(){
        return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
    }

}