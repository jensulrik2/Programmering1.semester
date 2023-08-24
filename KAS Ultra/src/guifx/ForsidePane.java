package guifx;

import application.controller.Controller;
import application.model.Tilmelding;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ForsidePane extends GridPane {

    private ImageView backgroundImg;
    private TextField txtSamletPris;


    public ForsidePane() throws FileNotFoundException {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        BackgroundImage myBI= new BackgroundImage(new Image("guifx\\baggrund.png",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//then you set to your node
        this.setBackground(new Background(myBI));



        Label lblComp = new Label("KAS");
        lblComp.setMinWidth(Region.USE_PREF_SIZE);
        lblComp.setMinHeight(Region.USE_PREF_SIZE);
        this.add(lblComp, 0, 0,10,10);
        lblComp.setTextFill(Color.WHITE);
        lblComp.setStyle("-fx-font: 48 arial;");



    }



}

