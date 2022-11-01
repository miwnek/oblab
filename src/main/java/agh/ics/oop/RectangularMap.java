package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    final int width;
    final int height;
    public ArrayList<Animal> Animals = new ArrayList<>();
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)))) return false;
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal newAnimal) {
        Vector2d position = newAnimal.getCurrPosition();
        if(!(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)))) return false;
        if(isOccupied(position)) return false;
        Animals.add(newAnimal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal checked : Animals) {
            if(checked.isAt(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal checked : Animals) {
            if(checked.isAt(position)) return checked;
        }
        return null;
    }

    public String toString() {
        MapVisualizer mapPic = new MapVisualizer(this);
        return mapPic.draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
}
