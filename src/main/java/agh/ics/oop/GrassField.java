package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Integer.MAX_VALUE;

public class GrassField implements IWorldMap{
    final int width = MAX_VALUE;
    final int height = MAX_VALUE;
    public ArrayList<Animal> Animals = new ArrayList<>();
    public ArrayList<Grass> Fields = new ArrayList<>();
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)))) return false;
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal checked : Animals) {
            if(checked.isAt(position)) return true;
        }
        for (Grass checked : Fields) {
            if(checked.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal checked : Animals) {
            if(checked.isAt(position)) return checked;
        }
        for (Grass checked : Fields) {
            if(position.equals(checked.getPosition())) return checked;
        }
        return null;
    }
    @Override
    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public String toString() {
        MapVisualizer mapPic = new MapVisualizer(this);
        return mapPic.draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    public boolean putGrass(Vector2d desired) {
        for (:
             ) {

        }
    }

    public GrassField(int number) {
        int x, y;
        for(int i = 0; i < number; i++) {
            Random rand = new Random();
            x = rand.nextInt((int) Math.sqrt(number*10));
            Random randy = new Random();
            y = randy.nextInt((int) Math.sqrt(number*10));

        }
    }
}
