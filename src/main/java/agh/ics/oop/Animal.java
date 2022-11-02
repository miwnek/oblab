package agh.ics.oop;


public class Animal {
    private  MapDirection currDirection = MapDirection.NORTH;
    private  Vector2d currPosition = new Vector2d(2, 2);
    private IWorldMap map;

    public String toString() {
        switch(currDirection) {
            case WEST -> { return "W"; }
            case EAST -> { return "E"; }
            case NORTH -> { return "N"; }
            case SOUTH -> { return "S"; }
        }
        return null;
    }

    public boolean isAt(Vector2d position) {
        return (currPosition.equals(position));
    }

    public Vector2d getCurrPosition() {return currPosition;}

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
    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        currPosition = initialPosition;

    }
}
