package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;


import javax.lang.model.type.NullType;
import java.time.LocalDate;
import java.util.ArrayList;


public class TilmeldingPane extends GridPane {

    private ListView<Konference> lvwKonferencer;
    private ListView<Hotel> lvwHoteller;
    private ListView<Service> lvwServices;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<LocalDate> lvwAnkomst;
    private ListView<LocalDate> lvwAfrejse;
    private TextField txfLedsager;
    private Label lblUdflugter;
    private CheckBox cbLedsager;
    private CheckBox cbForedragsholder;
    private Button btnTilmelding;
    private ComboBox<Deltager> cbxDeltager;

    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        //lbls
        Label lblKonferencer = new Label("Valg af Konference");
        this.add(lblKonferencer,0,0,3,1);

        Label lblHotel = new Label("Valg af Hotel");
        this.add(lblHotel, 3,0);

        Label lblServices = new Label("Valg af Services");
        this.add(lblServices,4,0);

        Label lblNavn = new Label("Deltager");
        this.add(lblNavn,0,2);
        Label lblAnkomst = new Label("Ankomst");
        this.add(lblAnkomst,0,3);
        Label lblAfrejse = new Label("Afrejse");
        this.add(lblAfrejse,0,4);
        Label lblForedragsHolder = new Label("Foredragsholder");
        this.add(lblForedragsHolder,0,5);
        //txt

        //ListViews
        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer,0,1,3,1);
        lvwKonferencer.setPrefWidth(250);
        lvwKonferencer.setPrefHeight(200);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwHoteller = new ListView<>();
        lvwHoteller.setPrefWidth(200);
        lvwHoteller.setPrefHeight(200);
        this.add(lvwHoteller, 3,1);
        ChangeListener<Hotel> listener2 = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener2);

        lvwServices = new ListView<>();
        lvwServices.setPrefWidth(200);
        lvwServices.setPrefHeight(200);
        this.add(lvwServices, 4,1);
        lvwServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        cbxDeltager = new ComboBox<>();
        this.add(cbxDeltager,1,2);
        cbxDeltager.getItems().setAll(Controller.getDeltagere());
//        lvwDeltagere = new ListView<>();
//        this.add(lvwDeltagere,1,4);
//        lvwDeltagere.setPrefWidth(150);
//        lvwDeltagere.setMaxWidth(150);
//        lvwDeltagere.setPrefHeight(40);
//        lvwDeltagere.getItems().setAll(Controller.getDeltagere());

        lvwAnkomst = new ListView<>();
        this.add(lvwAnkomst,1,3,2,1);
        lvwAnkomst.setMaxWidth(100);
        lvwAnkomst.setPrefWidth(100);
        lvwAnkomst.setPrefHeight(40);

        lvwAfrejse = new ListView<>();
        this.add(lvwAfrejse,1,4,2,1);
        lvwAfrejse.setMaxWidth(100);
        lvwAfrejse.setPrefWidth(100);
        lvwAfrejse.setPrefHeight(40);

        cbLedsager = new CheckBox();
        cbLedsager.setText("Ledsager");
        Label lblLedsager = new Label("Ledsager Navn");
        this.add(lblLedsager,3,3);
        this.add(cbLedsager,3,2);
        txfLedsager = new TextField();
        txfLedsager.setPrefWidth(130);
        txfLedsager.setMaxWidth(130);
        this.add(txfLedsager,3,4);
        txfLedsager.setEditable(false);


        cbLedsager.setOnAction(event -> {
            if (cbLedsager.isSelected()) {
                txfLedsager.setEditable(true);
                lvwUdflugter.setVisible(true);
                lblUdflugter.setVisible(true);


            } else {
                txfLedsager.clear();
                txfLedsager.setEditable(false);
                lvwUdflugter.setVisible(false);
                lblUdflugter.setVisible(false);

            }
        });

        cbForedragsholder = new CheckBox();
        this.add(cbForedragsholder,1,5);

        lblUdflugter = new Label("Udflugter");
        this.add(lblUdflugter,4,2);

        lvwUdflugter = new ListView<>();
        lvwUdflugter.setPrefWidth(300);
        lvwUdflugter.setPrefHeight(100);
        this.add(lvwUdflugter,4,3,1,2);
        lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwUdflugter.setVisible(false);
        lblUdflugter.setVisible(false);

        btnTilmelding = new Button();
        btnTilmelding.setText("Opret Tilmelding");
        this.add(btnTilmelding,4,5);
//        btnTilmelding.setMaxHeight(100);
//        btnTilmelding.setPrefHeight(100);
//        btnTilmelding.setMaxWidth(150);
//        btnTilmelding.setPrefWidth(150);
        btnTilmelding.setOnAction(event -> tilmeldingAction());


    }


    private void selectedKonferenceChanged() {
        this.updateControls();
    }

    private void selectedHotelChanged() {
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        if(hotel != null){
            lvwServices.getItems().setAll(hotel.getServices());
        }
    }
    public void updateControls() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if(konference != null){
            lvwUdflugter.getItems().setAll(konference.getUdflugter());
            lvwHoteller.getItems().setAll(konference.getHoteller());
            lvwAnkomst.getItems().setAll(konference.getDatoer());
            lvwAfrejse.getItems().setAll(konference.getDatoer());

        }
    }

    public void tilmeldingAction(){
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        Deltager deltager = cbxDeltager.getSelectionModel().getSelectedItem();
        LocalDate ankomst = lvwAnkomst.getSelectionModel().getSelectedItem();
        LocalDate afrejse = lvwAfrejse.getSelectionModel().getSelectedItem();
        boolean foredragsholder = false;
        if(cbForedragsholder.isSelected()){
            foredragsholder = true;
        }

        Tilmelding tilmelding = Controller.createTilmelding(deltager,ankomst,afrejse,foredragsholder,konference);
        if(cbLedsager.isSelected() && txfLedsager != null){
            Ledsager ledsager = deltager.createLedsager(txfLedsager.getText(),"","");
            tilmelding.setLedsager(ledsager);
            ArrayList<Udflugt> udflugter = new ArrayList<>(lvwUdflugter.getSelectionModel().getSelectedItems());
            for(Udflugt u : udflugter){
                tilmelding.addUdflugt(u);
            }
        }
        if(!lvwHoteller.getSelectionModel().isEmpty()){
            tilmelding.setHotel(lvwHoteller.getSelectionModel().getSelectedItem());
            if(!lvwServices.getSelectionModel().isEmpty()){
                ArrayList<Service> services = new ArrayList<>(lvwServices.getSelectionModel().getSelectedItems());
                for(Service s : services) {
                    tilmelding.addService(s);
                }
            }
        }
        txfLedsager.clear();
        lvwKonferencer.getSelectionModel().clearSelection();
        lvwHoteller.getItems().setAll();
        lvwServices.getItems().setAll();
        cbxDeltager.getSelectionModel().clearSelection();
        lvwAnkomst.getItems().setAll();
        lvwAfrejse.getItems().setAll();
        lvwUdflugter.setVisible(false);
        cbForedragsholder.setSelected(false);
        cbLedsager.setSelected(false);



    }


}
