package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testOrientation() {
        Animal test = new Animal();
        test.move(MoveDirection.RIGHT);
        test.move(MoveDirection.RIGHT);
        test.move(MoveDirection.LEFT);
        test.move(MoveDirection.BACKWARD);
        test.move(MoveDirection.BACKWARD);
        test.move(MoveDirection.FORWARD);
        assertTrue(test.isAt(new Vector2d(1,2)));
    }

    @Test
    void testBoundNorth() {
        Animal test = new Animal();
        for(int i=0; i<4; i++) { test.move(MoveDirection.FORWARD); }
        assertTrue(test.isAt(new Vector2d(2,4)));
    }

    @Test
    void testBoundWest() {
        Animal test = new Animal();
        test.move(MoveDirection.RIGHT);
        for(int i=0; i<4; i++) { test.move(MoveDirection.FORWARD); }
        assertTrue(test.isAt(new Vector2d(4,2)));
    }

    @Test
    void testBoundEast() {
        Animal test = new Animal();
        test.move(MoveDirection.LEFT);
        for(int i=0; i<4; i++) { test.move(MoveDirection.FORWARD); }
        assertTrue(test.isAt(new Vector2d(0,2)));
    }

    @Test
    void testBoundSouth() {
        Animal test = new Animal();
        for(int i=0; i<4; i++) { test.move(MoveDirection.BACKWARD); }
        assertTrue(test.isAt(new Vector2d(2,0)));
    }

    @Test
    void testParsingPosition() {
        Animal test = new Animal();
        String[] arr = new String[]{"fd", "f", "right", "forward", "left", "l", "right", "", "-234;dsa", "backward", "r", "b", "b"};
        for (MoveDirection x: OptionsParser.parse(arr)) {
            test.move(x);
        }
        assertTrue(test.isAt(new Vector2d(1,2)));
    }
}