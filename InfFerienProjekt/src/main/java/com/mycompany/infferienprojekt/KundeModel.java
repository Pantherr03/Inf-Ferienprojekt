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
public abstract class KundeModel {
    private String geburtsdatum;
    private String vorname;
    private String nachname;
    private String geburtsort;
    private String kundenTyp;

    public KundeModel(String geburtsdatum, String vorname, String nachname, String geburtsort, String kundenTyp) {
        this.geburtsdatum = geburtsdatum;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsort = geburtsort;
        this.kundenTyp = kundenTyp;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setKundenTyp(String kundenTyp) {
        this.kundenTyp = kundenTyp;
    }
    

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public String getKundenTyp() {
        return kundenTyp;
    }
    
    
    
}
