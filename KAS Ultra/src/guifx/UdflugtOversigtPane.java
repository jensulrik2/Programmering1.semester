package guifx;

import application.controller.Controller;
import application.model.Konference;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class UdflugtOversigtPane extends GridPane {

    private ListView<Konference> lvwKonferencer;
    private ListView<Udflugt> lvwUdflugter;
    private TextArea txaDeltager;

    public UdflugtOversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonferencer = new Label("Vælg Konference");
        this.add(lblKonferencer, 0, 0);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 0, 1);
        lvwKonferencer.setPrefWidth(380);
        lvwKonferencer.setPrefHeight(500);
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());

        ChangeListener<Konference> listener = (ov, oldCompny, newCompany) -> this.selectedKonferenceChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblUdflugter = new Label("Vælg Udflugt");
        this.add(lblUdflugter, 0, 2);

        lvwUdflugter = new ListView<>();
        this.add(lvwUdflugter, 0, 3);
        lvwUdflugter.setPrefWidth(380);
        lvwUdflugter.setPrefHeight(500);

        ChangeListener<Udflugt> listener1 = (ov, oldCompny, newCompany) -> this.selectedUdflugtChanged();
        lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener1);

        txaDeltager = new TextArea();
        this.add(txaDeltager,1,1,1,3);
//        txaDeltager.setEditable(false);
    }

    private void selectedKonferenceChanged() {
        this.updateControlsKonference();
    }

    private void selectedUdflugtChanged() {
        this.updateControlsUdflugt();
    }

    public void updateControlsKonference() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            lvwUdflugter.getItems().setAll(Controller.getUdflugter(konference));
        }
    }

    public void updateControlsUdflugt() {
        txaDeltager.setText("Hej");
        Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
        if(udflugt != null){
            StringBuilder sDeltager = new StringBuilder();
            System.out.println(udflugt.getTilmeldinger());
            for (Tilmelding tilmelding : udflugt.getTilmeldinger()) {
                sDeltager.append(String.format("%s  (%s) \n", tilmelding.getLedsager().getNavn(),tilmelding.getLedsager().getDeltager().getNavn()));

            }
            txaDeltager.setText(sDeltager.toString());
        }
        else{
            txaDeltager.clear();
        }
    }
}

