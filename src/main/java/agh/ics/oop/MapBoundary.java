package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> onAxisX = new TreeSet<Vector2d>(new sortByX());
    SortedSet<Vector2d> onAxisY = new TreeSet<Vector2d>(new sortByY());

    // Moim zdaniem w tych zbiorach wystarczy trzymać obiekty Vector2d, bo i tak używalibyśmy tylko przechowywanej pozycji,
    // w poleceniu było napisane żeby porównywać typy obiektu w przypadku równości, ale w naszej implementacji mapy
    // dwa obiekty nigdy nie znajdą się na tym samym polu, więc to pominąłem
    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        onAxisX.remove(oldPos);
        onAxisX.add(newPos);
        onAxisY.remove(oldPos);
        onAxisY.add(newPos);
    }

    public Vector2d lowerLeft() {
        if(onAxisX.isEmpty()) return new Vector2d(0, 0);
        return new Vector2d(onAxisX.first().x,onAxisY.first().y);
    }

    public Vector2d upperRight() {
        if(onAxisY.isEmpty()) return new Vector2d(0, 0);
        return new Vector2d(onAxisX.last().x,onAxisY.last().y);
    }

    public void place(IMapElement element) {
        if(element instanceof Animal) ((Animal) element).addObserver(this);
        Vector2d temp = element.getCurrPosition();
        onAxisX.add(temp);
        onAxisY.add(temp);
    }

    public static class sortByX implements Comparator {
        @Override
        public int compare(Object one, Object two) {
            if(one == two) return 0;
            if(one.equals(two)) return 0;
            if(!(one instanceof Vector2d first) || !(two instanceof Vector2d second)) return 0;
            if(first.x == second.x) {
                if(first.y > second.y) return 1;
                return -1;
            }
            if(first.x > second.x) return 1;
            return -1;
        }
    }

    public static class sortByY implements Comparator {
        @Override
        public int compare(Object one, Object two) {
            if(one == two) return 0;
            if(one.equals(two)) return 0;
            if(!(one instanceof Vector2d first) || !(two instanceof Vector2d second)) return 0;
            if(first.y == second.y) {
                if(first.x > second.x) return 1;
                return -1;
            }
            if(first.y > second.y) return 1;
            return -1;
        }
    }
}
