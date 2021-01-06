/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;
/**
 * FXML Controller class
 *
 * @author Paul
 */
public class MainController implements Initializable {

    //definiert die drei ListViews und dass sie Strings enthalten
    @FXML
    private ListView<String> lvFahrzeuge;
    @FXML
    private ListView<String> lvKunden;
    @FXML
    private ListView<String> lvVermietungen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(App.getFahrzeuge() != null){
            //füllt die ListVIew lvFahrzeuge mit den Variablen der verschiedenen Objekte in der ArrayList fahrzeuge
            for(FahrzeugModel f : App.getFahrzeuge()){
                 lvFahrzeuge.getItems().add(f.getTyp() + " " + f.getHersteller() + " " + f.getModell() + " " + f.getFarbe() + " " + f.getKennzeichen() + " " + f.getStundenkosten() + " " + f.getFahrzeugnummer() + " " + f.getInBenutzung() + " " + f.getInReparatur());
            }
            //füllt die ListVIew lvKunden mit den Variablen der verschiedenen Objekte in der ArrayList kunden
            for(KundeModel k : App.getKunden()){
                lvKunden.getItems().add(k.getKundenTyp() + " " + k.getVorname() + " " + k.getNachname() + " " + k.getGeburtsdatum() + " " + k.getGeburtsort());
            }
            //füllt die ListVIew lvVermietungen mit den Variablen der verschiedenen Objekte in der ArrayList vermietungen
            for(VermietungModel v : App.getVermietungen()){
                String temp1 = v.getStartDatum().toString();
                String temp2 = v.getEndDatum().toString();
                lvVermietungen.getItems().add("Startdatum: " + temp1 + " // Enddatum: " + temp2 + " // Fahrzeugtyp: " + v.getFahrzeug().getTyp() + " // Modell: " + v.getFahrzeug().getModell() + " // Kunde: " + v.getKunde().getVorname()+ " " + v.getKunde().getNachname());
            }
        }
    } 
    
      
        
    //definiert die Buttons um in die verschiedenen Views zu gelangen
    @FXML
    private void btnToKundenDetail(ActionEvent event) throws IOException {
        App.setRoot("kundeView");
    }

    @FXML
    private void btnToFahrzeugDetail(ActionEvent event) throws IOException {
        App.setRoot("fahrzeugView");
    }

    @FXML
    private void btnToVermietungenDetail(ActionEvent event) throws IOException {
        App.setRoot("vermietungView");
    }

}
