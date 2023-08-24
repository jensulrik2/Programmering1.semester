package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;


public class KonferenceOversigtPane extends GridPane {
    private ListView<Konference> lvwKonferencer;

    private TextArea txaOversigt, txaHotel, txaDeltager, txaUdflugter;


    public KonferenceOversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //----------------------------------oprettet konferencer----------------------------------
        Label lblKonferencer = new Label("Oprettet Konferencer");
        this.add(lblKonferencer, 0, 0);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 0, 1, 1, 7);
        lvwKonferencer.setPrefWidth(380);
        lvwKonferencer.setPrefHeight(1000);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());

        //----------------------------------konference Oversigt----------------------------------
        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblKonferencerOversigt = new Label("Oversigt over valgt konference");
        this.add(lblKonferencerOversigt, 1, 0);

        txaOversigt = new TextArea();
        this.add(txaOversigt, 1, 1);
        txaOversigt.setPrefWidth(380);
        txaOversigt.setPrefHeight(300);
        txaOversigt.setEditable(false);

        //----------------------------------Deltager Oversigt----------------------------------
        Label lblDeltagerOversigt = new Label("Oversigt over deltagere");
        this.add(lblDeltagerOversigt, 1, 6);

        txaDeltager = new TextArea();
        this.add(txaDeltager, 1, 7);
        txaDeltager.setPrefWidth(380);
        txaDeltager.setPrefHeight(300);
        txaDeltager.setEditable(false);
    }

    private void selectedKonferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            StringBuilder sOversigt = new StringBuilder();
            StringBuilder sHotel = new StringBuilder();
            StringBuilder sDeltager = new StringBuilder();
            StringBuilder sUdflugt = new StringBuilder();
            sOversigt.append("Konference:\t" + konference.getNavn() + "\n \n \n"
                    + "Beskrivelse af konference:" + "\n" + konference.getBeskrivelse() + "\n \n \n"
                    + "Sted/Adresse:\t" + konference.getAdresse() + "\n \n \n" +
                    "Start Dato:\t \t" + konference.getStartDato() + "\n" + "Slut Dato:\t \t" + konference.getSlutDato() + "\n \n \n");


            sHotel.append(konference.getHoteller() + "\n \n \n");
            sUdflugt.append(konference.getUdflugter() + "\n \n \n");
            txaOversigt.setText(sOversigt.toString() + sHotel.toString() + sUdflugt.toString());


            for (int i = 0; i < konference.getTilmeldinger().size(); i++) {
                String ledsager = konference.getTilmeldinger().get(i).getLedsager() != null ? konference.getTilmeldinger().get(i).getLedsager().getNavn() : "";
                sDeltager.append(konference.getTilmeldinger().get(i).getDeltager().getNavn() +
                        "\t| \tLedsager:\t" + ledsager + "   Samlet Pris: Kr." + konference.getTilmeldinger().get(i).samletPris() + "\n \n");

            }

            txaDeltager.setText(sDeltager.toString());
        } else {
            txaOversigt.clear();
            txaHotel.clear();
            txaDeltager.clear();
        }
    }

//    // for (int i = 0; i < konference.getTilmeldinger().size(); i++) {
//        sHotel.append("Hoteller Tilknyttet: " + konference.getTilmeldinger().get(i).getHotel().getNavn());
//    }


}
