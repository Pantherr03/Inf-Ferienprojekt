package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddKundeController implements Initializable {

    //definiert die verschiedenen Textfelder zum festlegen der Werte des neuen Kunden
    @FXML
    private TextField txtVorname;
    @FXML
    private TextField txtNachname;
    @FXML
    private TextField txtGeburtsort;
    @FXML
    private TextField txtGeburtsdatum;
    
    //definiert die ChoiceBox zum festlegen des Kundentyps
    @FXML
    private ChoiceBox<String> choiceTyp;
    
    //definiert die KundenTyp-spezifischen Textfelder
    @FXML
    private TextField txtArbeitsAdresse;
    @FXML
    private TextField txtArbeitsNummer;
    @FXML
    private TextField txtSicherheitsKontakt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //macht die choiceBox nutzbar
        choiceTyp.setDisable(false);
        
        //fügt die Kundentypen zur ChoiceBox choiceTyp an
        choiceTyp.getItems().add("Geschäftskunde");
        choiceTyp.getItems().add("Privatkunde");
    }    

    @FXML
    private void btnAddKunde(ActionEvent event) {
        
        //ruft choiceTyp.getValue auf, um den Kundentypen des neuen Kunden zu erhalten
        switch(choiceTyp.getValue()){
            
            //überprüft, ob der Kundentyp "Geschäftskunde" ist
            case "Geschäftskunde":
            {
                //fügt der ArrayList kunden einen neuen Geschäftskunden hinzu
                App.kunden.add(new GeschaeftsKundeModel(txtArbeitsAdresse.getText(), txtArbeitsNummer.getText(),  txtGeburtsdatum.getText(),txtVorname.getText(),  txtNachname.getText(), txtGeburtsort.getText(), "Geschäftskunde"));
                break;
            }
            //überprüft, ob der Kundentyp "Geschäftskunde" ist
            case "Privatkunde":
            {
                //fügt der ArrayList kunden einen neuen Privatkunden hinzu
                App.kunden.add(new PrivatKundeModel(txtSicherheitsKontakt.getText(), txtGeburtsdatum.getText(), txtVorname.getText(), txtNachname.getText(), txtGeburtsort.getText(), "Privatkunde"));
                break;
            }
        }
        System.out.println("neuer Kunde erstellt");
    }

    //definiert den button, um in die mainView zu gelangen
    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    
    //definiert den button zum bestätigen der Auswahl in der choiceBox um sie zu verstecken und die spezifischen Textfelder zu zeigen
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
