import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
public class Main {
    public static void main(String[] args) {

        Car car1 = new Car(Color.GREEN, 250, 2);

        Car car2 = new Car();

        System.out.println(car1);
        System.out.println();
        System.out.println(car2);

        Gui.launch(Gui.class);
    }



}