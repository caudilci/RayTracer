package scene;

import java.util.ArrayList;
import java.util.Random;

import geometry.GeometricObject;
import geometry.Plane;
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
        // generateRandomScene();
        objects.add(new Sphere(new Point3D(0.0, 0.0, 0.0), 50, new Metal(new Color(0.0f, 0.0f, 1.0f), 0.5)));
        objects.add(new Sphere(new Point3D(100.0, 0.0, 0.0), 50, new Lambertian(new Color(1.0f, 0.0f, 1.0f))));
        objects.add(new Sphere(new Point3D(-100.0, 0.0, 0.0), 50, new Dielectric(1.5)));
        objects.add(new Sphere(new Point3D(0.0, -1050.0, 0.0), 1000, new Lambertian(new Color(0.0f, 1.0f, 0.0f))));

    }

    private void generateRandomScene() {
        Random random = new Random();
        Material groundMaterial = new Lambertian(new Color(0.0f, 1.0f, 0.0f));
        objects.add(new Sphere(new Point3D(0.0, -1050.0, 0.0), 1000, groundMaterial));
        for (int a = -11; a < 11; a++) {
            for (int b = -11; b < 11; b++) {
                Point3D center = new Point3D(a + 0.9*random.nextDouble(), 0.2, b + 0.9*random.nextDouble());
                if(center.subtractToVector(new Point3D(4, 0.2, 0)).length()>0.9){
                    double chooseMat = random.nextDouble();
                    if(chooseMat < 0.8){
                        Color albedo = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
                        Color temp = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
                        albedo = albedo.multiplyColor(temp);
                        albedo.clamp();
                        objects.add(new Sphere(center, 0.2, new Lambertian(albedo)));
                    }
                    else if(chooseMat < 0.95){
                        Color albedo = new Color((float)(0.5+0.5*random.nextFloat()), (float)(0.5+0.5*random.nextFloat()), (float)(0.5+0.5*random.nextFloat()));
                        double fuzz = 0.5*random.nextDouble();
                        objects.add(new Sphere(center, 0.2, new Metal(albedo, fuzz)));
                    }
                    else {
                        Material material = new Dielectric(1.5);
                        objects.add(new Sphere(center, 0.2, material));
                        
                    }
                }
            }
        }

    }
}