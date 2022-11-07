package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<AbstractWorldMapElement> elems = new ArrayList<>();
    protected Map<Vector2d, AbstractWorldMapElement> elemsMap = new HashMap<>();


    @Override
    public boolean isOccupied(Vector2d pos) {
        return elemsMap.containsKey(pos);
    }
    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getCurrPosition())) {
            elems.add(animal);
            elemsMap.put(animal.getCurrPosition(), animal);
            return true;
        }
        return false;
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
    public ArrayList<AbstractWorldMapElement> getElems() {
        return elems;
    }

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        AbstractWorldMapElement temp;
    }

}
