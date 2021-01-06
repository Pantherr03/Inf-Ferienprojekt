package com.mycompany.infferienprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    //definiert die ArrayLists für Fahrzeuge, Kunden und Vermietungen
    static ArrayList<FahrzeugModel> fahrzeuge;
    static ArrayList<KundeModel> kunden;
    static ArrayList<VermietungModel> vermietungen;
    //definiert den String originTyp, der in allen Controllern außer mainController genutzt wird
    static String originTyp;
    //Definiert den ListViewModus für EditController wenn man von VermietungController kommt
    static String ListViewModus = "Vermietung";

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("mainView"), 800, 600);
        stage.setScene(scene);
        stage.show();
        newArrayLists();
        startObjects();
    }
    //initialisiert die drei ArrayLists
    private void newArrayLists(){
        fahrzeuge = new ArrayList<>();
        kunden = new ArrayList<>();
        vermietungen = new ArrayList<>();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        launch();
    }

    public void setFahrzeuge(ArrayList<FahrzeugModel> fahrzeuge) {
        this.fahrzeuge = fahrzeuge;
    }

    public void setKunden(ArrayList<KundeModel> kunden) {
        this.kunden = kunden;
    }
    
    public void setVermietungen(ArrayList<VermietungModel> vermietungen){
        this.vermietungen = vermietungen;
    }

    public static ArrayList<FahrzeugModel> getFahrzeuge() {
        return fahrzeuge;
    }

    public static ArrayList<KundeModel> getKunden() {
        return kunden;
    }
    
    public static ArrayList<VermietungModel> getVermietungen(){
        return vermietungen;
    }

    public static String getOriginTyp() {
        return originTyp;
    }

    public static void setOriginTyp(String originTyp) {
        App.originTyp = originTyp;
    }

    public static String getListViewModus() {
        return ListViewModus;
    }

    public static void setListViewModus(String ListViewModus) {
        App.ListViewModus = ListViewModus;
    }

    
    
    
    //setzt vier Objekte in die verschiedenen ArrayLists
    public static void startObjects(){
        LocalDateTime t1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime t2 = LocalDateTime.of(2021, Month.DECEMBER, 12, 14, 0);
        Duration duration = Duration.between(t1, t2);
        int Dauer = (int) duration.toHours();
        fahrzeuge.add(new AutoModel("VW", "Golf", "rot", "HH TP 265", "Auto", false, false, 15.0, 23));
        kunden.add(new GeschaeftsKundeModel("Diekmoorweg 34", "0174 6253671", "20.07.2003", "Ben", "Bartel", "Hamburg", "Geschäftskunde"));
        kunden.add(new PrivatKundeModel("110", "08.09.2003" , "Paul", "Kern", "Hamburg", "Privatkunde"));
        vermietungen.add(new VermietungModel(t1, t2, kunden.get(0), fahrzeuge.get(0), Dauer, Dauer * fahrzeuge.get(0).getStundenkosten() ));
    }
    
}