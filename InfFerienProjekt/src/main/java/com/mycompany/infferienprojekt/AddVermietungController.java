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
import java.time.Duration;

public class AddVermietungController implements Initializable {

    //definiert die ListViews, in denen man den Kunden und das Fahrzeug auswählen kann, den man in der neuen Vermietung nutzen möchte
    @FXML
    private ListView<String> lvFahrzeugAuswahl;
    @FXML
    private ListView<String> lvKundeAuswahl;
    
    //definiert die DatePicker, um Start- und Enddatum festlegen zu können
    @FXML
    private DatePicker dpStartDatum;
    @FXML
    private DatePicker dpEndDatum;
    
    //definiert die ChoiceBoxen, um die Uhrzeit festlegen zu können
    @FXML
    private ChoiceBox<String> choiceZeitStart;
    @FXML
    private ChoiceBox<String> choiceZeitEnde;
    
    //definiert die LocalTimes TS und TE für TimeStart und TimeEnde
    LocalTime TS;
    LocalTime TE;
    
    //definiert das FahrzeugModel selFahrzeug und das KundeModel selKunde
    FahrzeugModel selFahrzeug;
    KundeModel selKunde;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ruft fillChoiceBox auf
        fillChoiceBox();
        //ruft fillListVIew auf
        fillListView();
    }    
    //definiert den button um in die mainView zu gelangen
    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
    }
    @FXML
    private void btnAddVermietung(ActionEvent event) {
        
        //holt sich die Start. und Endzeit aus den choiceBoxen choiceZeitStart und choiceStartEnde
        choiceToDateStart();
        choiceToDateEnde();
        
        //kombiniert das Startdatum mit der Startzeit und das Enddatum mit der Endzeit um temp1 und temp2 zu bilden
        LocalDateTime temp1 = LocalDateTime.of(dpStartDatum.getValue(), TS) ; 
        LocalDateTime temp2 = LocalDateTime.of(dpEndDatum.getValue(), TE);
        
        //definiert die Duration duration als Zeitabstand zwischen Start- und EndLocalDateTime
        Duration duration = Duration.between(temp1, temp2);
        
        //konvertiert den int Dauer ins Stundenformat
        int Dauer = (int) duration.toHours();
        
        //fügt der ArrayList vermietungen eine neue Vermietung hinzu
        App.vermietungen.add(new VermietungModel(temp1, temp2, selKunde, selFahrzeug, Dauer, Dauer * selFahrzeug.getStundenkosten()));
        System.out.println("neue Vermietung erstellt");
    }
    
    //definiert selFahrzeug, also das Fahrzeug, welches in der ArrayList am Platz des in der ListView ausgewählten Objektes ist
    @FXML
    private void selFahrzeug(MouseEvent event) {
       int temp4 = lvFahrzeugAuswahl.getSelectionModel().getSelectedIndex();
       selFahrzeug = App.fahrzeuge.get(temp4);
       
    }

    //definiert selKunde, also den Kunden, welches in der ArrayList am Platz des in der ListView ausgewählten Objektes ist
    @FXML
    private void selKunde(MouseEvent event) {
        int temp4 = lvKundeAuswahl.getSelectionModel().getSelectedIndex();
        selKunde = App.kunden.get(temp4);
    }

    //füllt die ChoiceBoxen choiceZeitStart und choiceZeitEnde mit Strings, die Tageszeiten darstellen
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
        
        //füllt die ListView lvFahrzeuge mit den Variablen der verschiedenen Objekte in der ArrayList fahrzeuge
        for(FahrzeugModel f : App.getFahrzeuge()){
            lvFahrzeugAuswahl.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
        }
        //füllt die ListView lvKunden mit den Variablen der verschiedenen Objekte in der ArrayList kunden
        for(KundeModel k : App.getKunden()){
            
            //überprüft, ob der Kundentyp "Geschäftskunde" ist
            if(k.getKundenTyp().equals("Geschäftskunde")){
                     
                    //definiert, dass g in diesem Fall gleich k ist
                    GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                    
                    //fügt die Variablen des GeschaeftsKundeModel g zur ListView hinzu
                    lvKundeAuswahl.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());
            }
            //überprüft, ob der Kundentyp "Privatkunde" ist
            else if(k.getKundenTyp().equals("Privatkunde")){
                     
                        //definiert, dass p in diesem Fall gleich k ist
                         PrivatKundeModel p = (PrivatKundeModel) k;
                         
                         //fügt die Variablen des PrivatKundeModel p zur ListView hinzu
                         lvKundeAuswahl.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
            }
        }
    }
    
    //setzt die LocalTime von TS entsprechend der Auswahl in choiceZeitStart
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
  
    //setzt die LocalTime von TE entsprechend der Auswahl in choiceZeitEnde
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
