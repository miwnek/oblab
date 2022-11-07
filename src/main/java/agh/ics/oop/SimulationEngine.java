package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    private final IWorldMap map;

    @Override
    public void run() {
        ArrayList<Animal> Animals = new ArrayList<>();
        for (AbstractWorldMapElement checked : map.getElems()) {
            if(checked instanceof Animal) Animals.add((Animal) checked);
        }
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
            this.map.place(new Animal(map, position));
        }
    }

}
