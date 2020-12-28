package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    private Random random;
    private double x1, x2, y1, y2, z1, z2;
    private Point3D point1, point2;
    private Normal norm;
    private Vector3D vec;

    @BeforeEach
    void init() {
        random = new Random();
        x1 = random.nextDouble();
        y1 = random.nextDouble();
        z1 = random.nextDouble();
        x2 = random.nextDouble();
        y2 = random.nextDouble();
        z2 = random.nextDouble();

        point1 = new Point3D(x1,y1,z1);
        point2 = new Point3D(x2,y2,z2);
        norm = new Normal(x2, y2, z2);
        vec = new Vector3D(x2, y2, z2);

        System.out.println("x1: " + x1);
        System.out.println("y1: " + y1);
        System.out.println("z1: " + z1);
        System.out.println("x2: " + x2);
        System.out.println("y2: " + y2);
        System.out.println("z2: " + z2);
    }

    @Test
    void add() {
        double sumx = x1 + x2;
        double sumy = y1 + y2;
        double sumz = z1 + z2;

        Point3D result = point1.add(point2);

        assertEquals(sumx, result.x);
        assertEquals(sumy, result.y);
        assertEquals(sumz, result.z);
    }

    @Test
    void testAdd() {
        double sumx = x1 + x2;
        double sumy = y1 + y2;
        double sumz = z1 + z2;

        Point3D result = point1.add(vec);

        assertEquals(sumx, result.x);
        assertEquals(sumy, result.y);
        assertEquals(sumz, result.z);
    }

    @Test
    void subtract() {
        double diffx = x1 - x2;
        double diffy = y1 - y2;
        double diffz = z1 - z2;

        Point3D result = point1.subtract(point2);

        assertEquals(diffx, result.x);
        assertEquals(diffy, result.y);
        assertEquals(diffz, result.z);
    }

    @Test
    void subtractToVector() {
        double diffx = x1 - x2;
        double diffy = y1 - y2;
        double diffz = z1 - z2;

        Vector3D result = point1.subtractToVector(point2);

        assertEquals(diffx, result.x);
        assertEquals(diffy, result.y);
        assertEquals(diffz, result.z);
    }

    @Test
    void dot() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        double result = point1.dot(point2);
        assertEquals(dot, result);
    }

    @Test
    void testDot() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        double result = point1.dot(vec);
        assertEquals(dot, result);
    }

    @Test
    void testDot1() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        double result = point1.dot(norm);
        assertEquals(dot, result);
    }

    @Test
    void distance() {
        double a = x1 - x2;
        double b = y1 - y2;
        double c = z1 - z2;
        double distance = Math.sqrt((a*a)+(b*b)+(c*c));
        double result = point1.distance(point2);

        assertEquals(distance, result);
    }
}