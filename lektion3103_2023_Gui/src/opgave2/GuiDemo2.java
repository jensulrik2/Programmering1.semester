package opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.NumberFormat;

public class GuiDemo2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("opgave5.Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfNumber = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Number:");
        pane.add(lblName, 0, 1);

        pane.add(txfNumber, 1, 1);

        Button btnIncrease = new Button("Inc");
        pane.add(btnIncrease, 2, 0);
        Button btnDecrease = new Button("Dec");
        pane.add(btnDecrease, 2, 2);

        btnIncrease.setOnAction(event -> this.increase());
        btnDecrease.setOnAction(event -> this.decrease());




    }

    // -------------------------------------------------------------------------

    private void increase(){
        int number = Integer.parseInt(txfNumber.getText());
        number++;
        String finalNum = "" + number;
        txfNumber.setText(finalNum);
    }
    private void decrease(){
        int number = Integer.parseInt(txfNumber.getText());
        number--;
        String finalNum = "" + number;
        txfNumber.setText(finalNum);

    }
}
