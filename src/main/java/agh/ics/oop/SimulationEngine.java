package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;

    @Override
    public void run() {
        ArrayList<Animal> Animals = map.getAnimals();
        int i = 0;
        while(i < moves.length) {
            Animals.get(i%(Animals.size())).move(moves[i]);
            i++;
        }
    }

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        for (Vector2d position: positions) {
            map.place(new Animal(map, position));
        }
    }

}
