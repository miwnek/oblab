package agh.ics.oop;

import java.io.FileNotFoundException;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPos, Vector2d newPos) throws FileNotFoundException;
    //Vector2d lowerLeft();
    //Vector2d upperRight();
    //void place(IMapElement element);
}
