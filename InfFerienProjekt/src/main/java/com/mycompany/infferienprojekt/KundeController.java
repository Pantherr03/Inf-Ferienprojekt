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
public class KundeController implements Initializable {

    //definiert die ListView lvKundeDetail
    @FXML
    private ListView<String> lvKundeDetail;
    //definiert die Variable selectedKunde, die in btnEditKunde genutzt wird und in EditController aufgerufen wird
    static KundeModel selectedKunde;
    //definiert den int selKundeIndex, um leichter aus anderen Klassen auf den Index des "selectedKunde" zugreifen zu können
    static  int selKundeIndex;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //füllt die ListView lvKundeDetail mit allen Objekten aus der ArrayList kunden
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
    
    @FXML
    private void btnAddKunde(ActionEvent event) throws IOException {
        App.setRoot("addKundeView");
    }

    @FXML
    private void btnEditKunde(ActionEvent event) throws IOException {
        int temp1 = lvKundeDetail.getSelectionModel().getSelectedIndex();
        selectedKunde = App.kunden.get(temp1);
        
        if(selectedKunde.getKundenTyp().equals("Geschäftskunde")){
            int temp2 = lvKundeDetail.getSelectionModel().getSelectedIndex();
            selectedKunde = App.kunden.get(temp2);
            selKundeIndex = temp2;
            App.setOriginTyp("GeschaeftsKunde");
        }
        else if(selectedKunde.getKundenTyp().equals("Privatkunde")){
            int temp2 = lvKundeDetail.getSelectionModel().getSelectedIndex();
            selectedKunde = App.kunden.get(temp2);
            selKundeIndex = temp2;
            App.setOriginTyp("PrivatKunde");
         }
        App.setRoot("editView");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainVIew");
    }

}
