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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class AddFahrzeugController implements Initializable {

    @FXML
    private TextField txtHersteller;
    @FXML
    private TextField txtModell;
    @FXML
    private TextField txtFarbe;
    @FXML
    private TextField txtKennzeichen;
    @FXML
    private TextField txtStundenkosten;
    @FXML
    private TextField txtFahrzeugnummer;
    @FXML
    private ChoiceBox<String> choiceTyp;
    @FXML
    private CheckBox checkBenutzung;
    @FXML
    private CheckBox checkReparatur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceTyp.getItems().add("PKW");
        choiceTyp.getItems().add("LKW");
        choiceTyp.getItems().add("Anhänger");
        choiceTyp.getItems().add("Van");
        // TODO
    }    

    @FXML
    private void btnAddFahrzeug(ActionEvent event) {
        switch (choiceTyp.getValue()) {
            case "PKW":
                {
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    App.fahrzeuge.add(new AutoModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "PKW", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            case "LKW":
                {
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    App.fahrzeuge.add(new LKWModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "LKW", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            case "Anhänger":
                {
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    App.fahrzeuge.add(new AnhaengerModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "Anhänger", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            case "Van":
                {
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    App.fahrzeuge.add(new VanModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "Van", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            default:
                break;
        }
        App.fahrzeuge.get(0);
        System.out.println("Hersteller: " + App.fahrzeuge.get(0).getHersteller() + " // Modell: " + App.fahrzeuge.get(0).getModell() + " // In Reparatur: " + App.fahrzeuge.get(0).getInReparatur() + " // Stundenkosten: " + App.fahrzeuge.get(0).getStundenkosten() + "€");
    
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
}
