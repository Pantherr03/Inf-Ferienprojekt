package com.mycompany.infferienprojekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static ArrayList<FahrzeugModel> fahrzeuge;
    static ArrayList<KundeModel> kunden;
    static ArrayList<VermietungModel> vermietungen;
    static String originTyp;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("mainView"), 800, 600);
        stage.setScene(scene);
        stage.show();
        newArrayLists();
        startObjects();
    }
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
    
    
    public static void startObjects(){
        fahrzeuge.add(new AutoModel("VW", "Golf", "rot", "HH TP 265", "Auto", false, false, 15.0, 23));
        kunden.add(new GeschaeftsKundeModel("Diekmoorweg 34", "20.07.2003","0174 6253671", "Ben", "Bartel", "Hamburg", "Geschäftskunde"));
        kunden.add(new PrivatKundeModel("110", "0174 6234671", "Peer", "Bartel", "Hamburg", "Privatkunde"));
    }
    
}