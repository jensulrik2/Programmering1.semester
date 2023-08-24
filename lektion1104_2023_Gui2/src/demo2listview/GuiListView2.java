package demo2listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiListView2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo2");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfName2 = new TextField();
    private final TextField txfName3 = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();
    private final ArrayList<Person> persons = new ArrayList<Person>();
    private static int i = 0;

    private void initContent(GridPane pane) {
        this.initNames();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        // add a label to the pane (at col=0, row=1)
        Label lblName1 = new Label("Title:");
        pane.add(lblName1, 0, 1);

        CheckBox checkBox = new CheckBox();
        checkBox.setText("Senior");
        pane.add(checkBox, 1, 3);

        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                setSenior();
            } else {

            }
        });


        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 4);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 0);
        pane.add(txfName2, 1, 1);


        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwNames, 1, 4);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);
        lvwNames.getItems().setAll(this.initNames());

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        // add a button to the pane (at col=4, row=0)
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 4, 0);
       // btnAdd.setDefaultButton(true);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        // add a button to the pane (at col=4, row=1)
        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 4, 1);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.deleteAction());
    }

    // -------------------------------------------------------------------------

    private void addPerson() {
        Person person = new Person(txfName.getText(), txfName2.getText(), false);
        persons.add(person);
        i++;


    }

    private void setSenior(){
        persons.get(i).setSenior(true);
    }

    private ArrayList<String> initNames() {


        return names;
    }



    // -------------------------------------------------------------------------
    // Selection changed actions

    private void selectionChanged() {
        String selected = lvwNames.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            names.add(name);
            lvwNames.getItems().setAll(names);
        }
    }

    private void deleteAction() {
        int index = lvwNames.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            names.remove(index);
            txfName.clear();
            lvwNames.getItems().setAll(names);
        }
    }

    @Override
    public String toString() {
        String s = persons.get(i).getTitle() + " " + persons.get(i).getName();
        if (persons.get(i).isSenior()){
            s += " (senior)";
        }
        return s;
    }



}
