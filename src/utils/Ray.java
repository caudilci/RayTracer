package utils;

public class Ray {
    public Point3D origin;
    public Vector3D direction;

    public Ray(Point3D origin, Vector3D direction){
        this.origin = new Point3D(origin);
        this.direction = new Vector3D(direction);
    }

    public Point3D at(double t){
        return origin.add(direction.multiply(t));
    }

}