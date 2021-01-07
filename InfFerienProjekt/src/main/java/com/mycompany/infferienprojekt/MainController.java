package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;

public class MainController implements Initializable {

    //definiert die drei ListViews und dass sie Strings enthalten
    //in der lvFahrzeuge werden die Variablen der Objekte der ArrayList fahrzeuge abgebildet
    @FXML
    private ListView<String> lvFahrzeuge;
    //in der lvKunden werden die Variablen der Objekte der ArrayList kunden abgebildet
    @FXML
    private ListView<String> lvKunden;
    //in der lvVermietungen werden die Variablen der Objekte der ArrayList vermietungen abgebildet
    @FXML
    private ListView<String> lvVermietungen;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //überprüft, ob bereits Objekte in der ArrayList fahrzeuge sind
        if(App.getFahrzeuge() != null){
            //füllt die ListView lvFahrzeuge mit den Variablen der verschiedenen Objekte in der ArrayList fahrzeuge
            for(FahrzeugModel f : App.getFahrzeuge()){
                 lvFahrzeuge.getItems().add(f.getTyp() + " " + f.getHersteller() + " " + f.getModell() + " " + f.getFarbe() + " " + f.getKennzeichen() + " " + f.getStundenkosten() + " " + f.getFahrzeugnummer() + " " + f.getInBenutzung() + " " + f.getInReparatur());
            }
            //füllt die ListView lvKunden mit den Variablen der verschiedenen Objekte in der ArrayList kunden
            for(KundeModel k : App.getKunden()){
                lvKunden.getItems().add(k.getKundenTyp() + " " + k.getVorname() + " " + k.getNachname() + " " + k.getGeburtsdatum() + " " + k.getGeburtsort());
            }
            //füllt die ListVIew lvVermietungen mit den Variablen der verschiedenen Objekte in der ArrayList vermietungen
            for(VermietungModel v : App.getVermietungen()){
                //setzt den Formatter format auf das Pattern "dd-MM-yyyy HH:mm"
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                //setzt die Strings temp1 und temp2 auf Start- und Enddatum im neuen Format
                String temp1 = v.getStartDatum().format(format);
                String temp2 = v.getEndDatum().format(format);
                lvVermietungen.getItems().add("Startdatum: " + temp1 + " // Enddatum: " + temp2 + " // Fahrzeugtyp: " + v.getFahrzeug().getTyp() + " // Modell: " + v.getFahrzeug().getModell() + " // Kunde: " + v.getKunde().getVorname()+ " " + v.getKunde().getNachname());
            }
        }
    } 
    
      
        
    //definiert die Buttons um in die verschiedenen Views zu gelangen
    @FXML
    private void btnToKundenDetail(ActionEvent event) throws IOException {
        App.setRoot("kundeView");
    }

    @FXML
    private void btnToFahrzeugDetail(ActionEvent event) throws IOException {
        App.setRoot("fahrzeugView");
    }

    @FXML
    private void btnToVermietungenDetail(ActionEvent event) throws IOException {
        App.setRoot("vermietungView");
    }

}
