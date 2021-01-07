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

public class AddFahrzeugController implements Initializable {

    //definiert die verschiedenen Textfelder zum festlegen der Werte des neuen Fahrzeuges
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
    
    //definiert die ChoiceBox zum festlegen des Fahrzeugtyps
    @FXML
    private ChoiceBox<String> choiceTyp;
    
    //definiert die CheckBoxen zum einstellen der booleans InBenutzung und InReparatur
    @FXML
    private CheckBox checkBenutzung;
    @FXML
    private CheckBox checkReparatur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //fügt die Fahrzeugtypen zur ChoiceBox choiceTyp an
        choiceTyp.getItems().add("PKW");
        choiceTyp.getItems().add("LKW");
        choiceTyp.getItems().add("Anhänger");
        choiceTyp.getItems().add("Van");
    }    

    @FXML
    private void btnAddFahrzeug(ActionEvent event) {
        
        //ruft choiceTyp.getValue auf, um den Fahrzeugtypen des neuen Fahrzeuges zu erhalten
        switch (choiceTyp.getValue()) {
            
            //überprüft, ob der Fahrzeugtyp "PKW" ist
            case "PKW":
                {
                    //konvertiert den Input in den Textfields txtStundenkosten und txtFahrzeugnummer zu int und double
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    
                    //fügt der ArrayList fahrzeuge einen neuen PKW hinzu
                    App.fahrzeuge.add(new PkwModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "PKW", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            //überprüft, ob der Fahrzeugtyp "LKW" ist
            case "LKW":
                {
                    //konvertiert den Input in den Textfields txtStundenkosten und txtFahrzeugnummer zu int und double
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    
                    //fügt der ArrayList fahrzeuge einen neuen LKW hinzu
                    App.fahrzeuge.add(new LKWModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "LKW", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            //überprüft, ob der Fahrzeugtyp "Anhänger" ist
            case "Anhänger":
                {
                    //konvertiert den Input in den Textfields txtStundenkosten und txtFahrzeugnummer zu int und double
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    
                    //fügt der ArrayList fahrzeuge einen neuen Anhänger hinzu
                    App.fahrzeuge.add(new AnhaengerModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "Anhänger", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            //überprüft, ob der Fahrzeugtyp "Van" ist
            case "Van":
                {
                    //konvertiert den Input in den Textfields txtStundenkosten und txtFahrzeugnummer zu int und double
                    double temp3 = Double.parseDouble(txtStundenkosten.getText());
                    int temp4 = Integer.parseInt(txtFahrzeugnummer.getText());
                    
                    //fügt der ArrayList fahrzeuge einen neuen Van hinzu
                    App.fahrzeuge.add(new VanModel(txtHersteller.getText(), txtModell.getText(), txtFarbe.getText(), txtKennzeichen.getText(), "Van", checkReparatur.isSelected(), checkBenutzung.isSelected(), temp3, temp4));
                    break;
                }
            default:
                break;
        }
        System.out.println("neues Fahrzeug erstellt");
    }

    //definiert den button, um in die mainView zu gelangen
    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
}
