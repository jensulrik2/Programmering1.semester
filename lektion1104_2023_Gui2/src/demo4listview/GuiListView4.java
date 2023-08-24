package demo4listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiListView4 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final Button btnAdd = new Button("Add");
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private boolean isSenior;

    private void initContent(GridPane pane) {
        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

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
                isSenior = true;
            } else {
                isSenior = false;
            }
        });

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 4);
        GridPane.setValignment(lblNames, VPos.TOP);

        // add a text field to the pane (at col=1, row=0)
        pane.add(txfName, 1, 0);
        pane.add(txfTitle, 1, 1);


        pane.add(lvwPersons, 1, 4);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, o, n) -> this.personsItemSelected();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);


        pane.add(btnAdd, 4, 0);
        btnAdd.setOnAction(event -> this.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 4, 1);
        btnDelete.setOnAction(event -> this.deleteAction());
    }

    // -------------------------------------------------------------------------

    private void initPersons() {

    }

    // -------------------------------------------------------------------------
    // Selected item changed in lvwPersons

    private void personsItemSelected() {
        Person selected = lvwPersons.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txfName.setText(selected.toString());
        } else {
            txfName.clear();
        }
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        if (name.length() > 0 && title.length() > 0) {
            Person p = new Person(name,title,isSenior);
            persons.add(p);
            lvwPersons.getItems().setAll(persons);
        }
        else if(title.length() == 0 && name.length() == 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("Nothing typed");
            alert.setContentText("Pls type a name and a title of a person");
            alert.show();
            // wait for the modal dialog to close
        }
        else if(name.length() == 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("No name typed");
            alert.setContentText("Type the name of the person idiot");
            alert.show();
            // wait for the modal dialog to close
        }
        else if(title.length() == 0 ){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("No title typed");
            alert.setContentText("Type the title of the person");
            alert.show();
            // wait for the modal dialog to close
        }


    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(persons);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Delete person");
            alert.setHeaderText("No person selected");
            alert.setContentText("Select a person to be deleted");
            alert.show();

            // wait for the modal dialog to close
        }
    }


}
