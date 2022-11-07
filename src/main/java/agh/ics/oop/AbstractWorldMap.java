package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    protected ArrayList<AbstractWorldMapElement> elems = new ArrayList<>();

    @Override
    public boolean isOccupied(Vector2d pos) {
        for (AbstractWorldMapElement checked: elems) {
            if(checked.isAt(pos)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getCurrPosition())) {
            elems.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean canMoveTo(Vector2d pos) {
        for (AbstractWorldMapElement checked: elems) {
            if(checked.isAt(pos)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public Object objectAt(Vector2d pos) {
        for (AbstractWorldMapElement checked: elems) {
            if(checked.isAt(pos)) {
                return checked;
            }
        }
        return null;
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

}
