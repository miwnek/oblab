package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    final int width;
    final int height;

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)))) return false;
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal newAnimal) {
        Vector2d position = newAnimal.getCurrPosition();
        if(!(position.precedes(new Vector2d(width, height)) && position.follows(new Vector2d(0,0)))) return false;
        return super.place(newAnimal);
    }
    @Override
    public Vector2d lowerLeft() {
        return new Vector2d(0, 0);
    }
    @Override
    public Vector2d upperRight() {
        return new Vector2d(width, height);
    }

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
}
