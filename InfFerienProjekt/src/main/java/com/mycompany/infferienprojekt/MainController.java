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
            for(FahrzeugModel f : App.getFahrzeuge()){
                 lvFahrzeuge.getItems().add(f.getTyp() + " " + f.getHersteller() + " " + f.getModell() + " " + f.getFarbe() + " " + f.getKennzeichen() + " " + f.getStundenkosten() + " " + f.getFahrzeugnummer() + " " + f.getInBenutzung() + " " + f.getInReparatur());
            }
        }
        else{
            System.out.println("es können noch keine Fahrzeuge abgebildet werden");
        }
        if(App.getKunden() != null){
            for(KundeModel k : App.getKunden()){
                lvKunden.getItems().add(k.getKundenTyp() + " " + k.getVorname() + " " + k.getNachname() + " " + k.getGeburtsdatum() + " " + k.getGeburtsort());
            }
        }
        else{
                System.out.println("es sind noch keine Kunden vorhanden");
        }
    
    }    
        
    
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
