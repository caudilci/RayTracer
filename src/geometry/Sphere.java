package geometry;

import utils.Color;
import utils.Point3D;
import utils.Ray;

public class Sphere extends GeometricObject {
    public Point3D center;
    public double radius;
    public Color circle;

    public Sphere(Point3D center, double radius, Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    //(p-c)*(p-c) = r^2
    //(o+td-c)*(o+td-c)-r^2 = 0
    //(d*d)t^2 + (2(o-c)*d)t + (o-c)*(o-c)-r^2 = 0
    @Override
    public double hit(Ray ray) {
        double a = ray.direction.dot(ray.direction);
        double b = 2*ray.origin.subtract(center).dot(ray.direction);
        double c = ray.origin.subtract(center).dot(ray.origin.subtract(center))-radius*radius;
        double discriminant = b*b-4*a*c;
        if(discriminant<0.0){
            return 0.0;
        }
        else{
            double t = (-b - Math.sqrt(discriminant))/(2*a);
            return t;
        }
    }

}