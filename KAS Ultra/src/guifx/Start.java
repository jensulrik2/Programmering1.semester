package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Start extends Application {




    @Override
    public void start(Stage stage) throws FileNotFoundException {

        BorderPane pane = new BorderPane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 800,600);
        stage.setScene(scene);
        stage.show();
    }
    private void initContent(BorderPane pane) throws FileNotFoundException {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) throws FileNotFoundException {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabForside = new Tab("Forside");
        tabPane.getTabs().add(tabForside);

        ForsidePane forsidePane = new ForsidePane();
        tabForside.setContent(forsidePane);
        //tabForside.setOnSelectionChanged(event -> ForsidePane.updateControls());

        Tab tabTilmelding = new Tab("Tilmelding");
        tabPane.getTabs().add(tabTilmelding);

        TilmeldingPane tilmeldingPane = new TilmeldingPane();
        tabTilmelding.setContent(tilmeldingPane);
        //tabForside.setOnSelectionChanged(event -> ForsidePane.updateControls());


        Tab tabKonferenceOversigt = new Tab("Konference Oversigt");
        tabPane.getTabs().add(tabKonferenceOversigt);

        KonferenceOversigtPane konferenceOversigtPane = new KonferenceOversigtPane();
        tabKonferenceOversigt.setContent(konferenceOversigtPane);
        //tabForside.setOnSelectionChanged(event -> ForsidePane.updateControls());

        Tab tabHotelOversigt = new Tab("Hotel Oversigt");
        tabPane.getTabs().add(tabHotelOversigt);

        HotelOversigtPane hotelOversigtPane = new HotelOversigtPane();
        tabHotelOversigt.setContent(hotelOversigtPane);

        Tab tabUdflugtOversigt = new Tab("Udflugt Oversigt");
        tabPane.getTabs().add(tabUdflugtOversigt);

        UdflugtOversigtPane udflugtOversigtPane = new UdflugtOversigtPane();
        tabUdflugtOversigt.setContent(udflugtOversigtPane);

    }



    //TODO Lave en metode til at oprette Forstilling

    //TODO Lave en metode til at oprette Kunde

    //TODO Lave en metode til at oprette Bestilling

}
