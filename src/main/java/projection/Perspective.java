package projection;

import utils.Point2D;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

public class Perspective extends Projection {

    private Point3D eye;
    private Point3D lookAt;
    private double distance;
    private Vector3D u, v, w;

    public Perspective(Point3D eye, Point3D lookAt, double FOV, int height){
        this.eye = new Point3D(eye);
        this.lookAt = new Point3D(lookAt);
        this.distance = (double)height/2/Math.tan(Math.toRadians(FOV));
        orient();
    }

    @Override
    public Ray createRay(Point2D point) {
        Ray ray = new Ray(new Point3D(eye), u.multiply(point.x).add(v.multiply(point.y).subtract(w.multiply(distance))));
        ray.direction.normalize();
        return ray;
    }

    private void orient(){

        w = eye.subtractToVector(lookAt);
        w.normalize();

        Vector3D up = new Vector3D(0.00424, 1.0, 0.00764);

        u =up.cross(w);
        u.normalize();

        v = u.cross(w);
        v.normalize();
    }

}