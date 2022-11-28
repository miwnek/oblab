package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap{
    protected Map<Vector2d, AbstractWorldMapElement> elemsMap = new HashMap<>();
    protected MapBoundary observer = new MapBoundary();


    @Override
    public boolean isOccupied(Vector2d pos) {
        return elemsMap.containsKey(pos);
    }
    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getCurrPosition())) {
            elemsMap.put(animal.getCurrPosition(), animal);
            observer.place(animal);
            return true;
        }
        throw new IllegalArgumentException("Field " + animal.getCurrPosition().toString() + " is already occupied by another animal.");
    }
    @Override
    public boolean canMoveTo(Vector2d pos) {
        return !isOccupied(pos);
    }
    @Override
    public Object objectAt(Vector2d pos) {
        return elemsMap.get(pos);
    }

    @Override
    public String toString() {
        MapVisualizer mapPic = new MapVisualizer(this);
        return mapPic.draw(this.lowerLeft(), this.upperRight());
    }

    @Override
    public Map<Vector2d, AbstractWorldMapElement> getElems() {
        return elemsMap;
    }

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        AbstractWorldMapElement temp = elemsMap.get(oldPos);
        elemsMap.remove(oldPos);
        elemsMap.put(newPos, temp);
    }

}
