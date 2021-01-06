package com.mycompany.infferienprojekt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FahrzeugController implements Initializable {

    //definiert die ListVIew lvFahrzeugdetail
    @FXML
    private ListView<String> lvFahrzeugDetail;
    //definiert die Variable selectedFahrzeug, die in btnEditFahrzeug genutzt wird und in EditController aufgerufen wird
    static FahrzeugModel selectedFahrzeug;
    @FXML
    //definiert den button EditFahrzeug, sodass man einstellen kann, wann er nutzbar wird (selFahrzeugEdit)
    private Button EditFahrzeug;
    //definiert den int selFahrzeugIndex, um leichter aus anderen Klassen auf den Index des "selectedFahrzeug" zugreifen zu können
    static int selFahrzeugIndex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setzt den EditFahrzeug button auf nicht nutzbar, da kein Objekt ausgewählt ist
        EditFahrzeug.setDisable(true);
        //füllt die ListVIew mit den Werten der Objekte in der ArrayList fahrzeuge in App
        for(FahrzeugModel f : App.getFahrzeuge()){
             lvFahrzeugDetail.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
        }
    }    

    //setzt den EditFahrzeug button auf nutzbar, wenn auf die ListView geclickt wird
    @FXML
    private void selFahrzeugEdit(MouseEvent event) {
        EditFahrzeug.setDisable(false);
        
    }
    
    //definiert die buttons um in die verschiedenen Views zu gelangen
    @FXML
    private void btnAddFahrzeug(ActionEvent event) throws IOException {
        App.setRoot("addFahrzeugView");
    }

    @FXML
    private void btnEditFahrzeug(ActionEvent event) throws IOException {
        //setzt selFahrzeugIndex auf den Index des in der ListVIew ausgewählten Objektes
        selFahrzeugIndex = lvFahrzeugDetail.getSelectionModel().getSelectedIndex();
        //holt sich das "selectedFahrzeug" aus der ArrayList fahrzeuge
        selectedFahrzeug = App.fahrzeuge.get(selFahrzeugIndex);
        //setzt die Origin auf Fahrzeug, um in EditController zu wissen, dass man davor in FahrzeugController war und deswegen selectedFahrzeug aufrufen muss
        App.setOriginTyp("Fahrzeug");
        App.setRoot("editView");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
}
