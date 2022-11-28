package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public class App extends javafx.application.Application{
    public static final int moveDelay = 400;
    static int highest, leftest;
    static int rangeY, rangeX;
    static int x, y;
    static Stage primaryStage;
    static IWorldMap map;
    static GridPane grid;
    static boolean flag = true;
    SimulationEngine engine;
    @Override
    public void start(Stage primaryStageArg) throws FileNotFoundException {
        primaryStage = primaryStageArg;
        map = new GrassField(10);
        grid = new GridPane();
        grid.setPrefSize(650, 650);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw());
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        engine = new SimulationEngine(directions, map, positions);

        TextField input = new TextField();
        if (args.length == 0) {
            input.setPromptText("Arguments: ");
        } else {
            input.setPromptText(String.join(" ", args));
        }
        input.setPrefColumnCount(10);

        Button Start = new Button("START");
        Start.setOnMouseClicked(event -> {
            if ((input.getText() != null && !input.getText().isEmpty())) {
                try {
                    engine.setMoves(OptionsParser.parse(List.of(input.getText().split(" "))));
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.toString());
                    Platform.exit();
                }
            }
            Thread engineThread = new Thread(engine);
            engineThread.start();
            Start.setDisable(true);
            input.setDisable(true);
        });

        HBox startingBox = new HBox(2, Start, input);
        startingBox.setAlignment(Pos.CENTER);
        VBox app = new VBox(2, grid, startingBox);
        Scene scene = new Scene(app, 750, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
        updateApp();

    }

    public static void updateApp() throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();

        highest = map.upperRight().y;
        leftest = map.lowerLeft().x;
        rangeY = highest - map.lowerLeft().y + 1;
        rangeX = map.upperRight().x - leftest+ 1;

        for (int i = 0; i < rangeX; i++) {
            Label label = new Label(Integer.toString(leftest + i));
            label.setMinSize(55,40);
            label.setAlignment(Pos.CENTER);
            grid.add(label, i + 1, 0, 1, 1);
        }
        for (int i = 0; i < rangeY; i++) {
            Label label = new Label(Integer.toString(highest - i));
            label.setMinSize(40, 55);
            label.setAlignment(Pos.CENTER);
            grid.add(label, 0, i + 1, 1, 1);
        }


        Label corner = new Label("y/x");
        corner.setMinSize(40, 40);
        corner.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
        grid.add(corner, 0, 0,1, 1);

        Map<Vector2d, AbstractWorldMapElement> elems = map.getElems();
        for (AbstractWorldMapElement curr: elems.values()) {
            GuiElementBox guiElement = new GuiElementBox(curr);
            Vector2d currPos = curr.getCurrPosition();
            x = currPos.x - leftest + 1;
            y = highest - currPos.y + 1;
            guiElement.set();
            grid.add(guiElement.getBox(), x, y, 1, 1);
            GridPane.setHalignment(guiElement.getBox(), HPos.CENTER);
        }
    }
}