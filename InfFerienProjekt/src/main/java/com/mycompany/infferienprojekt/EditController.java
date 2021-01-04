/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class EditController implements Initializable {

    @FXML
    private ListView<String> lvEditChoice;
    @FXML
    private TextField txtEdit;
    
    VermietungModel v;
    @FXML
    private CheckBox checkBoxEdit;
    @FXML
    private Label labelEdit;
    @FXML
    private ChoiceBox<String> choiceTyp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hideCheckBox();
        fillListView();
        fillChoiceBox();
    }    

    @FXML
    private void selDone(MouseEvent event) {
        hideCheckBox();
        switch(App.getOriginTyp()){
            case "Fahrzeug": 
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0: 
                        labelEdit.setText("Hersteller:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getHersteller());
                    break;
                    
                    case 1: 
                        labelEdit.setText("Modell:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getModell());
                    break;
                    
                    case 2: 
                        labelEdit.setText("Farbe:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getFarbe());
                    break;
                    
                    case 3: 
                        labelEdit.setText("Kennzeichen:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getKennzeichen());
                    break;
                    
                    case 4: 
                        labelEdit.setText("Fahrzeugtyp:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getTyp());
                    break;
                    
                    case 5: 
                        labelEdit.setText("Fahrzeugnummer:");
                        String temp1 = FahrzeugController.selectedFahrzeug.getFahrzeugnummer() + "";
                        txtEdit.setText(temp1);
                    break;
                    
                    case 6: 
                        labelEdit.setText("");
                        hideTextField();
                        checkBoxEdit.setText("In Reparatur");
                        checkBoxEdit.setSelected(FahrzeugController.selectedFahrzeug.getInReparatur());
                    break;
                    
                    case 7: 
                        labelEdit.setText("");
                        hideTextField();
                        checkBoxEdit.setText("In Benutzung");
                        checkBoxEdit.setSelected(FahrzeugController.selectedFahrzeug.getInBenutzung());
                    break;
                    
                    case 8:
                        labelEdit.setText("Stundenkosten:");
                        String temp2 = FahrzeugController.selectedFahrzeug.getStundenkosten() + "";
                        txtEdit.setText(temp2);
                    break;
            }    
            case "GeschaeftsKunde": 
                GeschaeftsKundeModel g = (GeschaeftsKundeModel) KundeController.selectedKunde;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0: 
                        labelEdit.setText("Vorname:");
                        txtEdit.setText(g.getVorname());
                    break;
                    
                    case 1: 
                        labelEdit.setText("Nachname:");
                        txtEdit.setText(g.getNachname());
                    break;
                    
                    case 2: 
                        labelEdit.setText("Geburtsort:");
                        txtEdit.setText(g.getGeburtsort());
                    break;
                    
                    case 3: 
                        labelEdit.setText("Geburtsdatum:");
                        txtEdit.setText(g.getGeburtsdatum());
                    break;
                    
                    case 4: 
                        showChoiceBox();
                        labelEdit.setText("Kundentyp:");
                    break;
                    
                    case 5: 
                        labelEdit.setText("Arbeitsadresse:");
                        txtEdit.setText(g.getArbeitsAdresse());
                    break;
                    
                    case 6: 
                        labelEdit.setText("Arbeitstelefonnummer:");
                        txtEdit.setText(g.getArbeitsTelefonnummer());
                    break;
            }
        } 
    }
    
    private void hideCheckBox(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(1);
        txtEdit.setDisable(false);
        txtEdit.toFront();
        choiceTyp.toBack();
        choiceTyp.setOpacity(0);
        choiceTyp.setDisable(true);
    }
    
    private void hideTextField(){
        checkBoxEdit.setOpacity(1);
        checkBoxEdit.setDisable(false);
        checkBoxEdit.toFront();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        choiceTyp.toBack();
        choiceTyp.setOpacity(0);
        choiceTyp.setDisable(true);
    }
    
    private void showChoiceBox(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        choiceTyp.toFront();
        choiceTyp.setOpacity(1);
        choiceTyp.setDisable(false);
         
        
    }
    
    @FXML
    private void btnEditField(ActionEvent event) {
    }

    @FXML
    private void btnEditDone(ActionEvent event) {
        switch(App.getOriginTyp()){
            case "Fahrzeug":
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0: 
                        FahrzeugController.selectedFahrzeug.setHersteller(txtEdit.getText());
                    break;

                    case 1: 
                        FahrzeugController.selectedFahrzeug.setModell(txtEdit.getText());
                    break;

                    case 2: 
                        FahrzeugController.selectedFahrzeug.setFarbe(txtEdit.getText());
                    break;

                    case 3: 
                        FahrzeugController.selectedFahrzeug.setKennzeichen(txtEdit.getText());
                    break;

                    case 4: 
                        FahrzeugController.selectedFahrzeug.setTyp(txtEdit.getText());
                    break;

                    case 5: 
                        int temp1 = Integer.parseInt(txtEdit.getText());
                        FahrzeugController.selectedFahrzeug.setFahrzeugnummer(temp1);
                    break;

                    case 6: 
                        FahrzeugController.selectedFahrzeug.setInReparatur(checkBoxEdit.isSelected());
                    break;

                    case 7: 
                        FahrzeugController.selectedFahrzeug.setInBenutzung(checkBoxEdit.isSelected());
                    break;

                    case 8: 
                        double temp2 = Double.parseDouble(txtEdit.getText());
                        FahrzeugController.selectedFahrzeug.setStundenkosten(temp2);
                    break;
                }
            case "GeschaeftsKunde":
                GeschaeftsKundeModel g = (GeschaeftsKundeModel) KundeController.selectedKunde;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0:
                        KundeController.selectedKunde.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        KundeController.selectedKunde.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        KundeController.selectedKunde.setGeburtsort(txtEdit.getText());
                    break;
                    
                    case 3:
                        KundeController.selectedKunde.setGeburtsdatum(txtEdit.getText());
                    break;
                    
                    case 4: 
                        g.setKundenTyp(choiceTyp.getValue());
                    break;
                    
                    case 5:
                        g.setArbeitsAdresse(txtEdit.getText());
                    break;
                    
                    case 6:
                        g.setArbeitsTelefonnummer(txtEdit.getText());
                    break;
                }
            break; 
            
            case "PrivatKunde":
                PrivatKundeModel p = (PrivatKundeModel) KundeController.selectedKunde;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0:
                        KundeController.selectedKunde.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        KundeController.selectedKunde.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        KundeController.selectedKunde.setGeburtsort(txtEdit.getText());
                    break;
                    
                    case 3:
                        KundeController.selectedKunde.setGeburtsdatum(txtEdit.getText());
                    break;
                    
                    case 4:
                       
                    break;
                    
                    case 5:
                        p.setSicherheitsKontakt(txtEdit.getText());
                    break;
                }
            break; 
            
            
                
        }
        fillListView();
        txtEdit.clear();
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    private void fillListView(){
        lvEditChoice.getItems().clear();
        switch (App.getOriginTyp()) {
            case "Vermietung":
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String temp1 = v.getStartDatum().format(format);
                String temp2 = v.getEndDatum().format(format);
                lvEditChoice.getItems().add(temp1);
                lvEditChoice.getItems().add(temp2);
                lvEditChoice.getItems().add(temp1);
                if(VermietungController.selectedVermietung.getKunde().getKundenTyp().equals("Geschäftskunde")){
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) KundeController.selectedKunde;
                    lvEditChoice.getItems().add(g.getVorname());
                    lvEditChoice.getItems().add(g.getNachname());
                    lvEditChoice.getItems().add(g.getGeburtsort());
                    lvEditChoice.getItems().add(g.getGeburtsdatum());
                    lvEditChoice.getItems().add(g.getKundenTyp());
                    lvEditChoice.getItems().add(g.getArbeitsAdresse());
                    lvEditChoice.getItems().add(g.getArbeitsTelefonnummer());
                }
                else  if(VermietungController.selectedVermietung.getKunde().getKundenTyp().equals("Privatkunde")){
                    PrivatKundeModel p = (PrivatKundeModel) KundeController.selectedKunde;
                    lvEditChoice.getItems().add(p.getVorname());
                    lvEditChoice.getItems().add(p.getNachname());
                    lvEditChoice.getItems().add(p.getGeburtsort());
                    lvEditChoice.getItems().add(p.getGeburtsdatum());
                    lvEditChoice.getItems().add(p.getKundenTyp());
                    lvEditChoice.getItems().add(p.getSicherheitsKontakt());
                }   
            break;
                
            case "GeschaeftsKunde":
                GeschaeftsKundeModel g = (GeschaeftsKundeModel) KundeController.selectedKunde;
                lvEditChoice.getItems().add(g.getVorname());
                lvEditChoice.getItems().add(g.getNachname());
                lvEditChoice.getItems().add(g.getGeburtsort());
                lvEditChoice.getItems().add(g.getGeburtsdatum());
                lvEditChoice.getItems().add(g.getKundenTyp());
                lvEditChoice.getItems().add(g.getArbeitsAdresse());
                lvEditChoice.getItems().add(g.getArbeitsTelefonnummer());
            break;
                
            case "PrivatKunde":
                PrivatKundeModel p = (PrivatKundeModel) KundeController.selectedKunde;
                lvEditChoice.getItems().add(p.getVorname());
                lvEditChoice.getItems().add(p.getNachname());
                lvEditChoice.getItems().add(p.getGeburtsort());
                lvEditChoice.getItems().add(p.getGeburtsdatum());
                lvEditChoice.getItems().add(p.getKundenTyp());
                lvEditChoice.getItems().add(p.getSicherheitsKontakt());
            break;
            
            case "Fahrzeug":
                String temp3 = FahrzeugController.selectedFahrzeug.getFahrzeugnummer() + "";
                String temp4 = FahrzeugController.selectedFahrzeug.getInReparatur() + "";
                String temp5 = FahrzeugController.selectedFahrzeug.getInBenutzung() + "";
                String temp6 = FahrzeugController.selectedFahrzeug.getStundenkosten() + "€";
                lvEditChoice.getItems().add("Hersteller: " + FahrzeugController.selectedFahrzeug.getHersteller());
                lvEditChoice.getItems().add("Modell: " + FahrzeugController.selectedFahrzeug.getModell());
                lvEditChoice.getItems().add("Farbe: " + FahrzeugController.selectedFahrzeug.getFarbe());
                lvEditChoice.getItems().add("Kennzeichen: " + FahrzeugController.selectedFahrzeug.getKennzeichen());
                lvEditChoice.getItems().add("Fahrzeugtyp: " + FahrzeugController.selectedFahrzeug.getTyp());
                lvEditChoice.getItems().add("Fahrzeugnummer: " + temp3);
                lvEditChoice.getItems().add("In Reparatur: " + temp4);
                lvEditChoice.getItems().add("In Benutzung: " + temp5);
                lvEditChoice.getItems().add("Stundenkosten: " + temp6);
            break;
            default:
                break;
        }
    }
    private void fillChoiceBox(){
        choiceTyp.getItems().add("Geschäftskunde");
        choiceTyp.getItems().add("Privatkunde");
    }
    
    private void displayInListView(){
        switch (App.getOriginTyp()) {
            case "Fahrzeug":
                 lvEditChoice.getItems().clear();
                 for(FahrzeugModel f : App.getFahrzeuge()){
                 lvEditChoice.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
            }
            break;
            
            case "GeschaeftsKunde":
                 lvEditChoice.getItems().clear();
                 for(KundeModel k : App.getKunden()){
                     
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                    lvEditChoice.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());   
                 }
            break;
           
            case "PrivatKunde":
                lvEditChoice.getItems().clear();
                for(KundeModel k : App.getKunden()){
                        PrivatKundeModel p = (PrivatKundeModel) k;
                        lvEditChoice.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
            break;
                }
            case "Vermietung":
                lvEditChoice.getItems().clear();
                for(VermietungModel v : App.getVermietungen()){
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String temp1 = v.getStartDatum().format(format);
                String temp2 = v.getEndDatum().format(format);
                
                lvEditChoice.getItems().add("Startdatum: " + temp1 + " // Enddatum: " + temp2 + " // Fahrzeugtyp: " + v.getFahrzeug().getTyp() + " // Modell: " + v.getFahrzeug().getModell() + " // Farbe: " + v.getFahrzeug().getFarbe() + " // Kunde: " + v.getKunde().getVorname()+ " " + v.getKunde().getNachname() + " // Kundentyp: " + v.getKunde().getKundenTyp());
            break;
                }
        }
    }
}
