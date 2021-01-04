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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FahrzeugController implements Initializable {

    @FXML
    private ListView<String> lvFahrzeugDetail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(App.getFahrzeuge() != null){
            for(FahrzeugModel f : App.getFahrzeuge()){
                 lvFahrzeugDetail.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
            }
        }
        else{
            System.out.println("es können noch keine Fahrzeuge abgebildet werden");
        }
    }    

    @FXML
    private void selFahrzeugEdit(MouseEvent event) {
    }

    @FXML
    private void btnAddFahrzeug(ActionEvent event) throws IOException {
        App.setRoot("addFahrzeugView");
    }

    @FXML
    private void btnEditFahrzeug(ActionEvent event) throws IOException {
        App.setRoot("editFahrzegView");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
}
