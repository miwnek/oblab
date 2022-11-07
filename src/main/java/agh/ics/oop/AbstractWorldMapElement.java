package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement{
    protected Vector2d currPosition;

    @Override
    public boolean isAt(Vector2d pos) {
        return currPosition.equals(pos);
    }
    @Override
    public Vector2d getCurrPosition(){
        return currPosition;
    }
}
