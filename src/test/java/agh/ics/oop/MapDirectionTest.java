package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test
    void testNext() {
        MapDirection[] allDirections = new MapDirection[]{MapDirection.NORTH, MapDirection.SOUTH, MapDirection.EAST, MapDirection.WEST};
        for (MapDirection currDirection : allDirections) {
            if(currDirection == MapDirection.NORTH) assertEquals(currDirection.next(), MapDirection.EAST);
            if(currDirection == MapDirection.SOUTH) assertEquals(currDirection.next(), MapDirection.WEST);
            if(currDirection == MapDirection.EAST) assertEquals(currDirection.next(), MapDirection.SOUTH);
            if(currDirection == MapDirection.WEST) assertEquals(currDirection.next(), MapDirection.NORTH);
        }
    }

    @Test
    void testPrevious() {
        MapDirection[] allDirections = new MapDirection[]{MapDirection.NORTH, MapDirection.SOUTH, MapDirection.EAST, MapDirection.WEST};
        for (MapDirection currDirection : allDirections) {
            if(currDirection == MapDirection.NORTH) assertEquals(currDirection.previous(), MapDirection.WEST);
            if(currDirection == MapDirection.SOUTH) assertEquals(currDirection.previous(), MapDirection.EAST);
            if(currDirection == MapDirection.EAST) assertEquals(currDirection.previous(), MapDirection.NORTH);
            if(currDirection == MapDirection.WEST) assertEquals(currDirection.previous(), MapDirection.SOUTH);
        }
    }
}