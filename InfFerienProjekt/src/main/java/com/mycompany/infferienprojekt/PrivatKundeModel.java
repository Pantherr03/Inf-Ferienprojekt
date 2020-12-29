/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

/**
 *
 * @author Paul
 */
public class PrivatKundeModel extends KundeModel{
    private String SicherheitsKontakt;

    public PrivatKundeModel(String SicherheitsKontakt, String geburtsdatum, String vorname, String nachname, String geburtsort, String kundenTyp) {
        super(geburtsdatum, vorname, nachname, geburtsort, kundenTyp);
        this.SicherheitsKontakt = SicherheitsKontakt;
    }

    public void setSicherheitsKontakt(String SicherheitsKontakt) {
        this.SicherheitsKontakt = SicherheitsKontakt;
    }

    public String getSicherheitsKontakt() {
        return SicherheitsKontakt;
    }
    
    
    
}
