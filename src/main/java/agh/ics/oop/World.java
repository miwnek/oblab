package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.Direction.Directions;
import agh.ics.oop.Animal;

// Jak zaimlementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu?
// Można np. przetrzymywać aktualne pozycje wszystkich zwierząt w tablicy i zmienić metodę
// move klasy Animal aby sprawdzała dla każdego zwierzęcie metodą isAt czy znajduje się na pozycji
// docelowej zwierzęcia, dla którego jest wywoływana.
public class World {
    public static void main(String[] args) {
        Animal userAnimal = new Animal();
        MoveDirection[] newargs = OptionsParser.parse(args);
        for (MoveDirection movement: newargs) {
            userAnimal.move(movement);
        }
        out.println(userAnimal.toString());
    }
}