package ch.bbw.ms.Cluedo.service;


import ch.bbw.ms.Cluedo.model.*;

import java.util.Random;
import java.util.List;

public class SpielService {
    private Spiel aktuellesSpiel;
    private Random random = new Random();
    private int gewinner = 0;

    public int getGewinner() {
        return gewinner;
    }

    public void setGewinner(int gewinner) {
        this.gewinner = gewinner;
    }

    public void startNeuesSpiel(List<Verdachtiger> verdachtige, List<Waffe> waffen, List<Zimmer> zimmer) {
        aktuellesSpiel = new Spiel(verdachtige, waffen, zimmer);

        aktuellesSpiel.setTatsachlicherVerdachtiger(verdachtige.get(random.nextInt(verdachtige.size())));
        aktuellesSpiel.setTatsachlicheWaffe(waffen.get(random.nextInt(waffen.size())));
        aktuellesSpiel.setTatsachlichesZimmer(zimmer.get(random.nextInt(zimmer.size())));
        setGewinner(0);

    }

    public Spiel getAktuellesSpiel() {
        return aktuellesSpiel;
    }

    public VermutungErgebnis pruefeVermutung(String verdachtigerName, String waffeName, String zimmerName) {
        boolean verdachtigerRichtig = aktuellesSpiel.getTatsachlicherVerdachtiger().getName().equals(verdachtigerName);
        boolean waffeRichtig = aktuellesSpiel.getTatsachlicheWaffe().getName().equals(waffeName);
        boolean zimmerRichtig = aktuellesSpiel.getTatsachlichesZimmer().getName().equals(zimmerName);

        if (verdachtigerRichtig && waffeRichtig && zimmerRichtig) {
            setGewinner(aktuellesSpiel.getAktiverSpieler());
        }
    
        return new VermutungErgebnis(verdachtigerRichtig, waffeRichtig, zimmerRichtig);
    }


    public void starteMehrspielerModus() {
        aktuellesSpiel.setMehrspielerModus(true);
        aktuellesSpiel.setAktiverSpieler(1);
    }

    public void wechsleSpieler() {
        if (aktuellesSpiel.getAktiverSpieler() == 1) {
            aktuellesSpiel.setAktiverSpieler(2);
        } else {
            aktuellesSpiel.setAktiverSpieler(1);
        }
    }

    public void beendeMehrspielerModus() {
        aktuellesSpiel.setMehrspielerModus(false);
    }

    public String generiereGeschichte() {
        String[] einleitungen = {
            "Es war ein stürmischer Abend, als plötzlich ein lauter Schrei durch das Haus hallte.",
            "Ein unerwarteter Gast kam zum Abendessen, doch der Abend sollte nicht wie geplant verlaufen.",
            "Die Uhr schlug Mitternacht, als ein unheilvolles Geräusch die Stille durchbrach."
        };
    
        String einleitung = einleitungen[random.nextInt(einleitungen.length)];
    
        Verdachtiger verdachtiger = aktuellesSpiel.getTatsachlicherVerdachtiger();
        Waffe waffe = aktuellesSpiel.getTatsachlicheWaffe();
        Zimmer zimmer = aktuellesSpiel.getTatsachlichesZimmer();
    
        String geschichte = einleitung + " " + verdachtiger.getName() + 
            " wurde zuletzt im " + zimmer.getName() + " gesehen, in der Nähe der " + waffe.getName() + 
            ". Was könnte geschehen sein?";
    
        return geschichte;
    }
    
}

