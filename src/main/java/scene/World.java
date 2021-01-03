package scene;

import java.util.ArrayList;
import java.util.Random;

import geometry.GeometricObject;
import geometry.Sphere;
import materials.Dielectric;
import materials.Lambertian;
import materials.Material;
import materials.Metal;
import utils.Color;
import utils.Normal;
import utils.Point3D;
import utils.Vector3D;

public class World {
    public ViewPlane viewPlane;
    public ArrayList<GeometricObject> objects;
    public Color background;

    public World(int width, int height, double size) {
        viewPlane = new ViewPlane(width, height, size);
        background = new Color(0.0f, 0.0f, 0.0f);

        objects = new ArrayList<GeometricObject>();
        // add scene objects here
        objects.add(new Sphere(new Point3D(0.0, 0.0, 0.0), 50, new Metal(new Color(0.0f, 0.0f, 1.0f), 0.5)));
        objects.add(new Sphere(new Point3D(100.0, 0.0, 0.0), 50, new Lambertian(new Color(1.0f, 0.0f, 1.0f))));
        objects.add(new Sphere(new Point3D(-100.0, 0.0, 0.0), 50, new Dielectric(1.5)));
        objects.add(new Sphere(new Point3D(0.0, -1050.0, 0.0), 1000, new Lambertian(new Color(0.0f, 1.0f, 0.0f))));

    }
}