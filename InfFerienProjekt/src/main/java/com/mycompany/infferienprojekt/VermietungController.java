/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class VermietungController implements Initializable {

    @FXML
    private ListView<String> lvVermietungDetail;
    
    public static VermietungModel selectedVermietung;
    
    String typ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(App.vermietungen != null){
            for(VermietungModel v : App.getVermietungen()){
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String temp1 = v.getStartDatum().format(format);
                String temp2 = v.getEndDatum().format(format);
                
                lvVermietungDetail.getItems().add("Startdatum: " + temp1 + " // Enddatum: " + temp2 + " // Fahrzeugtyp: " + v.getFahrzeug().getTyp() + " // Modell: " + v.getFahrzeug().getModell() + " // Farbe: " + v.getFahrzeug().getFarbe() + " // Kunde: " + v.getKunde().getVorname()+ " " + v.getKunde().getNachname() + " // Kundentyp: " + v.getKunde().getKundenTyp());
            }
        }
        else{
            System.out.println("Es können noch keine Vermietungen abgebildet werden");
        }
    }    

    @FXML
    private void btnAddVermietung(ActionEvent event) throws IOException {
        App.setRoot("addVermietungView");
    }

    @FXML
    private void btnEditVermietung(ActionEvent event) throws IOException {
        int temp1 = lvVermietungDetail.getSelectionModel().getSelectedIndex();
        selectedVermietung = App.vermietungen.get(temp1);
        App.setOriginTyp("Vermietung");
        
        App.setRoot("editView");
    }

    

    @FXML
    private void btnHome(ActionEvent event) throws IOException {
        App.setRoot("mainVIew");
    }
    public static VermietungModel getSelectedVermietung() {
        return selectedVermietung;
    }

    public void setSelectedVermietung(VermietungModel selectedVermietung) {
        this.selectedVermietung = selectedVermietung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
    
}
