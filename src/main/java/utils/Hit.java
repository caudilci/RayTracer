package utils;

import materials.Material;

public class Hit {
    public double t;
    public boolean hit;
    public boolean isFrontFace;
    public Vector3D normal;
    public Material material;
    public Point3D point;


    public Hit(){
        t = 0;
        hit = false;
        isFrontFace = false;
        normal = null;
        material = null;
        point = null;
    }

    public Hit(double t, boolean hit, Material material, Point3D point){
        this.t = t;
        this.hit = hit;
        this.material = material;
        this.point = new Point3D(point);
    }

    public void setFaceNormal(Ray ray, Vector3D outwardNormal){
        isFrontFace = ray.direction.dot(outwardNormal) < 0;
        normal = isFrontFace ? outwardNormal : new Vector3D(-outwardNormal.x, -outwardNormal.y, -outwardNormal.z);
    }
    
}