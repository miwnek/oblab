package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
     void testToString() {
        Vector2d a = new Vector2d(13, 2);
        Vector2d b = new Vector2d(-2, 16);
        Vector2d c = new Vector2d(0, 100);
        assertEquals(a.toString(), "(13, 2)");
        assertEquals(b.toString(), "(-2, 16)");
        assertEquals(c.toString(), "(0, 100)");
    }

    @Test
    void testPrecedes() {
        Vector2d a = new Vector2d(20, 40);
        Vector2d b = new Vector2d(30, 50);
        Vector2d c = new Vector2d(20, 50);
        assertTrue(a.precedes(c));
        assertTrue(a.precedes(b));
        assertFalse(b.precedes(c));
    }

    @Test
    void testFollows() {
        Vector2d a = new Vector2d(20, 40);
        Vector2d b = new Vector2d(30, 50);
        Vector2d c = new Vector2d(20, 50);
        assertFalse(a.follows(c));
        assertFalse(a.follows(b));
        assertTrue(b.follows(a));
    }

    @Test
    void testUpperRight() {
        Vector2d a = new Vector2d(1, 4);
        Vector2d b = new Vector2d(2, 3);
        Vector2d c = new Vector2d(-1, 5);
        assertEquals(a.upperRight(b), new Vector2d(2, 4));
        assertEquals(a.upperRight(c), new Vector2d(1, 5));
        assertEquals(b.upperRight(c), new Vector2d(2, 5));
    }

    @Test
    void testLowerLeft() {
        Vector2d a = new Vector2d(1, 4);
        Vector2d b = new Vector2d(2, 3);
        Vector2d c = new Vector2d(-1, 5);
        assertEquals(a.lowerLeft(b), new Vector2d(1, 3));
        assertEquals(a.lowerLeft(c), new Vector2d(-1, 4));
        assertEquals(b.lowerLeft(c), new Vector2d(-1, 3));
    }

    @Test
    void testAdd() {
        Vector2d a = new Vector2d(3, 5);
        Vector2d b = new Vector2d(-6, 8);
        Vector2d c = new Vector2d(4, 100);
        assertEquals(a.add(b), new Vector2d(-3, 13));
        assertEquals(a.add(c), new Vector2d(7, 105));
        assertEquals(b.add(c), new Vector2d(-2, 108));
    }

    @Test
    void testSubtract() {
        Vector2d a = new Vector2d(3, 5);
        Vector2d b = new Vector2d(-6, 8);
        Vector2d c = new Vector2d(4, 100);
        assertEquals(a.subtract(b), new Vector2d(9, -3));
        assertEquals(a.subtract(c), new Vector2d(-1, -95));
        assertEquals(b.subtract(c), new Vector2d(-10, -92));
    }

    @Test
    void testEquals() {
        Vector2d a = new Vector2d(3, 5);
        Vector2d b = new Vector2d(3, 5);
        Vector2d c = new Vector2d(4, 100);
        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
        assertFalse(a.equals("text"));
        assertTrue(c.equals(new Vector2d(4, 100)));
    }

    @Test
    void testOpposite() {
        for(int i = 0; i < 10; i++) {
            int x = (int)(Math.random()*(101));
            int y = (int)(Math.random()*(101));
            Vector2d a = new Vector2d(x, y);
            assertEquals(a.opposite(), new Vector2d(-x, -y));
        }
    }
}