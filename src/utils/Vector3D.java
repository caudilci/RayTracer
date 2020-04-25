package utils;

public class Vector3D {
    public double x, y, z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(){
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public Vector3D(Vector3D vector) {
        x = vector.x;
        y = vector.y;
        z = vector.z;
    }

    /**
     * Adds the two vectors together and returns type Vector3D
     * @param vector - vector to be added
     * @return sum of this and vector
     */
    public Vector3D add(Vector3D vector) {
        return new Vector3D(x+vector.x, y+vector.y, z+vector.z);
    }

    /**
     * Subtracts a Vector3D from this Vector3D and return a new Vector3D
     * @param vector - subtrahend
     * @return new Vector3D equal to the difference of this and vector
     */
    public Vector3D subtract(Vector3D vector) {
        return new Vector3D(x-vector.x, y-vector.y, z-vector.z);
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
}