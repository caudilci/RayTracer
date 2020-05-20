package materials;

import java.util.Random;

import utils.Color;
import utils.Hit;
import utils.Ray;
import utils.Scatter;
import utils.Vector3D;

public class Lambertian extends Material {

    public Color albedo;
    private Random random;

    public Lambertian(Color color){
        albedo = new Color(color);
        random = new Random();
    }

    @Override
    public Scatter scatter(Ray in, Hit hit) {
        // auto a = random_double(0, 2*pi);
        // auto z = random_double(-1, 1);
        // auto r = sqrt(1 - z*z);
        // return vec3(r*cos(a), r*sin(a), z);
        //min + (max-min)*random
        double a = 2*Math.PI*random.nextDouble();
        double z = -1 + 2*random.nextDouble();
        double r = Math.sqrt(1 - z*z);
        Vector3D randomUnitVec = new Vector3D(r*Math.cos(a),r*Math.sin(a),0);
        Vector3D scatterDirection = hit.normal.add(randomUnitVec);
        Ray ray = new Ray(hit.point, scatterDirection);

        return new Scatter(albedo, ray, true);
    }

    
}