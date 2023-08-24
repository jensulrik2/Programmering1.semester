package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Service;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HotelOversigtPane extends GridPane {

    private ListView<Hotel> lvwHoteller;
    private TextArea txaServices, txaDeltager;
    private TextField txfAntal;
    public HotelOversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Oprettet hoteller");
        this.add(lblKonferencer,0,0);

        lvwHoteller = new ListView<>();
        this.add(lvwHoteller,0,1,1,4);
        lvwHoteller.setPrefWidth(380);
        lvwHoteller.setPrefHeight(1000);
        lvwHoteller.getItems().setAll(Controller.getHoteller());

        ChangeListener<Hotel> listener = (ov, oldCompny, newCompany) -> this.selectedKonferenceChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblService = new Label("Priser på de forskellige service");
        this.add(lblService,2,0);

        txaServices = new TextArea();
        this.add(txaServices,2,1,3,1);
        txaServices.setPrefWidth(300);
        txaServices.setPrefHeight(100);
        txaServices.setEditable(false);

        Label lblDeltager = new Label("Deltager og ledsager på hotellet");
        this.add(lblDeltager,2,2);

        Label lblDeltagerAntal = new Label("Antal i alt:");
        this.add(lblDeltagerAntal,3,2);

        txfAntal = new TextField();
        this.add(txfAntal,4,2);
        txfAntal.setPrefWidth(50);

        txaDeltager = new TextArea();
        this.add(txaDeltager,2,3,3,1);
        txaDeltager.setPrefWidth(300);
        txaDeltager.setPrefHeight(400);
        txaDeltager.setEditable(false);
    }

    private void selectedKonferenceChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        int count = 0;
        if (hotel != null) {
            StringBuilder sService = new StringBuilder();
            StringBuilder sDeltager = new StringBuilder();
            for (Service service : hotel.getServices()){
                sService.append(String.format("%-25s\t %.2fkr.\n",service.getNavn(),service.getPris()));
            }
            txaServices.setText(sService.toString());
            for (Tilmelding tilmelding : hotel.getTilmeldinger()) {
                String ledsager = tilmelding.getLedsager() != null ? tilmelding.getLedsager().getNavn() : "";
                sDeltager.append(String.format("%-10s\t Med ledsager: %s", tilmelding.getDeltager().getNavn(),ledsager + "\n"));
                if (!tilmelding.getDeltager().getLedsagere().isEmpty()) {
                    count += 2;
                } else {
                    count++;
                }
            }
            txaDeltager.setText(sDeltager.toString());
            txfAntal.setText(String.valueOf(count));
        } else {
            txaServices.clear();
            txaDeltager.clear();
            txfAntal.clear();
        }
    }

}
