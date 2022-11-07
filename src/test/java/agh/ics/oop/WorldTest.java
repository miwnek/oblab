package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void testRectOne() {
        String[] args = {"f","b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<AbstractWorldMapElement> Animals = map.getElems();
        assertTrue(Animals.get(0).isAt(new Vector2d(2, 0)) && Animals.get(1).isAt(new Vector2d(3, 5)));
    }

    @Test
    void testRectTwo() {
        String[] args = {"f","b", "r", "l", "f", "f", "r", "f", "f", "b", "f", "b", "r", "l", "f", "b", "f", "b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(1,3), new Vector2d(4,4), new Vector2d(4, 5) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<AbstractWorldMapElement> Animals = map.getElems();
        assertTrue(Animals.size() == 2 && Animals.get(0).isAt(new Vector2d(0, 3)) && Animals.get(1).isAt(new Vector2d(4, 4)));
    }

    @Test
    void testGrass() {
        String[] args = {"r","l", "f", "f", "f", "f", "l", "l", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(10, 10), new Vector2d(0, 0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<AbstractWorldMapElement> elems = map.getElems();
        int animalNum = 0;
        int fieldsNum = 0;
        for (AbstractWorldMapElement checked : elems) {
            if(checked instanceof Animal) animalNum++;
            else if(checked instanceof Grass) fieldsNum++;
        }
        assertEquals(2, animalNum);
        assertEquals(10, fieldsNum);
        assertTrue(map.upperRight().follows(new Vector2d(12,12)));
        assertTrue(map.lowerLeft().precedes(new Vector2d(-2,-2)));
    }
}