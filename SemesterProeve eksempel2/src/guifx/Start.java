package guifx;

import application.controller.Controller;
import application.model.Medarbejder;
import application.model.Vagt;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Start extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 800,600);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView lvwMedarbejder = new ListView<>();
    private ListView lvwVagter = new ListView<>();
    private TextArea taVagt = new TextArea();
    private Button btnVagt = new Button("Tildel vagt");


    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lbl1 = new Label("Alle medarbejdere");
        pane.add(lbl1,0,0);
        Label lbl2 = new Label("Alle vagter");
        pane.add(lbl2,1,0);
        Label lbl3 = new Label("Valgt vagt");
        pane.add(lbl3,2,0);

        pane.add(lvwMedarbejder,0,1,1,1);
        lvwMedarbejder.setPrefWidth(200);
        lvwMedarbejder.setPrefHeight(200);
        lvwMedarbejder.getItems().setAll(Controller.getMedarbejdere());

        pane.add(lvwVagter,1,1,1,1);
        lvwVagter.getItems().setAll(Controller.getVagter());
        ChangeListener<Vagt> listener = (ov, oldVagt, newVagt) -> this.selectedVagtChanged();

        pane.add(btnVagt,1,2);
//        btnVagt.setOnAction(event -> ());

        pane.add(taVagt,2,1);
    }
    private void selectedVagtChanged(){
        this.updateControls();
    }
    public void updateControls() {
        Vagt vagt = (Vagt) lvwVagter.getSelectionModel().getSelectedItem();
        if(vagt != null){

            fillAction();

        }
    }

    public void fillAction() {
        taVagt.setText(this.getDescription());
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        Vagt vagt = (Vagt) lvwVagter.getSelectionModel().getSelectedItem();
        sb.append("Navn: " + vagt.getNavn() + "\n");
        sb.append("Fra " + vagt.getTidFra() + "\n");
        sb.append("Til " + vagt.getTidTil() + "\n");
        sb.append("Tilknyttede medarbejdere" + "\n");
        ArrayList<Medarbejder> medarbejdere = vagt.getMedarbejdere();
        for(Medarbejder m : medarbejdere){
            sb.append(m.getNavn() + " ");
        }
        return sb.toString();
    }

//    public void tildelVagtAction() {
//
//        Medarbejder medarbejder = lvwMedarbejder.getSelectionModel().getSelectedItem();
//        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
//        LocalDate ankomst = lvwAnkomst.getSelectionModel().getSelectedItem();
//        LocalDate afrejse = lvwAfrejse.getSelectionModel().getSelectedItem();
//        boolean foredragsholder = false;
//    }

}
