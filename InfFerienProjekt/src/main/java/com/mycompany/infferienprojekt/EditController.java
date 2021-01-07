package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditController implements Initializable {

    //definiert die ListView lvEditChoice, in der alle Daten jedes Objektes, was man ändern möchte angezeigt werden können
    @FXML
    private ListView<String> lvEditChoice;
    
    //definiert das Textfeld txtEdit, in der der Großteil der änderungen vorgenommen werden
    @FXML
    private TextField txtEdit;
    
    //definiert die CheckBox checkBoxEdit, in der alle Variablen verändert werden, die einen boolean benötigen
    @FXML
    private CheckBox checkBoxEdit;
    
    //definiert das Label, in der der Text über dem TextField steht
    @FXML
    private Label labelEdit;
    
    //definiert den DatePicker dpEdit für änderungen am Start- oder Enddatum einer Miete
    @FXML
    private DatePicker dpEdit;
    
    //definiert die ChoiceBox choiceTime, in der man beim bearbeiten der Miete die Zeit auswählen muss
    @FXML
    private ChoiceBox<String> choiceTime;
    
    //definiert den button, sodass er disabled werden kann
    @FXML
    private Button confirmEdit;
    
    //definiert die LocalTime T, die in choiceDateEdit genutzt wird, um die in choiceTime ausgewählte Zeit als echte Zeit zu speichern
    LocalTime T;
    
    //definiert den int indexInLv um den zuletzt ausgewählten Index zu speichern
    int indexInLv;
    
    //erstellt fahz, gKunde, pKunde und verm, in ihnen wird das Objekt, was man verändert und die Änderungen daran gespeichert. In btnHome wird das entspechende Objekt aus der ArrayList entfernt und stattdessen wird das veränderte hinzugefügt
    FahrzeugModel fahrz;
    GeschaeftsKundeModel gKunde;
    PrivatKundeModel pKunde;
    VermietungModel verm;
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //initialisiert fahrz, gKunde, pKunde und verm 
        fahrz = FahrzeugController.selectedFahrzeug;
        if(KundeController.selectedKunde != null)
            switch(KundeController.selectedKunde.getKundenTyp()){
                case "Geschäftskunde":
                    gKunde = (GeschaeftsKundeModel) KundeController.selectedKunde;
                break;

                case "Privatkunde":
                    pKunde = (PrivatKundeModel) KundeController.selectedKunde;
                break;
            }
        verm = VermietungController.selectedVermietung;
        
        //ruft showtextField, fillListView und fillChoiceEdit auf
        showTextField();
        fillListView();
        fillChoiceEdit();
    }    

    //definiert, was passiert, wenn man die ListView anclickt
    @FXML
    private void selDone(MouseEvent event) {
        
        //setzt den button auf nutzbar
        confirmEdit.setDisable(false);
        
        //setzt das TextField auf bearbeitbar
        txtEdit.setEditable(true);
        
        //initalisiert indexInLv, welcher den Index des zuletzt ausgewählten Objektes speichert
        indexInLv = lvEditChoice.getSelectionModel().getSelectedIndex();
        
        //ruft showTextField auf
        showTextField();
        
        //ruft den Wert der Variable ListViewModus auf
        switch(App.getListViewModus()){
            
            //überprüft, ob sich die ListView im Modus "Vermietung" befindet
            case "Vermietung":
                
                //ruft den Wert der Variable OriginTyp auf
                switch(App.getOriginTyp()){
                    
                    //überprüft, ob der OriginTyp "Fahrzeug" ist
                    case "Fahrzeug": 
                        
                        //überprüft, welcher Index als letztes angeclickt wurde
                        switch(indexInLv){
                            
                            //setzt den Text im Textfeld/in der CheckBox und im Label entsprechend dem Inhalt des jeweiligen Indexes
                            case 0: 
                                labelEdit.setText("Hersteller:");
                                txtEdit.setText(fahrz.getHersteller());
                            break;

                            case 1: 
                                labelEdit.setText("Modell:");
                                txtEdit.setText(fahrz.getModell());
                            break;

                            case 2: 
                                labelEdit.setText("Farbe:");
                                txtEdit.setText(fahrz.getFarbe());
                            break;

                            case 3: 
                                labelEdit.setText("Kennzeichen:");
                                txtEdit.setText(fahrz.getKennzeichen());
                            break;

                            case 4: 
                                labelEdit.setText("Fahrzeugtyp, nicht änderbar!");
                                txtEdit.setText(fahrz.getTyp());
                                txtEdit.setEditable(false);
                                confirmEdit.setDisable(true);
                            break;

                            case 5: 
                                labelEdit.setText("Fahrzeugnummer:");
                                //konvertiert den int Fahrzeugnummer in einen String
                                String temp1 = fahrz.getFahrzeugnummer() + "";
                                txtEdit.setText(temp1);
                            break;

                            case 6: 
                                labelEdit.setText("");
                                showCheckBox();
                                checkBoxEdit.setText("In Reparatur");
                                checkBoxEdit.setSelected(fahrz.getInReparatur());
                            break;

                            case 7: 
                                labelEdit.setText("");
                                showCheckBox();
                                checkBoxEdit.setText("In Benutzung");
                                checkBoxEdit.setSelected(fahrz.getInBenutzung());
                            break;

                            case 8:
                                labelEdit.setText("Stundenkosten:");
                                String temp2 = fahrz.getStundenkosten() + "";
                                txtEdit.setText(temp2);
                            break;
                        }    
                    break;
                    
                    //überprüft, ob der OriginTyp "GeschaeftsKunde" ist
                    case "GeschaeftsKunde": 
                        
                        //überprüft, welcher Index als letztes angeclickt wurde
                        switch(indexInLv){
                            
                            //setzt den Text im Textfeld und im Label entsprechend dem Inhalt des jeweiligen Indexes
                            case 0: 
                                labelEdit.setText("Vorname:");
                                txtEdit.setText(gKunde.getVorname());
                            break;

                            case 1: 
                                labelEdit.setText("Nachname:");
                                txtEdit.setText(gKunde.getNachname());
                            break;

                            case 2: 
                                labelEdit.setText("Geburtsort:");
                                txtEdit.setText(gKunde.getGeburtsort());
                            break;

                            case 3: 
                                labelEdit.setText("Geburtsdatum:");
                                txtEdit.setText(gKunde.getGeburtsdatum());
                            break;

                            case 4: 
                                labelEdit.setText("Kundentyp, nicht änderbar!");
                                txtEdit.setText(gKunde.getKundenTyp());
                                txtEdit.setEditable(false);
                                confirmEdit.setDisable(true);
                            break;

                            case 5: 
                                labelEdit.setText("Arbeitsadresse:");
                                txtEdit.setText(gKunde.getArbeitsAdresse());
                            break;

                            case 6: 
                                labelEdit.setText("Arbeitstelefonnummer:");
                                txtEdit.setText(gKunde.getArbeitsTelefonnummer());
                            break;
                        }
                    break;
                    
                    //überprüft, ob der OriginTyp "PrivatKunde" ist
                    case "PrivatKunde": 
                        
                        //überprüft, welcher Index als letztes angeclickt wurde
                        switch(indexInLv){
                            
                            //setzt den Text im Textfeld und im Label entsprechend dem Inhalt des jeweiligen Indexes
                            case 0: 
                                labelEdit.setText("Vorname:");
                                txtEdit.setText(pKunde.getVorname());
                            break;

                            case 1: 
                                labelEdit.setText("Nachname:");
                                txtEdit.setText(pKunde.getNachname());
                            break;

                            case 2: 
                                labelEdit.setText("Geburtsort:");
                                txtEdit.setText(pKunde.getGeburtsort());
                            break;

                            case 3: 
                                labelEdit.setText("Geburtsdatum:");
                                txtEdit.setText(pKunde.getGeburtsdatum());
                            break;

                            case 4: 
                                labelEdit.setText("Kundentyp, nicht änderbar!");
                                txtEdit.setText(pKunde.getKundenTyp());
                                txtEdit.setEditable(false);
                                confirmEdit.setDisable(true);
                            break;

                            case 5: 
                                labelEdit.setText("Sicherheitskontakt:");
                                txtEdit.setText(pKunde.getSicherheitsKontakt());
                            break;
                        }
                    break;
                    
                    //überprüft, ob der OriginTyp "Vermietung" ist
                    case "Vermietung":
                        
                        //überprüft, welcher Index als letztes angeclickt wurde
                        switch(indexInLv){
                            
                            //setzt den Text im TextField und Label entspechend dem Inhalt des jeweiligen Indexes
                            case 0: 
                                dpEdit.setValue(null);
                                showDatePicker();
                                labelEdit.setText("Startdatum:");
                                dpEdit.setValue(verm.getStartDatum().toLocalDate());
                                
                            break;

                            case 1: 
                                dpEdit.setValue(null);
                                showDatePicker();
                                labelEdit.setText("Enddatum:");
                                dpEdit.setValue(verm.getEndDatum().toLocalDate());
                            break;

                            case 2: 
                                labelEdit.setText("wählen sie einen anderen Kunden aus");
                                //ruft showKundenInView auf, um den Modus der ListView zu Kunden zu ändern
                                showKundenInView();
                                txtEdit.setText(verm.getKunde().getVorname() + " " + verm.getKunde().getNachname());
                            break;

                            case 3: 
                                labelEdit.setText("wählen sie ein anderes Fahrzeug aus");
                                //ruft showFahrzeugeInView auf, um den Modus der ListView zu Fahrzeuge zu ändern
                                showFahrzeugeInView();
                                txtEdit.setText(verm.getFahrzeug().getHersteller() + " " + verm.getFahrzeug().getModell());
                            break;

                            case 4: 
                                labelEdit.setText("Dauer, nicht änderbar!");
                                //Konvertiert den double Duration in einen String
                                txtEdit.setText(verm.getDuration()+ "");
                                //setzt das TextField auf nicht bearbeitbar
                                txtEdit.setEditable(false);
                                confirmEdit.setDisable(true);
                            break;

                            case 5: 
                                labelEdit.setText("Kosten, nicht änderbar!");
                                //Konvertiert den double Kosten in einen String
                                txtEdit.setText(verm.getKosten() + "€");
                                //setzt das TextField auf nicht bearbeitbar
                                txtEdit.setEditable(false);
                                confirmEdit.setDisable(true);
                            break;
                        }
                    break;
                } 
            break;
            
            //überprüft, ob sich die ListView im Modus "Kunden" befindet
            case "Kunden":
                
                //löscht den Text im TextField
                txtEdit.clear();
                
                //löscht den Text im Label
                labelEdit.setText("");
                
                //setzt den Kunden in verm auf den Kunden, der in lvEditChoice im Modus "Kunden" ausgewählt wurde
                verm.setKunde(App.getKunden().get(indexInLv));
                
                //setzt den ListViewModus auf "Vermietung" um die ListVIew wieder mit den Eigenschaften der ausgewählten Vermietung zu füllen
                App.setListViewModus("Vermietung");
                
                //ruft fillListView auf
                fillListView();
            break;
            //überprüft, ob sich die ListView im Modus "Fahrzeuge" befindet
            case "Fahrzeuge":
                
                //löscht den Text im TextField
                txtEdit.clear();
                
                //löoscht den Text im Label
                labelEdit.setText("");
                
                //setzt das Fahrzeug in verm auf das Fahrzeug, das in lvEditChoice im Modus "Fahrzeuge" ausgewählt wurde
                verm.setFahrzeug(App.getFahrzeuge().get(indexInLv));
                
                //setzt den ListViewModus auf "Vermietung" um die ListVIew wieder mit den Eigenschaften der ausgewählten Vermietung zu füllen
                App.setListViewModus("Vermietung");
                
                //ruft fillListView auf
                fillListView();
                
            break;
        }
    }
    
    //zeigt das TextField txtEdit, macht es bearbeitbar und setzt es in den Vordergrund, das Gegenteil bei allen anderen Auswahl- oder Edit-Feldern
    private void showTextField(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(1);
        txtEdit.setDisable(false);
        txtEdit.toFront();
        dpEdit.setOpacity(0);
        dpEdit.setDisable(true);
        dpEdit.toBack();
        choiceTime.setOpacity(0);
        choiceTime.setDisable(true);
        choiceTime.toBack();
    }
    
    //zeigt die CheckBox checkBoxEdit, macht sie bearbeitbar und setzt sie in den Vordergrund, das Gegenteil bei allen anderen Auswahl- oder Edit-Feldern
    private void showCheckBox(){
        checkBoxEdit.setOpacity(1);
        checkBoxEdit.setDisable(false);
        checkBoxEdit.toFront();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        dpEdit.setOpacity(0);
        dpEdit.setDisable(true);
        dpEdit.toBack();
        choiceTime.setOpacity(0);
        choiceTime.setDisable(true);
        choiceTime.toBack();
    }
    
    //zeigt den DatePicker dpEdit und die ChoiceBox choiceTime, macht sie bearbeitbar und setzt sie in den Vordergrund, das Gegenteil bei allen anderen Auswahl- oder Edit-Feldern
    private void showDatePicker(){
        checkBoxEdit.setOpacity(0);
        checkBoxEdit.setDisable(true);
        checkBoxEdit.toBack();
        txtEdit.setOpacity(0);
        txtEdit.setDisable(true);
        txtEdit.toBack();
        dpEdit.setOpacity(1);
        dpEdit.setDisable(false);
        dpEdit.toFront();
        choiceTime.setOpacity(1);
        choiceTime.setDisable(false);
        choiceTime.toFront();
    }

    @FXML
    private void btnEditDone(ActionEvent event) {
        
        //ruft den Wert der Variable OriginTyp auf
        switch(App.getOriginTyp()){
            
            //überprüft, ob der OriginTyp "Fahrzeug" ist
            case "Fahrzeug":
                
                //überprüft, welcher Index als letztes angeclickt wurde
                switch(indexInLv){
                    
                    //verändert die ausgeweählten Werte, die man verändert hat in fahrz
                    case 0: 
                        fahrz.setHersteller(txtEdit.getText());
                    break;

                    case 1: 
                        fahrz.setModell(txtEdit.getText());
                    break;

                    case 2: 
                        fahrz.setFarbe(txtEdit.getText());

                    break;

                    case 3: 
                        fahrz.setKennzeichen(txtEdit.getText());

                    break;

                    case 4: 
                        //hier steht nichts, weil man FahrzeugTyp nicht ändern kann
                    break;

                    case 5: 
                        //konvertiert den String, den man aus dem Textfeld bekommt in einen int
                        int temp1 = Integer.parseInt(txtEdit.getText());
                        fahrz.setFahrzeugnummer(temp1);
                    break;

                    case 6: 
                        fahrz.setInReparatur(checkBoxEdit.isSelected());
                    break;

                    case 7: 
                        fahrz.setInBenutzung(checkBoxEdit.isSelected());
                    break;

                    case 8: 
                        //konvertiert den String, den man aus dem Textfeld bekommt in einen double
                        double temp2 = Double.parseDouble(txtEdit.getText());
                        fahrz.setStundenkosten(temp2);
                    break;
                }
               
            break;
            
            //überprüft, ob der OriginTyp "GeschaeftsKunde" ist
            case "GeschaeftsKunde":
                
                //überprüft, welcher Index als letztes angeclickt wurde
                switch(indexInLv){
                    
                    //verändert die ausgewählten Werte, die man verändert hat in gKunde
                    case 0:
                        gKunde.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        gKunde.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        gKunde.setGeburtsort(txtEdit.getText());
                    break;
                    
                    case 3:
                        gKunde.setGeburtsdatum(txtEdit.getText());
                    break;
                    
                    case 4: 
                        //hier steht nichts, weil man den KundenTyp nicht verändern kann
                    break;
                    
                    case 5:
                        gKunde.setArbeitsAdresse(txtEdit.getText());
                    break;
                    
                    case 6:
                        gKunde.setArbeitsTelefonnummer(txtEdit.getText());
                    break;
                }
            break; 
            
            //überprüft, ob der OriginTyp "PrivatKunde" ist
            case "PrivatKunde":
                
                //überprüft, welcher Index als letztes angeclickt wurde
                switch(indexInLv){
                    
                    //verändert die ausgewählten Werte, die man verändert hat in pKunde
                    case 0:
                        pKunde.setVorname(txtEdit.getText());
                    break;
                    
                    case 1:
                        pKunde.setNachname(txtEdit.getText());
                    break;
                    
                    case 2:
                        pKunde.setGeburtsort(txtEdit.getText());
                    break;
                        
                    case 3:
                        pKunde.setGeburtsdatum(txtEdit.getText());
                    break;
                    
                    case 4:
                       //hier steht nichts, weil man den KundenTyp nicht verändern kann
                    break;
                    
                    case 5:
                        pKunde.setSicherheitsKontakt(txtEdit.getText());
                    break;
                }
            break; 
            
            //überprüft, ob der OriginTyp "Vermietung" ist
            case "Vermietung":
                
                //überprüft, in welchem Modus sich die ListView befindet
                switch(App.getListViewModus()){
                    
                    //überprüft, ob sich die ListView im Modus "Vermietung" befindet
                    case "Vermietung":
                        
                        //ruft choiceDateEdit auf
                        choiceDateEdit();
                        
                        //definiert die LocalDateTime temp1, die das Datum aus dpEdit und die Zeit aus choiceTime erhält
                        LocalDateTime temp1 = LocalDateTime.of(dpEdit.getValue(), T) ; 
                        
                        //überprüft, welcher Index als letztes angeclickt wurde
                        switch(indexInLv){
                            
                            //führt den Block aus, der dem ausgewählten Index entspricht
                            case 0:
                                //ruft showDatePicker auf
                                showDatePicker();
                                
                                //setzt das StartDatum von verm auf temp1
                                verm.setStartDatum(temp1);
                                
                                //definiert die Duration duration1 zwischen dem Start- und Enddatum von verm
                                Duration duration1 = Duration.between(verm.getStartDatum(), verm.getEndDatum());
                                
                                //konvertiert den int Dauer1 in Stunden
                                int Dauer1 = (int) duration1.toHours();
                                
                                //setzt die Duration von verm auf Dauer1
                                verm.setDuration(Dauer1);
                                
                                //rechnet die Kosten aus, indem er die Duration von verm mit den Stundenkosten des Fahrzeuges von verm multipliziert
                                verm.setKosten(verm.getDuration()*verm.getFahrzeug().getStundenkosten());
                            break;

                            case 1:
                                //ruft showDatePicker auf
                                showDatePicker();
                                
                                //setzt das EndDatum von verm auf temp1
                                verm.setEndDatum(temp1);
                                
                                //definiert die Duration duration2 zwischen dem Start- und Enddatum von verm
                                Duration duration2 = Duration.between(verm.getStartDatum(), verm.getEndDatum());
                                
                                //konvertiert den int Dauer2 in Stunden
                                int Dauer2 = (int) duration2.toHours();
                                
                                //setzt die Duration von verm auf Dauer2
                                verm.setDuration(Dauer2);
                                
                                //rechnet die Kosten aus, indem er die Duration von verm mit den Stundenkosten des Fahrzeuges von verm multipliziert
                                verm.setKosten(verm.getDuration()*verm.getFahrzeug().getStundenkosten());
                            break;

                            case 2:
                                //setzt den Modus der ListView auf "Kunden"
                                App.setListViewModus("Kunden");
                            break;

                            case 3:
                                //setzt den Modus der ListVIew auf "Fahrzeuge"
                                App.setListViewModus("Fahrzeuge");
                            break;   
                        }
                    break;
                    
                    //überprüft, ob sich die ListView im Modus "Kunden" befindet
                    case "Kunden":
                        
                        //füllt die ListView mit den Werten der Variablen der Objekte in der ArrayList kunden
                        for(KundeModel k : App.getKunden()){
                            lvEditChoice.getItems().add("Kundentyp: " + k.getKundenTyp() + " // Vorname: " + k.getVorname() + " // Nachname: " + k.getNachname() + " // Geburtsort: " + k.getGeburtsort() + " Geburtsdatum: " + k.getGeburtsdatum());   
                 }
                    break;
                    
                    //überprüft, ob sich die ListView im Modus "Fahrzeuge" befindet
                    case "Fahrzeuge":
                        
                        //füllt die ListView mit den Werten der Variablen der Objekte in der ArrayList fahrzeuge
                        for(FahrzeugModel f : App.getFahrzeuge()){
                        lvEditChoice.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
                        }
                    break;
            
                    
                }
        }
        //löscht den Text im Label
        labelEdit.setText("");
        
        //rufe fillListView auf
        fillListView();
        
        //löscht den Text im TextField
        txtEdit.clear();
    }

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainView");
        
        //ersetzt das im vorherigen Controller ausgewählte Objekt in einer ArrayList mit der veränderten Version fahrz, gKunde, pKunde oder verm
        if(fahrz != null){
            App.fahrzeuge.remove(FahrzeugController.selFahrzeugIndex);
            App.fahrzeuge.add(FahrzeugController.selFahrzeugIndex, fahrz);
        }
        if(gKunde != null){
            App.kunden.remove(KundeController.selKundeIndex);
            App.kunden.add(KundeController.selKundeIndex, gKunde);
        }
        if(pKunde != null){
            App.kunden.remove(KundeController.selKundeIndex);
            App.kunden.add(KundeController.selKundeIndex, pKunde);
        }
        if(verm != null){
            App.vermietungen.remove(VermietungController.selVermietungIndex);
            App.vermietungen.add(VermietungController.selVermietungIndex, verm);
        }
        //setzt den Modus der ListView auf "Vermietung"
        App.setListViewModus("Vermietung");
    }
    
    private void fillListView(){
        
        //löscht alle Strings in der ListView
        lvEditChoice.getItems().clear();
        
        //ruft den Wert der Variable OriginTyp auf
        switch (App.getOriginTyp()) {
            
            //überprüft, ob der OriginTyp "Vermietung" ist
            case "Vermietung":
                
                //überprüft, in welchem Modus sich die ListView befindet
                switch(App.getListViewModus()){
                    
                    //überprüft, ob sich die ListView im Modus "Vermietung" befindet
                    case "Vermietung":
                        
                        //setzt den Formatter format auf das Pattern "dd-MM-yyyy HH:mm"
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                        
                        //setzt die Strings temp1 und temp2 auf Start- und Enddatum im neuen Format
                        String temp1 = verm.getStartDatum().format(format);
                        String temp2 = verm.getEndDatum().format(format);
                        
                        //fügt Start- und Enddatum zur ListView hinzu
                        lvEditChoice.getItems().add("Startdatum: " + temp1);
                        lvEditChoice.getItems().add("Enddatum : " + temp2);
                        
                        //überprüft, ob der Kunde in verm ein Geschäfts- oder Privatkunde ist
                        if(verm.getKunde().getKundenTyp().equals("Geschäftskunde")){
                            
                            //definiert, dass g in diesem Fall gleich verm.getKunde ist
                            GeschaeftsKundeModel g = (GeschaeftsKundeModel) verm.getKunde();
                            
                            //fügt der ListView den Geschäftskunden von verm hinzu
                            lvEditChoice.getItems().add(" // KUNDE // " + " Kundentyp: " + g.getKundenTyp() + " / Vorname: " + g.getVorname() + " / Nachname: " + g.getNachname() + " / Geburtsdatum: " + g.getGeburtsdatum());
                        }
                        else  if(verm.getKunde().getKundenTyp().equals("Privatkunde")){
                            
                            //definiert, dass p in diesem Fall gleich verm.getKunde ist
                            PrivatKundeModel p = (PrivatKundeModel) verm.getKunde();
                            
                            //fügt der ListView den Privatkunden von verm hinzu
                            lvEditChoice.getItems().add(" // KUNDE // " + " Kundentyp: " + p.getKundenTyp() + "/ Vorname: " + p.getVorname() + " / Nachname: " + p.getNachname() + " / Geburtsdatum: " + p.getGeburtsdatum());
                        }   
                        FahrzeugModel Z = verm.getFahrzeug();
                        
                        //fügt der ListView das Fahrzeug von verm hinzu
                        lvEditChoice.getItems().add(" // FAHRZEUG // " +  " Fahrzeugtyp: " + Z.getTyp() + " / Fahrzeug: " + Z.getHersteller() + " / Modell: " + Z.getModell() + " / Farbe: " + Z.getFarbe());
                        
                        //fügt der ListView die Dauer und die Kosten von verm hinzu
                        lvEditChoice.getItems().add("Dauer: " + verm.getDuration() + " Stunden");
                        lvEditChoice.getItems().add("Kosten: " + verm.getKosten() + "€");
                    break;
                    
                    //überprüft, ob sich die ListView im Modus "Kunden" befindet
                    case "Kunden":
                        
                            //füllt die ListView mit den Werten der Variablen der Objekte in der ArrayList kunden
                            for(KundeModel k : App.getKunden()){
                                
                            //überprüft, ob der Kundentyp eines Objektes in der ArrayList "Geschäftskunde" ist
                             if(k.getKundenTyp().equals("Geschäftskunde")){
                                 
                                 //definiert, dass g in diesem Fall gleich k ist
                                GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                                lvEditChoice.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());
                                 }
                             
                             //überprüft, ob der Kundentyp eines Objektes in der ArrayList "Privatkunde" ist
                             else if(k.getKundenTyp().equals("Privatkunde")){
                                 
                                    //definiert, dass p in diesem Fall gleich k ist
                                     PrivatKundeModel p = (PrivatKundeModel) k;
                                     lvEditChoice.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
                                 }
                             }
                    break;
                    
                    //überprüft, ob sich die ListView im Modus "Fahrzeuge" befindet
                    case "Fahrzeuge":
                        
                            //füllt die ListView mit den Werten der Variablen der Objekte aus der ArrayList fahrzeuge 
                            for(FahrzeugModel f : App.getFahrzeuge()){
                                lvEditChoice.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + "€ // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
                           }
                    break;
                }
            break;
            //überprüft, ob der OriginTyp "GeschaeftsKunde" ist
            case "GeschaeftsKunde":

                //ruft alle Werte von gKunde auf und fügt sie zur ListView hinzu
                lvEditChoice.getItems().add(gKunde.getVorname());
                lvEditChoice.getItems().add(gKunde.getNachname());
                lvEditChoice.getItems().add(gKunde.getGeburtsort());
                lvEditChoice.getItems().add(gKunde.getGeburtsdatum());
                lvEditChoice.getItems().add(gKunde.getKundenTyp());
                lvEditChoice.getItems().add(gKunde.getArbeitsAdresse());
                lvEditChoice.getItems().add(gKunde.getArbeitsTelefonnummer());
            break;
                
            //überprüft, ob der OriginTyp "PrivatKunde" ist
            case "PrivatKunde":
                
                //ruft alle Werte von pKunde ab und fügt sie zur ListView hinzu
                lvEditChoice.getItems().add(pKunde.getVorname());
                lvEditChoice.getItems().add(pKunde.getNachname());
                lvEditChoice.getItems().add(pKunde.getGeburtsort());
                lvEditChoice.getItems().add(pKunde.getGeburtsdatum());
                lvEditChoice.getItems().add(pKunde.getKundenTyp());
                lvEditChoice.getItems().add(pKunde.getSicherheitsKontakt());
            break;
            
            //überprüft, ob der OriginTyp "Fahrzeug" ist
            case "Fahrzeug":
                //konvertiert int, booleans und double in Strings
                String temp7 = fahrz.getFahrzeugnummer() + "";
                String temp8 = fahrz.getInReparatur() + "";
                String temp9 = fahrz.getInBenutzung() + "";
                String temp10 = fahrz.getStundenkosten() + "€";
                //ruft alle Werte von fahrz ab und fügt sie zur ListView hinzu
                lvEditChoice.getItems().add("Hersteller: " + fahrz.getHersteller());
                lvEditChoice.getItems().add("Modell: " + fahrz.getModell());
                lvEditChoice.getItems().add("Farbe: " + fahrz.getFarbe());
                lvEditChoice.getItems().add("Kennzeichen: " + fahrz.getKennzeichen());
                lvEditChoice.getItems().add("Fahrzeugtyp: " + fahrz.getTyp());
                lvEditChoice.getItems().add("Fahrzeugnummer: " + temp7);
                lvEditChoice.getItems().add("In Reparatur: " + temp8);
                lvEditChoice.getItems().add("In Benutzung: " + temp9);
                lvEditChoice.getItems().add("Stundenkosten: " + temp10);
            break;
            default:
                break;
        }
    }
    
    private void fillChoiceEdit(){
        
        //fügt die Strings zur ChoiceBox choiceTime hinzu, die die Uhrzeit darstellen
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
        
        //holt sich den Wert aus choiceTime und setzt die LocalTime entsprechend
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
        
        //löscht alle Strings in der ListView 
        lvEditChoice.getItems().clear();
        
        //füllt die ListView mit den Werten der Variablen der Objekte in der ArrayList fahrzeuge
        for(FahrzeugModel f : App.getFahrzeuge()){
            lvEditChoice.getItems().add("Fahrzeugtyp: " + f.getTyp() + " // Hersteller: " + f.getHersteller() + " // Modell: " + f.getModell() + " // Farbe: " + f.getFarbe() + " // Kennzeichen: " + f.getKennzeichen() + " // Stundenkosten: " + f.getStundenkosten() + " // Nummer: " + f.getFahrzeugnummer() + " // In Benutzung: " + f.getInBenutzung() + " // In Reparatur: " + f.getInReparatur());
        }
        //setzt den Modus der ListView auf "Fahrzeuge"
        App.setListViewModus("Fahrzeuge");
    }
    
    private void showKundenInView(){
        
                //löscht alle Strings in der ListView
                 lvEditChoice.getItems().clear();
                 
                 //füllt die ListView mit den Werten der Variablen der Objekte in der ArrayList kunden
                 for(KundeModel k : App.getKunden()){
                     
                     //überprüft, welcher Typ der Kunde in der ArrayList ist
                     switch(k.getKundenTyp()){
                         
                         //überprüft, ob der Kunde ein Geschäftskunde ist
                         case "Geschäftskunde":
                             
                             //legt fest, dass g in diesem Fall gleich k ist
                            GeschaeftsKundeModel g = (GeschaeftsKundeModel) k;
                            lvEditChoice.getItems().add("Kundentyp: " + g.getKundenTyp() + " // Vorname: " + g.getVorname() + " // Nachname: " + g.getNachname() + " // Geburtsort: " + g.getGeburtsort() + " Geburtsdatum: " + g.getGeburtsdatum() + " // Arbeitsadresse: " + g.getArbeitsAdresse() + " // Arbeitstelefonnummer: " + g.getArbeitsTelefonnummer());   
                        break;
                            
                        //überprüft, ob der Kunde ein Privatkunde ist
                        case "Privatkunde":          
                            
                            //legt fest, dass p in diesem Fall gleich k ist
                            PrivatKundeModel p = (PrivatKundeModel) k;
                            lvEditChoice.getItems().add("Kundentyp: " + p.getKundenTyp() + " // Vorname: " + p.getVorname() + " // Nachname: " + p.getNachname() + " // Geburtsort: " + p.getGeburtsort() + " Geburtsdatum: " + p.getGeburtsdatum() + " // Sicherheitskontakt: " + p.getSicherheitsKontakt());
                        break;
                     }
                     
                }
                 //setzt den Modus der ListView auf "Kunden"
                 App.setListViewModus("Kunden");
        }
    
}
