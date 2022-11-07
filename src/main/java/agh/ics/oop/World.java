package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.Direction.Directions;
import agh.ics.oop.Animal;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}