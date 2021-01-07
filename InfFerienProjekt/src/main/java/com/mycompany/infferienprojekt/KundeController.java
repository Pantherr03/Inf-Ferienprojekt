package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class KundeController implements Initializable {

    //definiert die ListView lvKundeDetail
    @FXML
    private ListView<String> lvKundeDetail;
    
    //definiert die Variable selectedKunde, die in btnEditKunde genutzt wird und in EditController aufgerufen wird
    static KundeModel selectedKunde;
    
    //definiert den int selKundeIndex, um leichter aus anderen Klassen auf den Index des "selectedKunde" zugreifen zu können
    static int selKundeIndex;
    
    //definiert den button EditKunde, sodass man einstellen kann, wann er nutzbar wird (selKundeEdit)
    @FXML
    private Button EditKunde;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            //setzt den EditKunde button auf nicht nutzbar, da kein Objekt ausgewählt ist
            EditKunde.setDisable(true);
            
            //füllt die ListView lvKundeDetail mit allen Objekten aus der ArrayList kunden
             for(KundeModel k : App.getKunden()){
                 
                 //überprüft, ob die Kunden in der ArrayList kunden Geschäftskunden sind
                 if(k.getKundenTyp().equals("Geschäftskunde")){
                     
                     //definiert, dass g in diesem Fall gleich k ist
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                    
                    //fügt die Variablen des GeschaeftsKundeModel g zur ListView hinzu
                    lvKundeDetail.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());
                     }
                 //überprüft, ob die Kunden in der ArrayList kunden Privatkunden sind
                 else if(k.getKundenTyp().equals("Privatkunde")){
                        
                        //definiert, dass p in diesem Fall gleich k ist
                         PrivatKundeModel p = (PrivatKundeModel) k;
                         
                         //fügt die Variablen des PrivatKundeModel p zur ListView hinzu
                         lvKundeDetail.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
                     }
                 }
             
         
        
    }    
    
    //definiert die buttons um in die verschiedenen Views zu gelangen
    @FXML
    private void btnAddKunde(ActionEvent event) throws IOException {
        App.setRoot("addKundeView");
    }

    @FXML
    private void btnEditKunde(ActionEvent event) throws IOException {
        
        //definiert den int temp1, der der Index des in der ListView ausgewählten Objektes ist
        int temp1 = lvKundeDetail.getSelectionModel().getSelectedIndex();
        
        //definiert das KundeModel selectedKunde, das das Objekt in der ArrayList kunden mit dem Index von temp1 ist (s.o.)
        selectedKunde = App.kunden.get(temp1);
        
        //überprüft ob der Typ des ausgewählten Kunden "Geschäftskunde" ist
        if(selectedKunde.getKundenTyp().equals("Geschäftskunde")){
            
            //setzt selKundeIndex auf den Index des in der ListView ausgewählten Objektes (temp1)
            selKundeIndex = temp1;
            App.setOriginTyp("GeschaeftsKunde");
        }
        //überprüft ob der Typ des ausgewählten Kunden "Privatkunde" ist
        else if(selectedKunde.getKundenTyp().equals("Privatkunde")){
            
            //setzt selKundeIndex auf den Index des in der ListView ausgewählten Objektes (temp1)
            selKundeIndex = temp1;
            App.setOriginTyp("PrivatKunde");
         }
        //ruft die editView auf
        App.setRoot("editView");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainVIew");
    }

    //setzt den EditKunde button auf nutzbar, wenn auf die ListView geclickt wird
    @FXML
    private void selKundeEdit(MouseEvent event) {
        EditKunde.setDisable(false);
    }

}
