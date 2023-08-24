package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    private final TextField txfNumber2 = new TextField();
    private final TextField txfNumber3 = new TextField();
    private final TextField txfNumber4 = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Investment: ");
        pane.add(lblName, 0, 0);
        pane.add(txfNumber, 1, 0);

        Label lblName2 = new Label("Years: ");
        pane.add(lblName2, 0, 1);
        pane.add(txfNumber2, 1, 1);

        Label lblName3 = new Label("Interest (%): ");
        pane.add(lblName3, 0, 2);
        pane.add(txfNumber3, 1, 2);

        Label lblName4 = new Label("Future Value: ");
        pane.add(lblName4, 0, 4,1,2);
        pane.add(txfNumber4, 1, 4,1,2);

        Button btnIncrease = new Button("Calculate");
        pane.add(btnIncrease, 1, 3,1,5);
        btnIncrease.setOnAction(event -> this.calculate());







    }

    // -------------------------------------------------------------------------
    private void calculate(){
        int investment = Integer.parseInt(txfNumber.getText());
        int years = Integer.parseInt(txfNumber.getText());
        double interest = Integer.parseInt(txfNumber.getText());

        double fValue =  investment * Math.pow((1 + interest / 100), years);
        txfNumber4.setText("" + Math.round(fValue * 100.0) / 100.0);



    }
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
