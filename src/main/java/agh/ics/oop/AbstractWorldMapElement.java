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
    @Override
    public String getPath() {
        if(this instanceof Grass) return "src/main/resources/Grass.png";
        switch(this.toString()) {
            case "W" -> {return "src/main/resources/left.png";}
            case "E" -> {return "src/main/resources/right.png";}
            case "N" -> {return "src/main/resources/up.png";}
            case "S" -> {return "src/main/resources/down.png";}
        }
        return "";
    }
}
