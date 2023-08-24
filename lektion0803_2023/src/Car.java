import java.awt.*;
import javafx.scene.paint.Color;

public class Car {

    private Color color;
    private int speed;
    private int doors;
    private int wheels;


    public Car(Color color, int speed, int doors) {
        this();
        this.color = color;
        this.speed = speed;
        this.doors = doors;
    }

    public Car(){
        color = Color.GREEN;
        doors = 1;
        wheels = 3;

    }

    public Color getColor(){
        return color;
    }

    public int getDoors(){
        return doors;
    }

    public int getWheels(){
        return wheels;
    }

    public void getCar(){
        System.out.println("Car:");
        System.out.println("speed: " + speed);
        System.out.println("doors: " + doors);
        System.out.println("wheels: " + wheels);

    }
    @Override
    public String toString(){
        return color + " vehicle with " + doors + " doors";
    }
}
