package agh.ics.oop;


public class Animal {
    private  MapDirection currDirection = MapDirection.NORTH;
    private  Vector2d currPosition = new Vector2d(2, 2);

    public String toString() {
        return String.join("", currPosition.toString(), " ", currDirection.toString());
    }

    public boolean isAt(Vector2d position) {
        return (currPosition.equals(position));
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> currDirection = currDirection.next();
            case LEFT -> currDirection = currDirection.previous();
            case FORWARD -> currPosition = currPosition.add(currDirection.toUnitVector());
            case BACKWARD -> currPosition = currPosition.subtract(currDirection.toUnitVector());
        }
        currPosition = currPosition.lowerLeft(new Vector2d(4, 4));
        currPosition = currPosition.upperRight(new Vector2d(0, 0));
    }
}
