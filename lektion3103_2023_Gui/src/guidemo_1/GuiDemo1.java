package guidemo_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo1 extends Application {



    @Override
    public void start(Stage stage) {
        stage.setTitle("opgave5.Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    private TextField txfName3 = new TextField();
    private TextField txfName = new TextField();
    private TextField txfName2 = new TextField();
    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("First name:");
        pane.add(lblName, 0, 0);

        Label lblName2 = new Label("Last name:");
        pane.add(lblName2, 2, 0);

        Label lblName3 =  new Label("Full name:");
        pane.add(lblName3, 0, 2);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)


        pane.add(txfName, 0, 1, 1, 1);
        pane.add(txfName2, 2, 1, 1, 1);
        pane.add(txfName3, 0, 3, 3, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 2, 4);
        GridPane.setMargin(btnCombine, new Insets(10,10,0,10));

        btnCombine.setOnAction(event -> this.fillAction());
//
//        // add a button to the pane (at col=2, row=1)
//        Button btnLowerCase = new Button("Lower Case");
//        pane.add(btnLowerCase, 2, 1);
//        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));
    }


    private void fillAction() {
        String first = txfName.getText();
        String second = txfName2.getText();
        String combined = first + " " + second;
        this.txfName3.setText(combined);
    }


}
