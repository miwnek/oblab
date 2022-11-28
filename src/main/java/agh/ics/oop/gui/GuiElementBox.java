package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox implements IPositionChangeObserver {
    private Image image;
    private ImageView imageView;
    private VBox box;
    private final int size = 20;
    public IMapElement element;
    public GuiElementBox(AbstractWorldMapElement element) {
        try {
            this.element = element;
            image = new Image(new FileInputStream(element.getPath()));
            imageView = new ImageView(image);
            imageView.setFitWidth(size);
            imageView.setFitHeight(size);
            Label pos = new Label(element.getCurrPosition().toString());
            box = new VBox(imageView);
            box.getChildren().add(pos);
            box.setAlignment(Pos.CENTER);
            box.setMinSize(40, 40);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void set() throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getPath()));
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        Label pos = new Label(element.getCurrPosition().toString());
        box = new VBox();
        box.getChildren().add(imageView);
        box.getChildren().add(pos);
        box.setAlignment(Pos.CENTER);
        box.setMinSize(55,55);
    }

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) throws FileNotFoundException { this.set(); }

    public VBox getBox() { return box; }
}
