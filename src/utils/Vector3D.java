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

    public Vector3D multiply(double scalar){
        return new Vector3D(x*scalar,y*scalar, z*scalar);
    }

    public Vector3D divide(double scalar){
        return new Vector3D(x/scalar,y/scalar, z/scalar);
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

    public void normalize(){
        double magnitude = Math.sqrt(x*x + y*y + z*z);
        x/=magnitude;
        y/=magnitude;
        z/=magnitude;
    }

    public Vector3D cross(Vector3D vector){
        return new Vector3D(y*vector.z-z*vector.y, z*vector.x - x*vector.z, x*vector.y-y*vector.x);
    }

    public Vector3D reflect(Vector3D n){
        Vector3D reflected = this.subtract(n.multiply(2 * this.dot(n)));
        return reflected;
    }

    public Vector3D refract(Vector3D n, double etaiOetat){
        double cosTheta = Math.min(n.dot(new Vector3D(-x, -y, -z)), 1.0);
        Vector3D outParallel = this.add(n.multiply(cosTheta)).multiply(etaiOetat);
        Vector3D outPerp = n.multiply(-Math.sqrt(1.0 - (outParallel.x*outParallel.x + outParallel.y*outParallel.y+outParallel.z*outParallel.z)));
        return outParallel.add(outPerp);
    }


}