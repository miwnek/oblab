package agh.ics.oop;

import javafx.application.Application;
import agh.ics.oop.gui.App;
public class World {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

//MoveDirection[] directions = OptionsParser.parse(args);
//IWorldMap map = new GrassField(10);
//Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//IEngine engine = new SimulationEngine(directions, map, positions);
//engine.run();