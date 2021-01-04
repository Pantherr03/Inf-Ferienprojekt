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

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
/**
 * FXML Controller class
 *
 * @author Paul
 */
public class AddVermietungController implements Initializable {


    @FXML
    private ListView<String> lvFahrzeugAuswahl;
    @FXML
    private ListView<String> lvKundeAuswahl;
    @FXML
    private DatePicker dpStartDatum;
    @FXML
    private DatePicker dpEnddatum;
    @FXML
    private ChoiceBox<String> choiceZeitStart;
    @FXML
    private ChoiceBox<String> choiceZeitEnde;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillChoiceBox();
        // TODO
    }    
    
    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }


    private void fillChoiceBox(){
        choiceZeitStart.getItems().add("1:00");
        choiceZeitStart.getItems().add("2:00");
        choiceZeitStart.getItems().add("3:00");
        choiceZeitStart.getItems().add("4:00");
        choiceZeitStart.getItems().add("5:00");
        choiceZeitStart.getItems().add("6:00");
        choiceZeitStart.getItems().add("7:00");
        choiceZeitStart.getItems().add("8:00");
        choiceZeitStart.getItems().add("9:00");
        choiceZeitStart.getItems().add("10:00");
        choiceZeitStart.getItems().add("11:00");
        choiceZeitStart.getItems().add("12:00");
        choiceZeitStart.getItems().add("13:00");
        choiceZeitStart.getItems().add("14:00");
        choiceZeitStart.getItems().add("15:00");
        choiceZeitStart.getItems().add("16:00");
        choiceZeitStart.getItems().add("17:00");
        choiceZeitStart.getItems().add("18:00");
        choiceZeitStart.getItems().add("19:00");
        choiceZeitStart.getItems().add("20:00");
        choiceZeitStart.getItems().add("21:00");
        choiceZeitStart.getItems().add("22:00");
        choiceZeitStart.getItems().add("23:00");
        choiceZeitStart.getItems().add("24:00");
        
        choiceZeitEnde.getItems().add("1:00");
        choiceZeitEnde.getItems().add("2:00");
        choiceZeitEnde.getItems().add("3:00");
        choiceZeitEnde.getItems().add("4:00");
        choiceZeitEnde.getItems().add("5:00");
        choiceZeitEnde.getItems().add("6:00");
        choiceZeitEnde.getItems().add("7:00");
        choiceZeitEnde.getItems().add("8:00");
        choiceZeitEnde.getItems().add("9:00");
        choiceZeitEnde.getItems().add("10:00");
        choiceZeitEnde.getItems().add("11:00");
        choiceZeitEnde.getItems().add("12:00");
        choiceZeitEnde.getItems().add("13:00");
        choiceZeitEnde.getItems().add("14:00");
        choiceZeitEnde.getItems().add("15:00");
        choiceZeitEnde.getItems().add("16:00");
        choiceZeitEnde.getItems().add("17:00");
        choiceZeitEnde.getItems().add("18:00");
        choiceZeitEnde.getItems().add("19:00");
        choiceZeitEnde.getItems().add("20:00");
        choiceZeitEnde.getItems().add("21:00");
        choiceZeitEnde.getItems().add("22:00");
        choiceZeitEnde.getItems().add("23:00");
        choiceZeitEnde.getItems().add("24:00");
        
    }
    
    private void fillListView(){
        for(FahrzeugModel f : App.getFahrzeuge()){
            lvFahrzeugAuswahl.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
        }
        for(KundeModel k : App.getKunden()){
            if(k.getKundenTyp().equals("Geschäftskunde")){
                     
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                    lvKundeAuswahl.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());
            }
            else if(k.getKundenTyp().equals("Privatkunde")){
                     
                         PrivatKundeModel p = (PrivatKundeModel) k;
                         lvKundeAuswahl.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
            }
        }
    }
    
        
}
