import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui extends Application {


        @Override
        public void start(Stage stage) {
            Pane pane = new Pane();
            Car car1 = new Car();
            Scene scene = new Scene(pane, 400, 400);
            stage.setTitle("Shapes");
            stage.setScene(scene);
            stage.show();
        }

    private void initContent(Pane pane, Car car) {
            int firstWheelX = 100;
            int firstWheelY = 200;
            int wheels = 4;
            int[] numbWheel = new int[wheels];
            int firstDoorX = 110;
            int firstDoorY = 130;
            int doors = 4;
            int[] numbDoor = new int[doors];
            Rectangle body = new Rectangle(70, 150, 150, 50);
            pane.getChildren().add(body);
            body.setFill(car.getColor());
            Rectangle body2 = new Rectangle(100, 120, 80, 30);
            pane.getChildren().add(body2);
            body2.setFill(Color.RED);
            for (int i = 0; i < car.getDoors(); i++) {
                Rectangle door = new Rectangle(firstDoorX, firstDoorY, 15, 30);
                pane.getChildren().add(door);
                door.setFill(Color.DEEPPINK);
                door.setStroke(Color.BLACK);
                firstDoorX += 15;
            }
            for (int i = 0; i < car.getWheels(); i++) {
                Circle wheel = new Circle(firstWheelX, firstWheelY, 15);
                pane.getChildren().add(wheel);
                wheel.setFill(Color.DEEPPINK);
                wheel.setStroke(Color.BLACK);
                firstWheelX += 30;
            }
        }
    }