package guifx;

import application.controller.Controller;
import application.model.Forestilling;
import application.model.Bestilling;
import application.model.Kunde;
import application.model.Plads;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Pane extends Application {



    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater Forestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    private ListView<Forestilling> lvwForestillinger;
    private ListView<Kunde> lvwKunder;
    private ListView<Plads> lvwPladser;
    private TextField txfNavn,txfStart,txfSlut,txfKundeNavn,txfMobil,txfDato;
    private Button btnOpretForestilling;
    private Button btnOpretKunde;

    private Button btnOpretBestilling;


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
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger,0,0);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 2,0);

        Label lblPlads = new Label("Pladser");
        pane.add(lblPlads, 4,0);

        lvwForestillinger = new ListView<>();
        pane.add(lvwForestillinger, 0, 1, 2, 1);
        lvwForestillinger.setPrefWidth(200);
        lvwForestillinger.setPrefHeight(200);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());

        lvwKunder = new ListView<>();
        pane.add(lvwKunder, 2, 1, 2, 1);
        lvwKunder.setPrefWidth(200);
        lvwKunder.setPrefHeight(200);
        lvwKunder.getItems().setAll(Controller.getKunder());

        lvwPladser = new ListView<>();
        pane.add(lvwPladser, 4, 1, 2, 1);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll(Controller.getPladser());




        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 2);

        Label lblStart = new Label("Start dato");
        pane.add(lblStart, 0, 3);

        Label lblSlut =  new Label("Slut dato");
        pane.add(lblSlut, 0, 4);

        Label lblKundeNavn = new Label("Kunde navn");
        pane.add(lblKundeNavn, 2,2);

        Label lblMobil = new Label("Kunde mobil");
        pane.add(lblMobil, 2,3);

        Label lblDato = new Label("Dato");
        pane.add(lblDato, 4,2);



        txfNavn = new TextField();
        pane.add(txfNavn, 1, 2);
        txfNavn.setEditable(true);

        txfStart = new TextField();
        pane.add(txfStart, 1, 3);
        txfStart.setEditable(true);

        txfSlut = new TextField();
        pane.add(txfSlut, 1, 4);
        txfSlut.setEditable(true);

        txfKundeNavn = new TextField();
        pane.add(txfKundeNavn, 3, 2);
        txfKundeNavn.setEditable(true);

        txfMobil = new TextField();
        pane.add(txfMobil, 3, 3);
        txfMobil.setEditable(true);

        txfDato = new TextField();
        pane.add(txfDato, 5,2);
        txfDato.setEditable(true);


        btnOpretForestilling = new Button("Opret forestilling");
        pane.add(btnOpretForestilling,1,5);
        btnOpretForestilling.setOnAction(event -> btnOpretForestilling());

        btnOpretKunde = new Button("Opret kunde");
        pane.add(btnOpretKunde,3,4);
        btnOpretKunde.setOnAction(event -> btnOpretKunde());

        btnOpretBestilling = new Button("Opret Bestilling");
        pane.add(btnOpretBestilling,5,3);
        lvwPladser.getSelectionModel().setSelectionMode((SelectionMode.MULTIPLE));
        btnOpretBestilling.setOnAction(event -> btnOpretBestilling());




    }


    private void btnOpretBestilling() {
        LocalDate dato = LocalDate.parse(txfDato.getText());
        Forestilling forestilling = (Forestilling) lvwForestillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = (Kunde) lvwKunder.getSelectionModel().getSelectedItem();
        ArrayList<Plads> pladser = new ArrayList<Plads>(lvwPladser.getSelectionModel().getSelectedItems());

        if(dato.equals("") || forestilling.equals(null) || kunde.equals(null) || pladser.equals(null)){
            popUpError();
        }else{
            popUp(Controller.opretBestillingMedPladser(forestilling,kunde,dato,pladser));
        }

        txfDato.clear();



    }


    public void btnOpretForestilling() {
        String navn = txfNavn.getText();
        LocalDate dato = LocalDate.parse(txfStart.getText());
        LocalDate slutDato = LocalDate.parse(txfSlut.getText());
        Controller.createForestilling(navn, dato, slutDato);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());
        txfNavn.clear();
        txfSlut.clear();
        txfStart.clear();

    }

    public void btnOpretKunde() {
        String navn = txfKundeNavn.getText();
        String mobilNummer = txfMobil.getText();
        Controller.createKunde(navn, mobilNummer);
        lvwKunder.getItems().setAll(Controller.getKunder());
        txfKundeNavn.clear();
        txfMobil.clear();
    }

    public static void popUp(Bestilling bestilling){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Bestilling oprettet");
        alert.setContentText("Bestilling oprettet for "+ bestilling.getKunde().getNavn()+" til "+bestilling.getForestilling().getNavn()+" d. "+bestilling.getDato()+" med pladserne "+bestilling.getPladser().size());
        alert.showAndWait();
//        JFrame frame = new JFrame("Opret Bestilling");
//
//        JOptionPane.showMessageDialog(frame, bestilling,"Opret Bestilling", JOptionPane.INFORMATION_MESSAGE);
//
//        frame.setSize(350,350);
//        frame.setVisible(false);
    }

    private void popUpError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Bestilling ikke oprettet");
        alert.setContentText("Der er opstået en fejl - Prøv igen.");
        alert.showAndWait();
    }



}