package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.Direction.Directions;

public class World {
    public static void run(Directions[] args, int len) {
        for(int i = 0; i < len; i++){
            switch (args[i]) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
                case LEFT -> out.println("Zwierzak skręca w lewo");
                default -> out.println("Wystąpił błąd");
            }
        }
    }

    public static void main(String[] args) {
        int len = args.length;
        Directions[] newArgs = new Directions[len];
        for(int i = 0; i < len; i++) {
            switch (args[i]) {
                case "f" -> newArgs[i] = Directions.FORWARD;
                case "b" -> newArgs[i] = Directions.BACKWARD;
                case "r" -> newArgs[i] = Directions.RIGHT;
                case "l" -> newArgs[i] = Directions.LEFT;
                default -> out.println("Wystąpił błąd");
            }
        }
        out.println("Start");
        run(newArgs, len);
        out.println("Stop");
    }
}