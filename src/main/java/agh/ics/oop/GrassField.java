package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Integer.MAX_VALUE;

public class GrassField extends AbstractWorldMap{
    final int width = MAX_VALUE;
    final int height = MAX_VALUE;
    protected int fieldsNumber;

    @Override
    public boolean canMoveTo(Vector2d pos) {
        for (AbstractWorldMapElement checked : elems) {
            if(checked.isAt(pos)){
                if(checked instanceof Animal) return false;
                while(true) {
                    Random rand = new Random();
                    int x = rand.nextInt((int) Math.sqrt(fieldsNumber*10));
                    Random randy = new Random();
                    int y = randy.nextInt((int) Math.sqrt(fieldsNumber*10));
                    if(!isOccupied(new Vector2d(x, y))){
                        elems.add(new Grass(new Vector2d(x, y)));
                        break;
                    }
                }
                elems.remove(checked);
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        for (AbstractWorldMapElement checked : elems) {
            if(checked.isAt(animal.getCurrPosition())) {
                if(checked instanceof Animal) return false;
                while(true) {
                    Random rand = new Random();
                    int x = rand.nextInt((int) Math.sqrt(fieldsNumber*10));
                    Random randy = new Random();
                    int y = randy.nextInt((int) Math.sqrt(fieldsNumber*10));
                    if(!isOccupied(new Vector2d(x, y))){
                        elems.add(new Grass(new Vector2d(x, y)));
                        break;
                    }
                }
                elems.remove(checked);
                elems.add(animal);
                return true;
            }
        }
        elems.add(animal);
        return true;
    }

    @Override
    public Vector2d lowerLeft() {
        int left = elems.get(0).getCurrPosition().x;
        int down  = elems.get(0).getCurrPosition().y;
        for (AbstractWorldMapElement checked: elems) {
            left = Math.min(left, checked.getCurrPosition().x);
            down = Math.min(down, checked.getCurrPosition().y);
        }
        return new Vector2d(left, down);
    }

    @Override
    public Vector2d upperRight() {
        int right = elems.get(0).getCurrPosition().x;
        int up  = elems.get(0).getCurrPosition().y;
        for (AbstractWorldMapElement checked: elems) {
            right = Math.max(right, checked.getCurrPosition().x);
            up = Math.max(up, checked.getCurrPosition().y);
        }
        return new Vector2d(right, up);
    }



    public GrassField(int number) {
        fieldsNumber = number;
        int x, y;
        while(elems.size() != fieldsNumber) {
            Random rand = new Random();
            x = rand.nextInt((int) Math.sqrt(number*10));
            Random randy = new Random();
            y = randy.nextInt((int) Math.sqrt(number*10));
            if(!isOccupied(new Vector2d(x, y))) {
                elems.add(new Grass(new Vector2d(x, y)));
            }

        }
    }
}
