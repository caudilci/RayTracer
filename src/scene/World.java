package scene;

import java.util.ArrayList;

import geometry.GeometricObject;
import geometry.Plane;
import geometry.Sphere;
import utils.Color;
import utils.Normal;
import utils.Point3D;

public class World {
    public ViewPlane viewPlane;
    public ArrayList<GeometricObject> objects;
    public Color background;

    public World(int width, int height, double size){
        viewPlane = new ViewPlane(width, height, size);
        background = new Color(0.0f, 0.0f, 0.0f);

        objects = new ArrayList<GeometricObject>();
        objects.add(new Sphere(new Point3D(0.0, 0.0, 0.0), 50, new Color(1.0F, 1.0f, 1.0f)));
        objects.add(new Sphere(new Point3D(100.0, 0.0, 0.0),50, new Color(0.0f, 0.0f, 1.0f)));
        // objects.add(new Plane(new Point3D(0.0, 0.0, 0.0), new Normal(0.0, 1.0, 1.0), new Color(1.0f, 1.0f, 0.0f)));
    }
}