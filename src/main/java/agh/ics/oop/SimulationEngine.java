package agh.ics.oop;

import agh.ics.oop.gui.App;
import agh.ics.oop.gui.GuiElementBox;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static agh.ics.oop.gui.App.updateApp;

public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> Animals = new ArrayList<>();

//    @Override
//    public void run() {
//        int i = 0;
//        while(i < moves.length) {
//            System.out.println(map.toString());
//            Animals.get(i%(Animals.size())).move(moves[i]);
//            i++;
//        }
//        System.out.println(map.toString());
//    }

    @Override
    public void run(){
        for(Animal observer : Animals){
            GuiElementBox elementBox = new GuiElementBox(observer);
            observer.addObserver(elementBox);
        }
        Platform.runLater(()->{
            try {
                updateApp();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        appSleep();

        int i = 0;
        while(i < moves.length) {
            Animals.get(i%(Animals.size())).move(moves[i]);
            Platform.runLater(()->{
                try {
                    updateApp();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
            appSleep();
            i++;
        }

    }


    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        for (Vector2d position: positions) {
            Animal temp  = new Animal(map, position);
            if(this.map.place(temp)) Animals.add(temp);;
        }
    }

    public void appSleep() {
        try {
            Thread.sleep(App.moveDelay);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setMoves(MoveDirection[] args) {
        moves = args;
    }
    public ArrayList<Animal> getElems() {
        return Animals;
    }

}
