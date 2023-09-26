package ch.bbw.ms.Cluedo.model;


import java.util.List;

public class Spiel {
    private List<Verdachtiger> verdachtige;
    private List<Waffe> waffen;
    private List<Zimmer> zimmer;
    private int aktiverSpieler;  // 1 oder 2
    private boolean mehrspielerModus;


    private Verdachtiger tatsachlicherVerdachtiger;
    private Waffe tatsachlicheWaffe;
    private Zimmer tatsachlichesZimmer;

    public Spiel(List<Verdachtiger> verdachtige, List<Waffe> waffen, List<Zimmer> zimmer) {
        this.verdachtige = verdachtige;
        this.waffen = waffen;
        this.zimmer = zimmer;
    }

    public List<Verdachtiger> getVerdachtige() {
        return verdachtige;
    }

    public void setVerdachtige(List<Verdachtiger> verdachtige) {
        this.verdachtige = verdachtige;
    }

    public List<Waffe> getWaffen() {
        return waffen;
    }

    public void setWaffen(List<Waffe> waffen) {
        this.waffen = waffen;
    }

    public List<Zimmer> getZimmer() {
        return zimmer;
    }

    public void setZimmer(List<Zimmer> zimmer) {
        this.zimmer = zimmer;
    }

    public Verdachtiger getTatsachlicherVerdachtiger() {
        return tatsachlicherVerdachtiger;
    }

    public void setTatsachlicherVerdachtiger(Verdachtiger tatsachlicherVerdachtiger) {
        this.tatsachlicherVerdachtiger = tatsachlicherVerdachtiger;
    }

    public Waffe getTatsachlicheWaffe() {
        return tatsachlicheWaffe;
    }

    public void setTatsachlicheWaffe(Waffe tatsachlicheWaffe) {
        this.tatsachlicheWaffe = tatsachlicheWaffe;
    }

    public Zimmer getTatsachlichesZimmer() {
        return tatsachlichesZimmer;
    }

    public void setTatsachlichesZimmer(Zimmer tatsachlichesZimmer) {
        this.tatsachlichesZimmer = tatsachlichesZimmer;
    }

        public int getAktiverSpieler() {
        return aktiverSpieler;
    }

    public void setAktiverSpieler(int aktiverSpieler) {
        this.aktiverSpieler = aktiverSpieler;
    }

    public boolean isMehrspielerModus() {
        return mehrspielerModus;
    }

    public void setMehrspielerModus(boolean mehrspielerModus) {
        this.mehrspielerModus = mehrspielerModus;
    }
}

