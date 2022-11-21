package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> Animals = new ArrayList<>();

    @Override
    public void run() {
        int i = 0;
        while(i < moves.length) {
            System.out.println(map.toString());
            Animals.get(i%(Animals.size())).move(moves[i]);
            i++;
        }
        System.out.println(map.toString());
    }

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        for (Vector2d position: positions) {
            Animal temp  = new Animal(map, position);
            if(this.map.place(temp)) Animals.add(temp);;
        }
    }

    public ArrayList<Animal> getElems() {
        return Animals;
    }

}
