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
        if(elemsMap.containsKey(pos)) {
            AbstractWorldMapElement temp = elemsMap.get(pos);
            if(temp instanceof Animal) return false;
            while(true) {
                Random rand = new Random();
                int x = rand.nextInt((int) Math.sqrt(fieldsNumber*10));
                Random randy = new Random();
                int y = randy.nextInt((int) Math.sqrt(fieldsNumber*10));
                if(!isOccupied(new Vector2d(x, y))){
                    Grass fieldOfGrass = new Grass(new Vector2d(x, y));
                    elemsMap.put(new Vector2d(x, y), fieldOfGrass);
                    observer.positionChanged(pos, fieldOfGrass.currPosition);
                    break;
                }
            }
            return true;
        }
        return true;

    }

    @Override
    public boolean place(Animal animal) {
        if(elemsMap.containsKey(animal.getCurrPosition())) {
            AbstractWorldMapElement temp = elemsMap.get(animal.getCurrPosition());
            if(temp instanceof Animal){
                throw new IllegalArgumentException("Field " + animal.getCurrPosition().toString() + " is already occupied by another animal.");
            }
            while(true) {
                Random rand = new Random();
                int x = rand.nextInt((int) Math.sqrt(fieldsNumber*10));
                Random randy = new Random();
                int y = randy.nextInt((int) Math.sqrt(fieldsNumber*10));
                if(!isOccupied(new Vector2d(x, y))){
                    Grass fieldOfGrass = new Grass(new Vector2d(x, y));
                    elemsMap.put(new Vector2d(x, y), fieldOfGrass);
                    break;
                }
            }
            elemsMap.put(animal.getCurrPosition(), animal);
            observer.place(animal);
            return true;
        }
        elemsMap.put(animal.getCurrPosition(), animal);
        observer.place(animal);
        return true;
    }

    @Override
    public Vector2d lowerLeft() {
        return observer.lowerLeft();
    }

    @Override
    public Vector2d upperRight() {
        return observer.upperRight();
    }



    public GrassField(int number) {
        fieldsNumber = number;
        int x, y;
        int i = 0;
        while(i < fieldsNumber) {
            Random rand = new Random();
            x = rand.nextInt((int) Math.sqrt(number*10));
            Random randy = new Random();
            y = randy.nextInt((int) Math.sqrt(number*10));
            if(!isOccupied(new Vector2d(x, y))) {
                Grass fieldOfGrass = new Grass(new Vector2d(x, y));
                i++;
                elemsMap.put(new Vector2d(x, y), fieldOfGrass);
                observer.place(fieldOfGrass);
            }

        }
    }
}