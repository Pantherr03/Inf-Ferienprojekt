package com.mycompany.infferienprojekt;

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
