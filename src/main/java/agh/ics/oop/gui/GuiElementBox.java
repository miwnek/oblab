package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private Image image;
    private ImageView imageView;
    public VBox box;
    public GuiElementBox(AbstractWorldMapElement element) throws FileNotFoundException {
        image = new Image(new FileInputStream(element.getPath()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label pos = new Label(element.getCurrPosition().toString());
        box = new VBox(imageView);
        box.getChildren().add(pos);
        box.setAlignment(Pos.CENTER);
        box.setMinSize(50,50);
    }
}
