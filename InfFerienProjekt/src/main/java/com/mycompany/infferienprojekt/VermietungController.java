package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class VermietungController implements Initializable {

    //definiert die ListView lvVermietungDetail
    //in der lvVermietungDetail werden die Variablen der Objekte der ArrayList vermietungen abgebildet
    @FXML
    private ListView<String> lvVermietungDetail;
    
    //definiert die Variable selectedVermietung, die in btnEditVermietung genutzt wird und in EditController aufgerufen wird
    public static VermietungModel selectedVermietung;
     //definiert den int selVermietungIndex, um leichter aus anderen Klassen auf den Index des "selectedVermietung" zugreifen zu können
    static  int selVermietungIndex;
    //definiert den button EditVermietung, sodass man einstellen kann, wann er nutzbar wird (selVermietungEdit)
    @FXML
    private Button EditVermietung;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //setzt den EditVermietung button auf nicht nutzbar, da kein Objekt ausgewählt ist
            EditVermietung.setDisable(true);
            //füllt die ListView lvVermietungDetail mit allen Objekten aus der ArrayList vermietungen
            for(VermietungModel v : App.getVermietungen()){
                //setzt den Formatter format auf das Pattern "dd-MM-yyyy HH:mm"
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                //setzt die Strings temp1 und temp2 auf Start- und Enddatum im neuen Format
                String temp1 = v.getStartDatum().format(format);
                String temp2 = v.getEndDatum().format(format);
                lvVermietungDetail.getItems().add("Startdatum: " + temp1 + " // Enddatum: " + temp2 + " // Fahrzeugtyp: " + v.getFahrzeug().getTyp() + " // Modell: " + v.getFahrzeug().getModell() + " // Farbe: " + v.getFahrzeug().getFarbe() + " // Kunde: " + v.getKunde().getVorname()+ " " + v.getKunde().getNachname() + " // Kundentyp: " + v.getKunde().getKundenTyp() + " // Dauer: " + v.getDuration() + " Stunden // Kosten: " + v.getDuration()*v.getFahrzeug().getStundenkosten() + "€");
            }
        
    }    

    //definiert die buttons um in die verschiedenen Views zu gelangen
    @FXML
    private void btnAddVermietung(ActionEvent event) throws IOException {
        App.setRoot("addVermietungView");
    }

    @FXML
    private void btnEditVermietung(ActionEvent event) throws IOException {
        //definiert den int temp1, der der Index des in der ListView ausgewählten Objektes ist
        int temp1 = lvVermietungDetail.getSelectionModel().getSelectedIndex();
        //holt sich die "selectedVermietung" aus der ArrayList vermietungen
        selectedVermietung = App.vermietungen.get(temp1);
        //setzt selFahrzeugIndex auf den Index des in der ListView ausgewählten Objektes
        selVermietungIndex = temp1;
        //setzt die Origin auf Vermietung, um in EditController zu wissen, dass man davor in VermietungController war und deswegen selectedVermietung aufrufen muss
        App.setOriginTyp("Vermietung");
        App.setRoot("editView");
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainVIew");
    }

    //setzt den EditVermietung button auf nutzbar, wenn auf die ListView geclickt wird
    @FXML
    private void selVermietungEdit(MouseEvent event) {
        EditVermietung.setDisable(false);
    }
    
}
