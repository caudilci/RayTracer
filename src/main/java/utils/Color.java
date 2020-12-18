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
        clamp();
    }

    public Color(Color color){
        r = color.r;
        g = color.g;
        b = color.b;
        clamp();
    }

    public void add(Color color) {
        r += color.r;
        g += color.g;
        b += color.b;
        clamp();
    }

    public void divide(int scalar){
        r /= scalar;
        g /= scalar;
        b /= scalar;
        clamp();
    }

    public void multiply(double val){
        r *= val;
        g *= val;
        b *= val;
        clamp();
    }

    public Color multiplyColor(Color color){
        Color result = new Color(r*color.r, g*color.g, b*color.b);
        result.clamp();
        return result;
    }

    public void clamp(){
        r = r<0 ? 0: r;
        r = Math.min(r, 0.999f);
        g = g<0 ? 0: g;
        g = Math.min(g, 0.999f);
        b = b<0 ? 0: b;
        b = Math.min(b, 0.999f);
    }

    public int toInteger(){
        return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
    }

}