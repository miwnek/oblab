package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void testMainOne() {
        String[] args = {"f","b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<Animal> Animals = map.getAnimals();
        assertTrue(Animals.get(0).isAt(new Vector2d(2, 0)) && Animals.get(1).isAt(new Vector2d(3, 5)));
    }

    @Test
    void testMainTwo() {
        String[] args = {"f","b", "r", "l", "f", "f", "r", "f", "f", "b", "f", "b", "r", "l", "f", "b", "f", "b"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(1,3), new Vector2d(4,4), new Vector2d(4, 5) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<Animal> Animals = map.getAnimals();
        assertTrue(Animals.size() == 2 && Animals.get(0).isAt(new Vector2d(0, 3)) && Animals.get(1).isAt(new Vector2d(4, 4)));
    }
}