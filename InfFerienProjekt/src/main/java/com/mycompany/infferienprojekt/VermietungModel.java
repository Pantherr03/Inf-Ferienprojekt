/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.infferienprojekt;

import java.time.LocalDateTime;

/**
 *
 * @author Paul
 */
public class VermietungModel {
    
    private LocalDateTime startDatum;
    private LocalDateTime endDatum;
    
    private KundeModel kunde;
    private FahrzeugModel fahrzeug;
    
    private int duration;   
    private double kosten;  


    public VermietungModel(LocalDateTime startDatum, LocalDateTime endDatum, KundeModel kunde, FahrzeugModel fahrzeug, int duration, double kosten) {
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.duration = duration;
        this.kosten = kosten;
    }

    public LocalDateTime getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDateTime startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDateTime getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDateTime endDatum) {
        this.endDatum = endDatum;
    }

    public KundeModel getKunde() {
        return kunde;
    }

    public void setKunde(KundeModel kunde) {
        this.kunde = kunde;
    }

    public FahrzeugModel getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(FahrzeugModel fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    
}
