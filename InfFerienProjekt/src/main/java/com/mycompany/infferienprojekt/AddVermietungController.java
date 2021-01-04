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
import javafx.scene.input.MouseEvent;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.util.converter.LocalDateTimeStringConverter;
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
    private DatePicker dpEndDatum;
    @FXML
    private ChoiceBox<String> choiceZeitStart;
    @FXML
    private ChoiceBox<String> choiceZeitEnde;
    
    LocalTime TS = null;
    LocalTime TE = null;
    
    FahrzeugModel selFahrzeug = null;
    KundeModel selKunde = null;
    
    @FXML
    private DatePicker dpEnddatum;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillChoiceBox();
        fillListView();
        
        // TODO
    }    
    
    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        choiceToDateStart();
        System.out.println(dpStartDatum.getValue() + " " + TS);
        App.setRoot("mainView");
    }
    @FXML
    private void btnAddVermietung(ActionEvent event) {
        choiceToDateStart();
        choiceToDateEnde();
        LocalDateTime temp1 = new LocalDateTime.of(dpStartDatum.getValue(), TS) ; 
        LocalDateTime temp2 = new LocalDateTime.of(dpEndDatum.getValue(), TE);
        App.vermietungen.add(new VermietungModel(temp1, temp2, selKunde, selFahrzeug));
    }
    @FXML
    private void selFahrzeug(MouseEvent event) {
       int temp4 = lvFahrzeugAuswahl.getSelectionModel().getSelectedIndex();
       selFahrzeug = App.fahrzeuge.get(temp4);
       
    }

    @FXML
    private void selKunde(MouseEvent event) {
        int temp4 = lvKundeAuswahl.getSelectionModel().getSelectedIndex();
        selKunde = App.kunden.get(temp4);
    }




    private void fillChoiceBox(){
        choiceZeitStart.getItems().add("01:00");
        choiceZeitStart.getItems().add("02:00");
        choiceZeitStart.getItems().add("03:00");
        choiceZeitStart.getItems().add("04:00");
        choiceZeitStart.getItems().add("05:00");
        choiceZeitStart.getItems().add("06:00");
        choiceZeitStart.getItems().add("07:00");
        choiceZeitStart.getItems().add("08:00");
        choiceZeitStart.getItems().add("09:00");
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
        
        choiceZeitEnde.getItems().add("01:00");
        choiceZeitEnde.getItems().add("02:00");
        choiceZeitEnde.getItems().add("03:00");
        choiceZeitEnde.getItems().add("04:00");
        choiceZeitEnde.getItems().add("05:00");
        choiceZeitEnde.getItems().add("06:00");
        choiceZeitEnde.getItems().add("07:00");
        choiceZeitEnde.getItems().add("08:00");
        choiceZeitEnde.getItems().add("09:00");
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

    private void choiceToDateStart(){
        switch(choiceZeitStart.getValue()){
            case "01:00":
                TS = LocalTime.of(1, 00);
                break;
            case "02:00":
                TS = LocalTime.of(2, 00);
                break;
            case "03:00":
                TS = LocalTime.of(3, 00);
                break;
            case "04:00":
                TS = LocalTime.of(4, 00);
                break;
            case "05:00":
                TS = LocalTime.of(5, 00);
                break;
            case "06:00":
                TS = LocalTime.of(6, 00);
                break;
            case "07:00":
                TS = LocalTime.of(7, 00);
                break;
            case "08:00":
                TS = LocalTime.of(8, 00);
                break;
            case "09:00":
                TS = LocalTime.of(9, 00);
                break;
            case "10:00":
                TS = LocalTime.of(10, 00);
                break;
            case "11:00":
                TS = LocalTime.of(11, 00);
                break;
            case "12:00":
                TS = LocalTime.of(12, 00);
                break;
            case "13:00":
                TS = LocalTime.of(13, 00);
                break;
            case "14:00":
                TS = LocalTime.of(14, 00);
                break;
            case "15:00":
                TS = LocalTime.of(15, 00);
                break;
            case "16:00":
                TS = LocalTime.of(16, 00);
                break;
            case "17:00":
                TS = LocalTime.of(17, 00);
                break;
            case "18:00":
                TS = LocalTime.of(18, 00);
                break;
            case "19:00":
                TS = LocalTime.of(19, 00);
                break;
            case "20:00":
                TS = LocalTime.of(20, 00);
                break;
            case "21:00":
                TS = LocalTime.of(21, 00);
                break;
            case "22:00":
                TS = LocalTime.of(22, 00);
                break;
            case "23:00":
                TS = LocalTime.of(23, 00);
                break;
            case "24:00":
                TS = LocalTime.of(24, 00);
                break;
        } 
    }
  
    private void choiceToDateEnde(){
        switch(choiceZeitEnde.getValue()){
            case "01:00":
                TE = LocalTime.of(1, 00);
                break;
            case "02:00":
                TE = LocalTime.of(2, 00);
                break;
            case "03:00":
                TE = LocalTime.of(3, 00);
                break;
            case "04:00":
                TE = LocalTime.of(4, 00);
                break;
            case "05:00":
                TE = LocalTime.of(5, 00);
                break;
            case "06:00":
                TE = LocalTime.of(6, 00);
                break;
            case "07:00":
                TE = LocalTime.of(7, 00);
                break;
            case "08:00":
                TE = LocalTime.of(8, 00);
                break;
            case "09:00":
                TE = LocalTime.of(9, 00);
                break;
            case "10:00":
                TE = LocalTime.of(10, 00);
                break;
            case "11:00":
                TE = LocalTime.of(11, 00);
                break;
            case "12:00":
                TE = LocalTime.of(12, 00);
                break;
            case "13:00":
                TE = LocalTime.of(13, 00);
                break;
            case "14:00":
                TE = LocalTime.of(14, 00);
                break;
            case "15:00":
                TE = LocalTime.of(15, 00);
                break;
            case "16:00":
                TE = LocalTime.of(16, 00);
                break;
            case "17:00":
                TE = LocalTime.of(17, 00);
                break;
            case "18:00":
                TE = LocalTime.of(18, 00);
                break;
            case "19:00":
                TE = LocalTime.of(19, 00);
                break;
            case "20:00":
                TE = LocalTime.of(20, 00);
                break;
            case "21:00":
                TE = LocalTime.of(21, 00);
                break;
            case "22:00":
                TE = LocalTime.of(22, 00);
                break;
            case "23:00":
                TE = LocalTime.of(23, 00);
                break;
            case "24:00":
                TE = LocalTime.of(24, 00);
                break;   
        }
    }

    

}
