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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class KundeController implements Initializable {
    
    @FXML
     private ListView<String> lvKundeDetail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(App.getKunden() != null){
             for(KundeModel k : App.getKunden()){
                 if(k.getKundenTyp().equals("Geschäftskunde")){
                     
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                    lvKundeDetail.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());
                     }
                 else if(k.getKundenTyp().equals("Privatkunde")){
                     
                         PrivatKundeModel p = (PrivatKundeModel) k;
                         lvKundeDetail.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
                     }
                 }
             
         }
        
        else{
            System.out.println("es können noch keine Fahrzeuge abgebildet werden");
        } 
    }    

    @FXML
    private void btnAddKunde(ActionEvent event) throws IOException {
        App.setRoot("addKundeView");
    }

    @FXML
    private void btnEditKunde(ActionEvent event) {
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
}
