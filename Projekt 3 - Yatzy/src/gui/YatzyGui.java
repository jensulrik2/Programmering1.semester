package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import model.YatzyDice;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button("Throw " + dice.getThrowCount());
    private int finalSumSame = 0;
    private int finalSumOther = 0;
    private int sumTotal = 0;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setEditable(false);
            txfValues[i].setPrefHeight(50);
            txfValues[i].setPrefWidth(50);
            dicePane.add(txfValues[i], i,0);

            cbxHolds[i] = new CheckBox("Hold");
            dicePane.add(cbxHolds[i], i,1);
        }
        // add lblThrowCount and btnThrow
        dicePane.add(btnThrow,3,2);
        btnThrow.setOnAction(event -> throwAction());

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 40; // width of the text fields

        // add labels for results
        // add txfResults,
        Label[] lblResultLabels = new Label[15];
        String[] resultLabelText = {"1's","2's","3's","4's","5's","6's","One Pair","Two Pair","Tree-same","Four-same","Full House","Small Str.","Large Str.","Chance","Yatzy"};

        for (int i = 0; i < lblResultLabels.length; i++) {
            lblResultLabels[i] = new Label(resultLabelText[i]);
            scorePane.add(lblResultLabels[i], 0,i);

            txfResults.add(new TextField());
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setPrefWidth(width);
            scorePane.add(txfResults.get(i),1,i);
            if (i <= 5) {
                txfResults.get(i).setOnMouseClicked(event -> this.resultSameClick(event));
            } else {
                txfResults.get(i).setOnMouseClicked(event -> this.resultOtherClick(event));
            }
        }
        // add labels and text fields for sums, bonus and total.
        Label lblSumSame = new Label("Sum");
        scorePane.add(lblSumSame,3,5);
        scorePane.add(txfSumSame,4,5);
        txfSumSame.setPrefWidth(width);
        txfSumSame.setEditable(false);

        Label lblBonus = new Label("Bonus");
        scorePane.add(lblBonus,5,5);
        scorePane.add(txfBonus,6,5);
        txfBonus.setPrefWidth(width);
        txfBonus.setEditable(false);

        Label lblSumOther = new Label("Sum");
        scorePane.add(lblSumOther,3,14);
        scorePane.add(txfSumOther,4,14);
        txfSumOther.setPrefWidth(width);
        txfSumOther.setEditable(false);

        Label lblTotal = new Label("TOTAL");
        scorePane.add(lblTotal,5,14);
        scorePane.add(txfTotal,6,14);
        txfTotal.setPrefWidth(width);
        txfTotal.setEditable(false);
    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    private void throwAction() {
        boolean[] checkboxHold = new boolean[5];
        for (int i = 0; i < checkboxHold.length; i++) {
            checkboxHold[i] = cbxHolds[i].isSelected();
            if (cbxHolds[i].isSelected() && dice.getThrowCount() != 1) {
                cbxHolds[i].setDisable(true);
            }
        }
        if (dice.getThrowCount() <= 3) {
            dice.throwDice(checkboxHold);
            setTxfValues();
            btnThrow.setText("Throw " + dice.getThrowCount());

            for (int i = 0; i < dice.getResults().length; i++) {
                if(!txfResults.get(i).isDisabled()) {
                    txfResults.get(i).setText(Integer.toString(dice.getResults()[i]));
                }
            }

            if (dice.getThrowCount() == 4) {
                btnThrow.setText("End");
            }
        }
    }

    private void setTxfValues() {
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(Integer.toString(dice.getValues()[i]));
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    private void resultSameClick(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (dice.getThrowCount() == 4 || dice.getThrowCount() != 1) {
            txf.setStyle("-fx-text-fill: red");
            txf.setDisable(true);
            txfSumSame.setText(Integer.toString(finalSumSame(txf.getText())));
            dice.setThrowCount(4);
            resetAll();

        }
    }
    private void resultOtherClick(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (dice.getThrowCount() == 4 || dice.getThrowCount() != 1) {
            txf.setStyle("-fx-text-fill: red");
            txf.setDisable(true);
            txfSumOther.setText(Integer.toString(finalSumOther(txf.getText())));
            dice.setThrowCount(4);
            resetAll();
        }
    }
    private int finalSumOther(String result) {
        finalSumOther += Integer.parseInt(result);
        return finalSumOther;
    }
    private int finalSumSame(String result) {
        finalSumSame += Integer.parseInt(result);
        return finalSumSame;
    }
    private boolean isBonus() {
        boolean isBonus = false;
        if (finalSumSame >= 63) {
            isBonus = true;
        }
        return isBonus;
    }
    private int sumTotal() {
        if (isBonus()) {
            sumTotal = finalSumSame + finalSumOther + 50;
        } else {
            sumTotal = finalSumSame + finalSumOther;
        }
        return sumTotal;
    }

    private void resetAll() {
        dice.resetThrowCount();
        for (int i = 0; i < cbxHolds.length; i++) {
            cbxHolds[i].setDisable(false);
            cbxHolds[i].setSelected(false);
            txfValues[i].setText("");
        }
        btnThrow.setText(("Throw " + dice.getThrowCount()));
        if (isBonus()) {
            txfBonus.setText("50");
        }
        txfTotal.setText(Integer.toString(sumTotal()));
    }


}
