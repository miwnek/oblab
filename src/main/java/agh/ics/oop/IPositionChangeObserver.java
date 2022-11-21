package agh.ics.oop;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPos, Vector2d newPos);
    Vector2d lowerLeft();
    Vector2d upperRight();
    void place(IMapElement element);
}
