package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {

    private Random random;
    private double x1, x2, y1, y2, z1, z2;
    private Vector3D vec1, vec2;
    private Normal norm;
    private Point3D point;

    @BeforeEach
    void init() {
        random = new Random();
        x1 = random.nextDouble();
        y1 = random.nextDouble();
        z1 = random.nextDouble();
        x2 = random.nextDouble();
        y2 = random.nextDouble();
        z2 = random.nextDouble();

        vec1 = new Vector3D(x1,y1,z1);
        vec2 = new Vector3D(x2,y2,z2);
        norm = new Normal(x2, y2, z2);
        point = new Point3D(x2, y2, z2);

        System.out.println("x1: " + x1);
        System.out.println("y1: " + y1);
        System.out.println("z1: " + z1);
        System.out.println("x2: " + x2);
        System.out.println("y2: " + y2);
        System.out.println("z2: " + z2);
    }

    @Test
    void add() {
        double testx = x1 + x2;
        double testy = y1 + y2;
        double testz = z1 + z2;

        Vector3D result = vec1.add(vec2);

        assertEquals(testx, result.x);
        assertEquals(testy, result.y);
        assertEquals(testz, result.z);
    }

    @Test
    void subtract() {
        double testx = x1 - x2;
        double testy = y1 - y2;
        double testz = z1 - z2;

        Vector3D result = vec1.subtract(vec2);

        assertEquals(testx, result.x);
        assertEquals(testy, result.y);
        assertEquals(testz, result.z);
    }

    @Test
    void multiply() {
        double scalar = random.nextDouble();
        double testx = x1 * scalar;
        double testy = y1 * scalar;
        double testz = z1 * scalar;
        System.out.println("scalar: " + scalar);

        Vector3D result = vec1.multiply(scalar);

        assertEquals(testx, result.x);
        assertEquals(testy, result.y);
        assertEquals(testz, result.z);
    }

    @Test
    void divide() {
        double scalar = random.nextDouble();
        double testx = x1 / scalar;
        double testy = y1 / scalar;
        double testz = z1 / scalar;
        System.out.println("scalar: " + scalar);

        Vector3D result = vec1.divide(scalar);

        assertEquals(testx, result.x);
        assertEquals(testy, result.y);
        assertEquals(testz, result.z);
    }

    @Test
    void dot() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        System.out.println("dot: " + dot);

        double result = vec1.dot(vec2);

        assertEquals(dot, result);

    }

    @Test
    void testDotPoint() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        System.out.println("dot: " + dot);

        double result = vec1.dot(point);

        assertEquals(dot, result);
    }

    @Test
    void testDotNorm() {
        double dot = x1*x2 + y1*y2 + z1*z2;
        System.out.println("dot: " + dot);

        double result = vec1.dot(norm);

        assertEquals(dot, result);
    }

    @Test
    void normalize() {
        vec1.normalize();
        double magnitude = Math.sqrt(vec1.x*vec1.x + vec1.y*vec1.y + vec1.z*vec1.z);
        System.out.println("Normalized magnitude: " + magnitude);
        assertTrue(magnitude>0.99999 && magnitude < 1.00001);
    }

    @Test
    void cross() {
        double testx = y1*z2 - z1*y2;
        double testy = z1*x2 - x1*z2;
        double testz = x1*y2 - y1*x2;

        Vector3D result = vec1.cross(vec2);

        assertEquals(testx, result.x);
        assertEquals(testy, result.y);
        assertEquals(testz, result.z);

    }

    @Test
    void reflect() {

    }

    @Test
    void refract() {
    }

    @Test
    void lengthSquared() {
    }

    @Test
    void length() {
    }
}