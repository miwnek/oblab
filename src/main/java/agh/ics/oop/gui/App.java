package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Map;


public class App extends javafx.application.Application{
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw());
        IWorldMap map = new GrassField(10);
        GridPane grid = new GridPane();
        int highest, leftest;
        highest = map.upperRight().y;
        leftest = map.lowerLeft().x;
        int rangeY = highest - map.lowerLeft().y + 1;
        int rangeX = map.upperRight().x - leftest+ 1;
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));
        for(int i = 0; i < rangeX; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(30));
            Label label = new Label(Integer.toString(leftest + i));
            grid.add(label, i+1, 0,1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for(int i = 0; i < rangeY; i++) {
            grid.getRowConstraints().add(new RowConstraints(30));
            Label label = new Label(Integer.toString(highest - i));
            grid.add(label, 0, i + 1,1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        grid.setGridLinesVisible(true);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        Map<Vector2d, AbstractWorldMapElement> elems = map.getElems();
        Label corner = new Label("y/x");
        grid.add(corner, 0, 0,1, 1);
        GridPane.setHalignment(corner, HPos.CENTER);
        int x, y;
        for (AbstractWorldMapElement curr: elems.values()) {
            Vector2d currPos = curr.getCurrPosition();
            x = currPos.x - leftest + 1;
            y = highest - currPos.y + 1;
            GuiElementBox temp = new GuiElementBox(curr);
            grid.add(temp.box, x, y, 1, 1);
            GridPane.setHalignment(temp.box, HPos.CENTER);
        }
        engine.run();
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}