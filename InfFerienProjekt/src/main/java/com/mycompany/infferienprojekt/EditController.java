/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private DatePicker dpEdit;
    @FXML
    private ChoiceBox<String> choiceTime;
    
    LocalTime T;
    int selectedIndex;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showTextField();
        fillListView();
        fillChoiceBox();
        fillChoiceEdit();
    }    

    @FXML
    private void selDone(MouseEvent event) {
        showTextField();
        switch(App.getOriginTyp()){
            case "Fahrzeug": 
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0: 
                        labelEdit.setText("Hersteller:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getHersteller());
                        selectedIndex = 0;
                        System.out.println(selectedIndex);
                    break;
                    
                    case 1: 
                        labelEdit.setText("Modell:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getModell());
                        selectedIndex = 1;
                        System.out.println(selectedIndex);
                    break;
                    
                    case 2: 
                        labelEdit.setText("Farbe:");
                        txtEdit.setText(FahrzeugController.selectedFahrzeug.getFarbe());
                        System.out.println(FahrzeugController.selectedFahrzeug.getFarbe());
                        selectedIndex = 2;
                        System.out.println(selectedIndex);
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
                        showCheckBox();
                        checkBoxEdit.setText("In Reparatur");
                        checkBoxEdit.setSelected(FahrzeugController.selectedFahrzeug.getInReparatur());
                    break;
                    
                    case 7: 
                        labelEdit.setText("");
                        showCheckBox();
                        checkBoxEdit.setText("In Benutzung");
                        checkBoxEdit.setSelected(FahrzeugController.selectedFahrzeug.getInBenutzung());
                    break;
                    
                    case 8:
                        labelEdit.setText("Stundenkosten:");
                        String temp2 = FahrzeugController.selectedFahrzeug.getStundenkosten() + "";
                        txtEdit.setText(temp2);
                    break;
                }    
            break;
            
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
            break;
            
            case "Vermietung":
                int e = lvEditChoice.getSelectionModel().getSelectedIndex();
                VermietungModel x = VermietungController.selectedVermietung;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0: 
                        dpEdit.setValue(null);
                        showDatePicker();
                        labelEdit.setText("Startdatum:");
                        dpEdit.setValue(x.getStartDatum().toLocalDate());
                    break;
                    
                    case 1: 
                        dpEdit.setValue(null);
                        showDatePicker();
                        labelEdit.setText("Enddatum:");
                        dpEdit.setValue(x.getEndDatum().toLocalDate());
                    break;
                    
                    case 2: 
                        labelEdit.setText("Kunde:");
                        txtEdit.setText(x.getKunde().getVorname() + " " + App.vermietungen.get(e).getKunde().getNachname());
                        App.setListView("Kunden");
                    break;
                    
                    case 3: 
                        labelEdit.setText("Fahrzeug:");
                        showFahrzeugeInView();
                        txtEdit.setText(x.getFahrzeug().getHersteller() + " " + App.vermietungen.get(e).getFahrzeug().getModell());
                        App.setListView("Fahrzeuge");
                    break;
                    
                    case 4: 
                        labelEdit.setText("Dauer:  // nicht änderbar");
                        txtEdit.setText(x.getDuration()+ "");
                        //txtEdit.setEditable(false);
                    break;
                    
                    case 5: 
                        labelEdit.setText("Kosten:  // nicht änderbar");
                        txtEdit.setText(x.getKosten() + "€");
                        //txtEdit.setEditable(false);
                    break;
                }
            break;
        } 
    }
    
    private void showTextField(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(1);
        txtEdit.setDisable(false);
        txtEdit.toFront();
        choiceTyp.toBack();
        choiceTyp.setOpacity(0);
        choiceTyp.setDisable(true);
        dpEdit.setOpacity(0);
        dpEdit.setDisable(true);
        dpEdit.toBack();
        choiceTime.setOpacity(0);
        choiceTime.setDisable(true);
        choiceTime.toBack();
    }
    
    private void showCheckBox(){
        checkBoxEdit.setOpacity(1);
        checkBoxEdit.setDisable(false);
        checkBoxEdit.toFront();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        choiceTyp.toBack();
        choiceTyp.setOpacity(0);
        choiceTyp.setDisable(true);
        dpEdit.setOpacity(0);
        dpEdit.setDisable(true);
        dpEdit.toBack();
        choiceTime.setOpacity(0);
        choiceTime.setDisable(true);
        choiceTime.toBack();
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
         dpEdit.setOpacity(0);
        dpEdit.setDisable(true);
        dpEdit.toBack();
        choiceTime.setOpacity(0);
        choiceTime.setDisable(true);
        choiceTime.toBack();
    }
    
    private void showDatePicker(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        choiceTyp.toBack();
        choiceTyp.setOpacity(0);
        choiceTyp.setDisable(true);
        dpEdit.setOpacity(1);
        dpEdit.setDisable(false);
        dpEdit.toFront();
        choiceTime.setOpacity(1);
        choiceTime.setDisable(false);
        choiceTime.toFront();
    }
    
    @FXML
    private void btnEditField(ActionEvent event) {
    }

    @FXML
    private void btnEditDone(ActionEvent event) {
        //txtEdit.setEditable(true);
        fillListView();
        switch(App.getOriginTyp()){
            case "Fahrzeug":
                FahrzeugModel fm = App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex);
                App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex);
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    
                    case 0: 
                        App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).setHersteller(txtEdit.getText());
                        System.out.println(fm.getHersteller());
                        selectedIndex = 0;
                    break;

                    case 1: 
                        System.out.println(fm.getModell());
                        App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).setModell(txtEdit.getText());
                        selectedIndex = 1;
                    break;

                    case 2: 
                        App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).setFarbe(txtEdit.getText());
                        System.out.println(fm.getFarbe());
                        selectedIndex = 2;
                    break;

                    case 3: 
                        App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).setKennzeichen(txtEdit.getText());
                        System.out.println(fm.getKennzeichen());
                        selectedIndex = 3;
                    break;

                    case 4: 
                        fm.setTyp(txtEdit.getText());
                        System.out.println(fm.getTyp());
                    break;

                    case 5: 
                        int temp1 = Integer.parseInt(txtEdit.getText());
                        fm.setFahrzeugnummer(temp1);
                    break;

                    case 6: 
                        fm.setInReparatur(checkBoxEdit.isSelected());
                    break;

                    case 7: 
                        fm.setInBenutzung(checkBoxEdit.isSelected());
                    break;

                    case 8: 
                        double temp2 = Double.parseDouble(txtEdit.getText());
                        fm.setStundenkosten(temp2);
                    break;
                }
               
            break;
            
            case "GeschaeftsKunde":
                GeschaeftsKundeModel g = (GeschaeftsKundeModel) KundeController.selectedKunde;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0:
                        g.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        g.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        g.setGeburtsort(txtEdit.getText());
                    break;
                    
                    case 3:
                        g.setGeburtsdatum(txtEdit.getText());
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
                        p.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        p.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        p.setGeburtsort(txtEdit.getText());
                    break;
                    
                    case 3:
                        p.setGeburtsdatum(txtEdit.getText());
                    break;
                    
                    case 4:
                       p.setKundenTyp(choiceTyp.getValue());
                    break;
                    
                    case 5:
                        p.setSicherheitsKontakt(txtEdit.getText());
                    break;
                }
            break; 
            
            case "Vermietung":
                choiceDateEdit();
                LocalDateTime temp1 = LocalDateTime.of(dpEdit.getValue(), T) ; 
                VermietungModel y = VermietungController.selectedVermietung;
                switch(lvEditChoice.getSelectionModel().getSelectedIndex()){
                    case 0:
                        showDatePicker();
                        y.setStartDatum(temp1);
                    break;
                    
                    case 1:
                        showDatePicker();
                        y.setEndDatum(temp1);
                    break;
                    
                    case 2:
                        showFahrzeugeInView();
                    break;
                    
                    case 3:
                        
                    break;   
                }
            break;

        }
        System.out.println(selectedIndex);
        labelEdit.setText("");
        fillListView();
        //txtEdit.clear();
        //showTextField();
        //App.setListView("Vermietung");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
    private void fillListView(){
        lvEditChoice.getItems().clear();
        switch (App.getOriginTyp()) {
            case "Vermietung":
                VermietungModel vm = VermietungController.selectedVermietung;
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String temp1 = vm.getStartDatum().format(format);
                String temp2 = vm.getEndDatum().format(format);
                lvEditChoice.getItems().add("Startdatum: " + temp1);
                lvEditChoice.getItems().add("Enddatum : " + temp2);
                if(VermietungController.selectedVermietung.getKunde().getKundenTyp().equals("Geschäftskunde")){
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) VermietungController.getSelectedVermietung().getKunde();
                    lvEditChoice.getItems().add(" // KUNDE // " + " Kundentyp: " + g.getKundenTyp() + " / Vorname: " + g.getVorname() + " / Nachname: " + g.getNachname() + " / Geburtsdatum: " + g.getGeburtsdatum());
                }
                else  if(VermietungController.selectedVermietung.getKunde().getKundenTyp().equals("Privatkunde")){
                    PrivatKundeModel p = (PrivatKundeModel) VermietungController.getSelectedVermietung().getKunde();
                    lvEditChoice.getItems().add(" // KUNDE // " + " Kundentyp: " + p.getKundenTyp() + "/ Vorname: " + p.getVorname() + " / Nachname: " + p.getNachname() + " / Geburtsdatum: " + p.getGeburtsdatum());
                }   
                
                
                String temp3 = VermietungController.selectedVermietung.getFahrzeug().getFahrzeugnummer() + "";
                String temp4 = VermietungController.selectedVermietung.getFahrzeug().getInReparatur() + "";
                String temp5 = VermietungController.selectedVermietung.getFahrzeug().getInBenutzung() + "";
                String temp6 = VermietungController.selectedVermietung.getFahrzeug().getStundenkosten() + "€";
                FahrzeugModel Z = VermietungController.selectedVermietung.getFahrzeug();
                lvEditChoice.getItems().add(" // FAHRZEUG // " +  " Fahrzeugtyp: " + Z.getTyp() + " / Fahrzeug: " + Z.getHersteller() + " / Modell: " + Z.getModell() + " / Farbe: " + Z.getFarbe());
                
                lvEditChoice.getItems().add("Dauer: " + vm.getDuration() + "");
                lvEditChoice.getItems().add("Kosten: " + vm.getKosten() + "");
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
                String temp7 = App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getFahrzeugnummer() + "";
                String temp8 = App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getInReparatur() + "";
                String temp9 = App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getInBenutzung() + "";
                String temp10 = App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getStundenkosten() + "€";
                lvEditChoice.getItems().add("Hersteller: " + App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getHersteller());
                lvEditChoice.getItems().add("Modell: " + App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getModell());
                lvEditChoice.getItems().add("Farbe: " + App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getFarbe());
                lvEditChoice.getItems().add("Kennzeichen: " + App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getKennzeichen());
                lvEditChoice.getItems().add("Fahrzeugtyp: " + App.fahrzeuge.get(FahrzeugController.selFahrzeugIndex).getTyp());
                lvEditChoice.getItems().add("Fahrzeugnummer: " + temp7);
                lvEditChoice.getItems().add("In Reparatur: " + temp8);
                lvEditChoice.getItems().add("In Benutzung: " + temp9);
                lvEditChoice.getItems().add("Stundenkosten: " + temp10);
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
    
    private void fillChoiceEdit(){
        choiceTime.getItems().add("01:00");
        choiceTime.getItems().add("02:00");
        choiceTime.getItems().add("03:00");
        choiceTime.getItems().add("04:00");
        choiceTime.getItems().add("05:00");
        choiceTime.getItems().add("06:00");
        choiceTime.getItems().add("07:00");
        choiceTime.getItems().add("08:00");
        choiceTime.getItems().add("09:00");
        choiceTime.getItems().add("10:00");
        choiceTime.getItems().add("11:00");
        choiceTime.getItems().add("12:00");
        choiceTime.getItems().add("13:00");
        choiceTime.getItems().add("14:00");
        choiceTime.getItems().add("15:00");
        choiceTime.getItems().add("16:00");
        choiceTime.getItems().add("17:00");
        choiceTime.getItems().add("18:00");
        choiceTime.getItems().add("19:00");
        choiceTime.getItems().add("20:00");
        choiceTime.getItems().add("21:00");
        choiceTime.getItems().add("22:00");
        choiceTime.getItems().add("23:00");
        choiceTime.getItems().add("24:00");
    }
    
    private void choiceDateEdit(){
        switch(choiceTime.getValue()){
            case "01:00":
                T = LocalTime.of(1, 00);
                break;
            case "02:00":
                T = LocalTime.of(2, 00);
                break;
            case "03:00":
                T = LocalTime.of(3, 00);
                break;
            case "04:00":
                T = LocalTime.of(4, 00);
                break;
            case "05:00":
                T = LocalTime.of(5, 00);
                break;
            case "06:00":
                T = LocalTime.of(6, 00);
                break;
            case "07:00":
                T = LocalTime.of(7, 00);
                break;
            case "08:00":
                T = LocalTime.of(8, 00);
                break;
            case "09:00":
                T = LocalTime.of(9, 00);
                break;
            case "10:00":
                T = LocalTime.of(10, 00);
                break;
            case "11:00":
                T = LocalTime.of(11, 00);
                break;
            case "12:00":
                T = LocalTime.of(12, 00);
                break;
            case "13:00":
                T = LocalTime.of(13, 00);
                break;
            case "14:00":
                T = LocalTime.of(14, 00);
                break;
            case "15:00":
                T = LocalTime.of(15, 00);
                break;
            case "16:00":
                T = LocalTime.of(16, 00);
                break;
            case "17:00":
                T = LocalTime.of(17, 00);
                break;
            case "18:00":
                T = LocalTime.of(18, 00);
                break;
            case "19:00":
                T = LocalTime.of(19, 00);
                break;
            case "20:00":
                T = LocalTime.of(20, 00);
                break;
            case "21:00":
                T = LocalTime.of(21, 00);
                break;
            case "22:00":
                T = LocalTime.of(22, 00);
                break;
            case "23:00":
                T = LocalTime.of(23, 00);
                break;
            case "24:00":
                T = LocalTime.of(24,00);
                break;
        } 
    }
    
    private void showFahrzeugeInView(){
        lvEditChoice.getItems().clear();
        for(FahrzeugModel f : App.getFahrzeuge()){
            lvEditChoice.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
        }
    }
    
    private void showKundenInView(){
        switch (VermietungController.selectedVermietung.getKunde().getKundenTyp()){
                case "Geschäftskunde":
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
                }
            break;
                
        }
    }
}
