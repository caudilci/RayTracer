package utils;

public class Scatter {
    public Color attenuation;
    public Ray ray;
    public boolean scattered;


    public Scatter(){
        attenuation = null;
        ray = null;
        scattered = false;
    }

    public Scatter(Color attenuation, Ray ray, boolean scattered){
        this.attenuation = attenuation;
        this.ray = ray; //maybe make copy constructor at some point
        this.scattered = scattered;
    }
}