package projection;

import utils.Point2D;
import utils.Point3D;
import utils.Ray;
import utils.Vector3D;

public class Orthographic extends Projection {

    private double worldSize;

    public Orthographic(double worldSize){
        this.worldSize = worldSize;
    }

    @Override
    public Ray createRay(Point2D point) {
        return new Ray(new Point3D(worldSize*point.x, worldSize*point.y, 120), new Vector3D(0.0, 0.0, -1.0));
    }

}