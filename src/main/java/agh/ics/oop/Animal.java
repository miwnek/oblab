package agh.ics.oop;


public class Animal extends AbstractWorldMapElement{
    private  MapDirection currDirection = MapDirection.NORTH;

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
                    currPosition = desiredPosition;
                }
            }
            case BACKWARD -> {
                Vector2d desiredPosition = currPosition.subtract(currDirection.toUnitVector());
                if(map.canMoveTo(desiredPosition)) {
                    currPosition = desiredPosition;
                }
            }
        }
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        currPosition = initialPosition;

    }
}
