package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement{
    private  MapDirection currDirection = MapDirection.NORTH;
    protected ArrayList<IPositionChangeObserver> observerList = new ArrayList<>();
    private final IWorldMap map;

    public String toString() {
        switch(currDirection) {
            case WEST -> { return "W"; }
            case EAST -> { return "E"; }
            case NORTH -> { return "N"; }
            case SOUTH -> { return "S"; }
        }
        return null;
    }


    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> currDirection = currDirection.next();
            case LEFT -> currDirection = currDirection.previous();
            case FORWARD -> {
                Vector2d desiredPosition = currPosition.add(currDirection.toUnitVector());
                if(map.canMoveTo(desiredPosition)) {
                    positionChanged(currPosition, desiredPosition);
                    currPosition = desiredPosition;
                }
            }
            case BACKWARD -> {
                Vector2d desiredPosition = currPosition.subtract(currDirection.toUnitVector());
                if(map.canMoveTo(desiredPosition)) {
                    positionChanged(currPosition, desiredPosition);
                    currPosition = desiredPosition;
                }
            }
        }
    }

    public void  addObserver(IPositionChangeObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        for(IPositionChangeObserver curr : observerList) {
            curr.positionChanged(oldPos, newPos);
        }
        map.positionChanged(oldPos, newPos);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        currPosition = initialPosition;

    }
}
