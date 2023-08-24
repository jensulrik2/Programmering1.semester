package guifx;

import application.controller.Controller;
import application.model.Bane;
import application.model.Booking;
import application.model.Spiller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Start extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 1000,400);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<Bane> lvwBaner;
    private TextArea txaBaneBookinger;
    private ListView<Spiller> lvwSpillere;
    private TextArea txaSpillerBookinger;
    private Button btnBookBane;
    private TextField txfDato;
    private TextField txfTid;
    private CheckBox cbSingle;

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner,0,0);
        lvwBaner = new ListView<>();
        pane.add(lvwBaner,0,1);
        lvwBaner.getItems().setAll(Storage.getBaner());
        ChangeListener<Bane> listener = (ov, oldBane, newBane) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblAntalBookinger = new Label("Antal bookinger på banen");
        pane.add(lblAntalBookinger,0,2);
        txaBaneBookinger = new TextArea();
        pane.add(txaBaneBookinger,0,3,1,5);

        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere,1,0);
        lvwSpillere = new ListView<>();
        lvwSpillere.setMinWidth(150);
        pane.add(lvwSpillere,1,1);
        lvwSpillere.getItems().setAll(Storage.getSpillere());
        ChangeListener<Spiller> listener2 = (ov, oldSpiller, newSpiller) -> this.selectedSpillerChanged();
        lvwSpillere.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblSpillerBookinger = new Label("Spillerens bookinger");
        pane.add(lblSpillerBookinger,2,0);
        txaSpillerBookinger = new TextArea();
        pane.add(txaSpillerBookinger,2,1,2,1);

        Label lblOpretBooking = new Label("Opret booking");
        pane.add(lblOpretBooking,2,2);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato,2,3);
        Label lblTid = new Label("Tid:");
        pane.add(lblTid,2,4);

        btnBookBane = new Button();
        btnBookBane.setMinWidth(130);
        btnBookBane.setText("Book bane til spiller");
        pane.add(btnBookBane,2,6,2,1);
        btnBookBane.setOnAction(event -> this.btnAction());

        txfDato = new TextField();
        pane.add(txfDato,3,3);

        txfTid = new TextField();
        pane.add(txfTid,3,4);

        cbSingle = new CheckBox("Single");
        pane.add(cbSingle,3,5);

    }




        private void selectedBaneChanged() {
//            Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
//            if(bane != null){
//                StringBuilder sb = new StringBuilder();
//                for(int i = 0; i < bane.antalBookningerPrTime().length; i++){
//                    sb.append("Tid: " + i+9 ":00" + "antal: " + bane.antalBookningerPrTime().get[i]);
//                }
//                txaBaneBookinger.setText(sb.toString());
//
//            }
        }

    private void selectedSpillerChanged() {
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        if(spiller != null){
            StringBuilder sb = new StringBuilder();
            ArrayList<Booking> bookinger = spiller.getBookinger();
            for(Booking b : bookinger){
                sb.append(b.getDato() + " " + b.getTid() + ", " + b.isSingle() + ", bane nr." + b.getBane().getNummer() + ", " + b.getSpiller().getNavn() + "\n");
            }
            txaSpillerBookinger.setText(sb.toString());

        }
    }


        public void btnAction(){
            Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
            Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
            LocalDate dato = LocalDate.parse(txfDato.getText());
            LocalTime tid = LocalTime.parse(txfTid.getText());
            Boolean single = false;

            if(spiller != null && bane != null && !txaSpillerBookinger.equals("") && !txaBaneBookinger.equals("")){
                if(cbSingle.isSelected()){
                    single = true;
                }
                spiller.createBooking(dato,tid,single,bane);
            }
            else if(!bane.tidLedig(dato,tid)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Date not available");
                alert.setHeaderText("Time Error");
                // wait for the modal dialog to close
                alert.show();
            }


        }











}
