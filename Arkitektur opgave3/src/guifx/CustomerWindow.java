package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class CustomerWindow extends Stage {
        private Customer customer;

        public CustomerWindow(String title, Company company) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);

            this.customer = customer;

            this.setTitle(title);
            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }

        public CustomerWindow(String title) {
            this(title, null);
        }

        // -------------------------------------------------------------------------

        private TextField txfName;
        private Label lblError;

        private ComboBox<Company> cbbCompany;

        private void initContent(GridPane pane) {
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);
            pane.setGridLinesVisible(false);

            Label lblName = new Label("Full Name");
            pane.add(lblName, 0, 0);

            txfName = new TextField();
            pane.add(txfName, 0, 1);
            txfName.setPrefWidth(200);

            Label lblCompany = new Label("Company");
            pane.add(lblCompany, 0, 2);

            cbbCompany = new ComboBox<>();
            pane.add(cbbCompany, 0, 3);
            cbbCompany.getItems().addAll(Controller.getCompanies());
            cbbCompany.setDisable(false);


            Button btnCancel = new Button("Cancel");
            pane.add(btnCancel, 0, 4);
            GridPane.setHalignment(btnCancel, HPos.LEFT);
            btnCancel.setOnAction(event -> this.cancelAction());

            Button btnOK = new Button("OK");
            pane.add(btnOK, 0, 4);
            GridPane.setHalignment(btnOK, HPos.RIGHT);
            btnOK.setOnAction(event -> this.okAction());

            lblError = new Label();
            pane.add(lblError, 0, 5);
            lblError.setStyle("-fx-text-fill: red");

            this.initControls();
        }

        private void initControls() {
            if (customer != null) {
                txfName.setText(customer.getName());
            } else {
                txfName.clear();
            }
        }

        // -------------------------------------------------------------------------

        private void cancelAction() {
            this.hide();
        }

        private void okAction() {
            String name = txfName.getText().trim();

            if (name.length() == 0 || cbbCompany.getSelectionModel().getSelectedItem()==null) {
                lblError.setText("Name or Company is emty");
            } else {
                Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();
                if (customer != null) {
                    Controller.updateCustomer(customer, name, newCompany);
                        Controller.addCustomerToCompany(customer, newCompany);
                } else {
                        Controller.createCustomer(name , newCompany);
                }
                hide();
            }
        }
}




