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
public class GeschaeftsKundeModel extends KundeModel{
    private String arbeitsAdresse;
    private String arbeitsTelefonnummer;

    public GeschaeftsKundeModel(String arbeitsAdresse, String arbeitsTelefonnummer, String geburtsdatum, String vorname, String nachname, String geburtsort, String kundenTyp) {
        super(geburtsdatum, vorname, nachname, geburtsort, kundenTyp);
        this.arbeitsAdresse = arbeitsAdresse;
        this.arbeitsTelefonnummer = arbeitsTelefonnummer;
    }

    public void setArbeitsAdresse(String arbeitsAdresse) {
        this.arbeitsAdresse = arbeitsAdresse;
    }

    public void setArbeitsTelefonnummer(String arbeitsTelefonnummer) {
        this.arbeitsTelefonnummer = arbeitsTelefonnummer;
    }

    public String getArbeitsAdresse() {
        return arbeitsAdresse;
    }

    public String getArbeitsTelefonnummer() {
        return arbeitsTelefonnummer;
    }

   
    
}
