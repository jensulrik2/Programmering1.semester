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
		// Replace the statement here with your code.
//
//		int a = 50;
//		int b = -20;
//
//		int x = 100;
//		int y = 75;
//		gc.strokeLine(x, y, x + a, y - b);
//		gc.strokeLine(x, y, x + a, y + b);
//		// draw an arrowhead at (25,140)
//		x = 100;
//		y = 125;
//		gc.strokeLine(x, y, x + a, y - b);
//		gc.strokeLine(x, y, x + a, y + b);
//
//		x = 20;
//		y = 50;
//		gc.strokeLine(x, y, x + a, y - b);
//		gc.strokeLine(x, y, x + a, y + b);
//
//
//		int x1 = 100; // start point: (x1,y1)
//		int y1 = 100;
//		int x2 = 0; // end point: (x2,y2)
//		int y2 = 190;
//		int a1 = 100; // start point: (x1,y1)
//		int b1 = 100;
//		int a2 = 180; // end point: (x2,y2)
//		int b2 = 10;
//		while (x2 <= 180) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x2 = x2 + 40;
//			gc.strokeLine(a1, b1, a2, b2);
//			a2 = a2 - 40;
//		}
//
//		example 4
//		f1 lige linjer fra bund til top
//
//		int x1 = 100; // start point: (x1,y1)
//		int y1 = 0;
//		int x2 = 100; // end point: (x2,y2)
//		int y2 = 250;
//		while (x2 <= 260) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x2 = x2 + 40;
//			x1 = x1 + 40;
//		}
//		f2 vandrette linjer
//
//		int x1 = 0; // start point: (x1,y1)
//		int y1 = 50;
//		int x2 = 300; // end point: (x2,y2)
//		int y2 = 50;
//		while (y2 <= 260) {
//			gc.strokeLine(x1, y1, x2, y2);
//			y2 = y2 + 40;
//			y1 = y1 + 40;
//		}
//
//
//		int x1 = 0; // start point: (x1,y1)
//		int y1 = 100;
//		int x2 = 260; // end point: (x2,y2)
//		int y2 = 100;
//		while (x1 <= 260) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x2 = x2 - 40;
//			x1 = x1 + 40;
//			y1 = y1 + 40;
//			y2 = y2 + 40;
//		}
//		ex6
//
//
//		int x = 50; // start point: (x1,y1)
//		int y = 100;
//		int r = 40; // end point: (x2,y2)
//		while(x <= 150) {
//			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			x += 25;
//		}
//		Exercise 4
//
//		int x = 20; // start point: (x1,y1)
//		int y = 100;
//		int r = 10; // end point: (x2,y2)
//		while(x <= 90) {
//			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			x += 5;
//			r += 5;
//		}
//
//
//		int x = 100; // start point: (x1,y1)
//		int y = 100;
//		int r = 20; // end point: (x2,y2)
//		while(r <= 100) {
//			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//
//			r += 20;
//		}
//
//
//
//		int x = 100; // start point: (x1,y1)
//		int y = 100;
//		int r = 10; // end point: (x2,y2)
//		while(r <= 100) {
//			gc.strokeOval(x - r , y  , r + x, 160);
//			r += 10;
//			x += 5;
//		}
//
//		Exercise 5
//
//		String s = "Datamatiker";
//
//		double x = 20;
//		double y = 50;
//		int i = 0;
//		while(i <= s.length()) {
//			gc.fillText((s.substring(0,i)), 20, y);
//			y += 20;
//			i++;
//		}
//
//		Exercise 6a
//
//		int x1 = 10;
//		int x2 = 240;
//		int y1 = 270;
//
//		//Straight Line
//		gc.strokeLine(x1, y1, x2, y1);
//
//		//arrow
//		gc.strokeLine(x2,y1,x2 - 10, y1 + 4);
//		gc.strokeLine(x2,y1,x2 - 10, y1 - 4);
//
//		//small ones
//		int y2 = y1 - 10;
//		int y3 = y1 + 10;
//		for (int i = 1; i < 12; i++){
//			int x3 = 20 * i;
//			gc.strokeLine(x3, y2, x3, y3);
//		}
//
//		6c
//
//		int x1 = 10;
//		int x2 = 240;
//		int y1 = 270;
//
//		//Straight Line
//		gc.strokeLine(x1, y1, x2, y1);
//
//		//arrow
//		gc.strokeLine(x2,y1,x2 - 10, y1 + 4);
//		gc.strokeLine(x2,y1,x2 - 10, y1 - 4);
//
//		//small ones
//		String s = "";
//		int y3 = y1 - 5;
//		int y4 = y1 + 5;
//		for (int i = 1; i < 12; i++){
//			int x3 = 20 * i;
//			if ( i == 1 || i == 6 || i == 11) {
//				//double så store linjer
//				gc.strokeLine(x3, y3 - 5, x3, y4 + 5);
//				//tal under linjer					 - 30 = over linjen i stedet
//				gc.fillText("" + (i - 1), x3 - 3, y3 + 30);
//				//små linjer
//			}
//			else {
//				gc.strokeLine(x3, y3, x3, y4);
//			}
//		}
//
//
//	    EXercise 8
//
//		f1 lige linjer fra bund til top
//
//
//
//		int x1 = 20; // start point: (x1,y1)
//		int y1 = 50;
//		int x2 = 20; // end point: (x2,y2)
//		int y2 = 160;
//		while (x2 <= 200) {
//			gc.strokeLine(x1, y1, x2, y2);
//			x2 = x2 + 20;
//			x1 = x1 + 20;
//			y1 = y1 + -3;
//			y2 = y2 + -15;
//		}
//		  Exercise 9
//
//
//		double x = 180; // start point: (x1,y1)
//		double y1 = 90;
//		double x2 = 180; // end point: (x2,y2)
//		while (x > 5) {
//			double y2 = y1 -x * 0.2;
//			double y3 = y1 + x * 0.5;
//			x = x - x * 0.25;
//			gc.strokeLine(x, y1, x, y3);
//			gc.strokeLine(x,y1,x,y2);
//			x = x - x * 0.25;
//		}
//
//
//		 Exercise 10
//
//
//		int x = 50;
//		while (x <= 150) {
//			this.drawCircle(gc, x, 100, 40);
//			x = x + 25;
//		}
//
//		Exercise 11
//
//
//		this.drawCross(gc, 150,150,80);
//
//
//
//		this.drawTriangle(gc, 100, 100, 81);
//		this.drawInnerTriangles(gc, 100, 100, 81);
//		this.drawInnerTriangles(gc, 100, 100, 81*0.33);
//		this.drawInnerTriangles(gc, 100 + (2 * 81) - (81*0.33)*2 , 100, 81*0.33);
//		this.drawInnerTriangles(gc, 100 + 81 - (81*0.33),  100 - 81 + 81*0.33, 81*0.33);
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