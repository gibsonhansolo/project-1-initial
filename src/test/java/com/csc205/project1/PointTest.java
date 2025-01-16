package com.csc205.project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  Prompt:
 *  "Copied entire class from Point File" +
 *   Given the following java class. Generate Unit test for all constructor and methods in the following format
 *  "Copied entire given PointTest file"
 *
 *   (additional)
 *
 *   Generate more rotational test
 *
 */
 public class PointTest {
    private static final double DELTA = 0.0001; // Delta for floating point comparisons

    @Test
    public void testDefaultConstructor() {
        Point p = new Point();
        assertEquals(0.0, p.getX(), DELTA);
        assertEquals(0.0, p.getY(), DELTA);
    }

    @Test
    public void testParameterizedConstructor() {
        Point p = new Point(3.0, 4.0);
        assertEquals(3.0, p.getX(), DELTA);
        assertEquals(4.0, p.getY(), DELTA);
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(3.0, 4.0);
        assertEquals(5.0, p1.distance(p2), DELTA); // 3-4-5 triangle
    }

    @Test
    public void testGettersAndSetters() {
        Point p = new Point();

        p.setX(5.0);
        assertEquals(5.0, p.getX(), DELTA);

        p.setY(-2.0);
        assertEquals(-2.0, p.getY(), DELTA);
    }

    @Test
    public void testSetPoint() {
        Point p = new Point();
        p.setPoint(3.0, 4.0);
        assertEquals(3.0, p.getX(), DELTA);
        assertEquals(4.0, p.getY(), DELTA);
    }

    @Test
    public void testShiftX() {
        Point p = new Point(1.0, 1.0);
        p.shiftX(2.0);
        assertEquals(3.0, p.getX(), DELTA);
        assertEquals(1.0, p.getY(), DELTA); // Y should remain unchanged
    }

    @Test
    public void testShiftY() {
        Point p = new Point(1.0, 1.0);
        p.shiftY(2.0);
        assertEquals(1.0, p.getX(), DELTA); // X should remain unchanged
        assertEquals(3.0, p.getY(), DELTA);
    }
    // Basic rotation tests
    @Test
    public void testRotate90Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(Math.PI / 2);  // 90 degrees
        assertEquals(0.0, p.getX(), DELTA);
        assertEquals(1.0, p.getY(), DELTA);
    }

    @Test
    public void testRotate180Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(Math.PI);  // 180 degrees
        assertEquals(-1.0, p.getX(), DELTA);
        assertEquals(0.0, p.getY(), DELTA);
    }

    @Test
    public void testRotate270Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(3 * Math.PI / 2);  // 270 degrees
        assertEquals(0.0, p.getX(), DELTA);
        assertEquals(-1.0, p.getY(), DELTA);
    }

    @Test
    public void testRotate360Degrees() {
        Point p = new Point(1.0, 1.0);
        double originalX = p.getX();
        double originalY = p.getY();
        p.rotate(2 * Math.PI);  // 360 degrees
        assertEquals(originalX, p.getX(), DELTA);
        assertEquals(originalY, p.getY(), DELTA);
    }

    // Advanced rotation tests
    @Test
    public void testRotate45Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(Math.PI / 4);  // 45 degrees
        assertEquals(Math.cos(Math.PI / 4), p.getX(), DELTA);
        assertEquals(Math.sin(Math.PI / 4), p.getY(), DELTA);
    }

    @Test
    public void testRotateNegative90Degrees() {
        Point p = new Point(1.0, 0.0);
        p.rotate(-Math.PI / 2);  // -90 degrees
        assertEquals(0.0, p.getX(), DELTA);
        assertEquals(-1.0, p.getY(), DELTA);
    }

    @Test
    public void testMultipleRotations() {
        Point p = new Point(1.0, 0.0);
        p.rotate(Math.PI / 2);  // 90 degrees
        p.rotate(Math.PI / 2);  // Another 90 degrees
        assertEquals(-1.0, p.getX(), DELTA);
        assertEquals(0.0, p.getY(), DELTA);
    }

    @Test
    public void testRotateOriginPoint() {
        Point p = new Point(0.0, 0.0);
        p.rotate(Math.PI / 2);  // 90 degrees
        assertEquals(0.0, p.getX(), DELTA);
        assertEquals(0.0, p.getY(), DELTA);
    }

    @Test
    public void testRotateArbitraryAngle() {
        Point p = new Point(2.0, 3.0);
        double angle = Math.PI / 6;  // 30 degrees
        p.rotate(angle);
        double expectedX = 2.0 * Math.cos(angle) - 3.0 * Math.sin(angle);
        double expectedY = 2.0 * Math.sin(angle) + 3.0 * Math.cos(angle);  // Fix here
        assertEquals(expectedX, p.getX(), DELTA);
        assertEquals(expectedY, p.getY(), DELTA);
    }

    @Test
    public void testRotateLargeAngle() {
        Point p = new Point(1.0, 1.0);
        p.rotate(10 * Math.PI);  // 1800 degrees
        assertEquals(1.0, p.getX(), DELTA);
        assertEquals(1.0, p.getY(), DELTA);
    }


    @Test
    public void testToString() {
        Point p = new Point(3.0, 4.0);
        assertEquals("(3.0, 4.0)", p.toString());
    }

    @Test
    public void testDistanceToSelf() {
        Point p = new Point(3.0, 4.0);
        assertEquals(0.0, p.distance(p), DELTA);
    }

    @Test
    public void testNegativeCoordinates() {
        Point p = new Point(-3.0, -4.0);
        assertEquals(-3.0, p.getX(), DELTA);
        assertEquals(-4.0, p.getY(), DELTA);
    }
}