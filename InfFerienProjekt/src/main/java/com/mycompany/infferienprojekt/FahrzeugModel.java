package com.mycompany.infferienprojekt;

public abstract class FahrzeugModel {
    String hersteller;
    String modell;
    String farbe;
    String kennzeichen;
    String typ;
    boolean inReparatur;
    boolean inBenutzung;
    double stundenkosten;
    int fahrzeugnummer;

    public FahrzeugModel(String hersteller, String modell, String farbe, String kennzeichen,String typ, boolean inReparatur, boolean inBenutzung, double stundenkosten, int fahrzeugnummer) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.typ = typ;
        this.inReparatur = inReparatur;
        this.inBenutzung = inBenutzung;
        this.stundenkosten = stundenkosten;
        this.fahrzeugnummer = fahrzeugnummer;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setInReparatur(boolean inReparatur) {
        this.inReparatur = inReparatur;
    }

    public void setInBenutzung(boolean inBenutzung) {
        this.inBenutzung = inBenutzung;
    }

    public void setStundenkosten(double stundenkosten) {
        this.stundenkosten = stundenkosten;
    }

    public void setFahrzeugnummer(int fahrzeugnummer) {
        this.fahrzeugnummer = fahrzeugnummer;
    }

    public String getHersteller() {
        return hersteller;
    }

    public String getModell() {
        return modell;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getTyp() {
        return typ;
    }

    public boolean getInReparatur() {
        return inReparatur;
    }

    public boolean getInBenutzung() {
        return inBenutzung;
    }

    public double getStundenkosten() {
        return stundenkosten;
    }

    public int getFahrzeugnummer() {
        return fahrzeugnummer;
    }
    

    
}
