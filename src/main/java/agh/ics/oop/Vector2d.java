package agh.ics.oop;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.MapDirection;

class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.join("","(", String.valueOf(this.x), ", ",
                String.valueOf(this.y), ")");
    }

    public boolean precedes(Vector2d other) {
        return (this.x <= other.x) && (this.y <= other.y);
    }

    public boolean follows(Vector2d other) {
        return (this.x >= other.x) && (this.y >= other.y);
    }
    public Vector2d upperRight(Vector2d other) {
        int newX, newY;
        newX = Math.max(x, other.x);
        newY = Math.max(y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int newX, newY;
        newX = Math.min(x, other.x);
        newY = Math.min(y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x+other.x, y+other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x-other.x, y-other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return (x==that.x)&&(y==that.y);
    }

    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }

    public static void main(String[] args ) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection var = MapDirection.NORTH;
        Vector2d new_var = var.toUnitVector();
        System.out.println(new_var);
    }
}