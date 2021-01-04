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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class AddKundeController implements Initializable {

    @FXML
    private TextField txtVorname;
    @FXML
    private TextField txtNachname;
    @FXML
    private TextField txtGeburtsort;
    @FXML
    private TextField txtGeburtsdatum;
    @FXML
    private ChoiceBox<String> choiceTyp;
    @FXML
    private TextField txtArbeitsAdresse;
    @FXML
    private TextField txtArbeitsNummer;
    @FXML
    private TextField txtSicherheitsKontakt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceTyp.setDisable(false);
        choiceTyp.getItems().add("Geschäftskunde");
        choiceTyp.getItems().add("Privatkunde");
    }    

    @FXML
    private void btnAddKunde(ActionEvent event) {
        switch(choiceTyp.getValue()){
            case "Geschäftskunde":
            {
                
                App.kunden.add(new GeschaeftsKundeModel(txtArbeitsAdresse.getText(), txtArbeitsNummer.getText(),  txtGeburtsdatum.getText(),txtVorname.getText(),  txtNachname.getText(), txtGeburtsort.getText(), "Geschäftskunde"));
                break;
            }
            case "Privatkunde":
            {
                App.kunden.add(new PrivatKundeModel(txtSicherheitsKontakt.getText(), txtGeburtsdatum.getText(), txtVorname.getText(), txtNachname.getText(), txtGeburtsort.getText(), "Privatkunde"));
                break;
            }
        }
        Integer i = App.kunden.size() - 1;
        System.out.println("Vorname: " + App.kunden.get(i).getVorname() + " // Nachname: " + App.kunden.get(i).getNachname() + " // Kundentyp: " + App.kunden.get(i).getKundenTyp() + " // Geburtsdatum: " + App.kunden.get(i).getGeburtsdatum() + " // Geburtsort: " + App.kunden.get(i).getGeburtsort());
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
    @FXML
    private void btnRefresh(ActionEvent event) {
            if(choiceTyp.getValue().equals("Geschäftskunde")){
                choiceTyp.setDisable(true);
                txtSicherheitsKontakt.setOpacity(0.0);
                txtSicherheitsKontakt.setEditable(false);
                txtArbeitsNummer.setOpacity(1.0);
                txtArbeitsNummer.setEditable(true);
                txtArbeitsAdresse.setOpacity(1.0);
                txtArbeitsAdresse.setEditable(true);
                txtArbeitsAdresse.toFront();
            }
            else if (choiceTyp.getValue().equals("Privatkunde")){
                choiceTyp.setDisable(true);
                txtSicherheitsKontakt.setOpacity(1.0);
                txtSicherheitsKontakt.setEditable(true);
                txtSicherheitsKontakt.toFront();
                txtArbeitsNummer.setOpacity(0.0);
                txtArbeitsNummer.setEditable(false);
                txtArbeitsAdresse.setOpacity(0.0);
                txtArbeitsAdresse.setEditable(false);
                
             }
    }
    
}
