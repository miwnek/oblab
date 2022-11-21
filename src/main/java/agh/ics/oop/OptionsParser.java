package agh.ics.oop;

import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(List<String> args) {
        int count = 0;
        for (String str : args) {
            if(str.equals("f") || str.equals("forward") || str.equals("b")
                    || str.equals("backward") || str.equals("r") || str.equals("right")
                    || str.equals("l") || str.equals("left")) count++;
            else throw new IllegalArgumentException(str + " is not a legal move specification");
        }
        MoveDirection[] newArgs = new MoveDirection[count];
        int newCount = 0;
        for(String str : args){
            switch(str){
                case "f", "forward" -> newArgs[newCount++] = MoveDirection.FORWARD;
                case "b", "backward" -> newArgs[newCount++] = MoveDirection.BACKWARD;
                case "r", "right" -> newArgs[newCount++] = MoveDirection.RIGHT;
                case "l", "left" -> newArgs[newCount++] = MoveDirection.LEFT;
            }
        }
        return newArgs;
    }
}
