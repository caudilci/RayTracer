package utils;

public class Point2D {

    public double x, y;

    public Point2D(){
        x = 0.0;
        y = 0.0;
    }

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D point){
        x = point.x;
        y = point.y;
    }


}