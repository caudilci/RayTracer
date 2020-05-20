package geometry;

import materials.Material;
import materials.Metal;
import utils.Color;
import utils.Hit;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

public class Sphere extends GeometricObject {
    public Point3D center;
    public double radius;
    public Color circle;
    public Material material;

    public Sphere(Point3D center, double radius, Color color){
        this.center = center;
        this.radius = radius;
        this.color = color;
        material = new Metal(new Color(0.0f, 0.0f, 1.0f), 0.2);
    }

    //(p-c)*(p-c) = r^2
    //(o+td-c)*(o+td-c)-r^2 = 0
    //(d*d)t^2 + (2(o-c)*d)t + (o-c)*(o-c)-r^2 = 0


    public Hit getHit(Ray ray, double tMax, double tMin){
        double a = ray.direction.dot(ray.direction);
        double half_b = ray.origin.subtract(center).dot(ray.direction);
        double c = ray.origin.subtract(center).dot(ray.origin.subtract(center))-(radius*radius);
        double discriminant = half_b*half_b-a*c;
        if(discriminant > 0 ){
            double root = Math.sqrt(discriminant);
            double temp = (-half_b-root)/a;
            if(temp < tMax && temp > tMin){
                Point3D p = ray.at(temp);
                Vector3D outwardNormal = p.subtractToVector(center).divide(radius);
                Hit hit = new Hit(temp, true, material, p);
                hit.setFaceNormal(ray, outwardNormal);
                return hit;
            }
            temp = (-half_b+root)/a;
            if(temp < tMax && temp > tMin){
                Point3D p = ray.at(temp);
                Vector3D outwardNormal = p.subtractToVector(center).divide(radius);
                Hit hit = new Hit(temp, true, material, p);
                hit.setFaceNormal(ray, outwardNormal);
                return hit;
            }
        }
        return new Hit();
        
    }

}