package utils;

public class Point3D {
    public double x, y, z;

    public Point3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(){
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public Point3D(Point3D point) {
        x = point.x;
        y = point.y;
        z = point.z;
    }

    /**
     * Adds the two points together and returns type Point3D
     * @param point - point to be added
     * @return sum of this and point
     */
    public Point3D add(Point3D point) {
        return new Point3D(x+point.x, y+point.y, z+point.z);
    }

    /**
     * Adds a vector to this and returns the sum as type Point3D
     * @param vec - vector to be added
     * @return sum of this and point
     */
    public Point3D add(Vector3D vec) {
        return new Point3D(x+vec.x, y+vec.y, z+vec.z);
    }

    /**
     * Subtracts a Point3D from this Point3D and return a new Point3D
     * @param point - subtrahend
     * @return new Point3D equal to the difference of this and point
     */
    public Point3D subtract(Point3D point) {
        return new Point3D(x-point.x, y-point.y, z-point.z);
    }

    public Vector3D subtractToVector(Point3D point) {
        return new Vector3D(x-point.x, y-point.y, z-point.z);
    }

    public double dot(Vector3D vector) {
        return x*vector.x + y*vector.y + z*vector.z;
    }

    public double dot(Point3D point) {
        return x*point.x + y*point.y + z*point.z;
    }

    public double dot(Normal normal) {
        return x*normal.x + y*normal.y + z*normal.z;
    }

    public double distance(Point3D point){
        double a = x - point.x;
        double b = y - point.y;
        double c = z - point.z;
        return Math.sqrt((a*a)+(b*b)+(c*c));
    }
}