package opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("opgave5.Gui Demo 1");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private final TextArea txaDescription = new TextArea();
	private final TextField txfName = new TextField();
	private String list = "";

	private void initContent(GridPane pane) {
		// enable this to show grid lines
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
		// add a text field to the pane
		// (at col=1, row=0, extending 2 cols and 1 row)
		pane.add(txfName, 0, 1);
		// add a button to the pane (at col=1, row=1)
		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 0, 2);
		GridPane.setMargin(btnAdd, new Insets(10, 10, 0, 110));
		btnAdd.setOnAction(event -> this.addName());

		pane.add(txaDescription, 0, 3);
		txaDescription.setPrefRowCount(7);
		txaDescription.setPrefWidth(270);
		txaDescription.setEditable(false);




	}



	// ------------------------------------------------------------------------

	private void addName() {
		txaDescription.setText(this.namesList());
	}

	private String namesList() {

		this.list += txfName.getText() + "\n";

		return list;
	}




}