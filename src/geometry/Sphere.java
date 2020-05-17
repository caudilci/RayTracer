package geometry;

import utils.Color;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

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

    public Color colorFromRay(Ray ray){
        double t = hit(ray);
        if(t>0){
            Vector3D normal = new Vector3D(ray.at(t).subtractToVector(new Point3D(0,0,-1)));
            normal.normalize();
            Color color = new Color((float)(normal.x+1), (float)(normal.y+1), (float)(normal.z+1));
            color.multiply(0.5);
            return color;
        }
        else{
            Vector3D unit_direction = new Vector3D(ray.direction);
            unit_direction.normalize();
            t= 0.5*(unit_direction.y +1)
            Color color = new Color(1.0f, 1.0f, 1.0f);
            color.multiply(1.0-t);
            Color color2 = new Color(0.5f, 0.7f, 1.0f);
            color2.multiply(t);
            color.add(color2);
        }
    }

}