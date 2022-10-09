package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.Direction.Directions;

public class World {
    public static void run(Directions[] args, int len) {
        for(int i = 0; i < len; i++){
            switch (args[i]) {
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    out.println("Wystąpił błąd");
                    break;

            }
        }
    }

    public static void main(String[] args) {
        int len = args.length;
        Directions[] newArgs = new Directions[len];
        for(int i = 0; i < len; i++) {
            switch (args[i]) {
                case "f":
                    newArgs[i] = Directions.FORWARD;
                    break;
                case "b":
                    newArgs[i] = Directions.BACKWARD;
                    break;
                case "r":
                    newArgs[i] = Directions.RIGHT;
                    break;
                case "l":
                    newArgs[i] = Directions.LEFT;
                    break;
                default:
                    out.println("Wystąpił błąd");
                    break;
            }
        }
        out.println("Start");
        run(newArgs, len);
        out.println("Stop");
    }
}
