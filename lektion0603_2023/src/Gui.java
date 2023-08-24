import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(300, 300);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {

	}

	private void drawCircle(GraphicsContext gc, int x, int y, int r) {
		//Exercise 10

		gc.strokeOval(x - r, y - r, 2 * r, 2 * r);

	}

	private void drawCross(GraphicsContext gc, int x, int y, int w) {
		//Exercise 11

		gc.strokeLine(x + w, y, x - w, y);
		gc.strokeLine(x, y + w, x, y - w);

	}

	private void drawTriangle(GraphicsContext gc, double x, double y, double h) {
		//Exercise 12

		gc.strokeLine(x, y, x + (2 * h), y);
		gc.strokeLine(x, y, x + h, y - h);
		gc.strokeLine(x + h, y - h, x + (2 * h), y);

	}

	private void drawInnerTriangles(GraphicsContext gc, double x, double y, double h){

		this.drawTriangle(gc, x , y, h * 0.33);
		this.drawTriangle(gc, x + (2 * h) - (2 * h * 0.33), y , h * 0.33 );
		this.drawTriangle(gc, x + h - h * 0.33, y - h + h * 0.33, h * 0.33);



	}


}