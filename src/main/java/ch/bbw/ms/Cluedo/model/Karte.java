package ch.bbw.ms.Cluedo.model;

public abstract class Karte {
    private String name;
    private String bildpfad;

    public Karte(String name, String bildpfad) {
        this.name = name;
        this.bildpfad = bildpfad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBildpfad() {
        return bildpfad;
    }

    public void setBildpfad(String bildpfad) {
        this.bildpfad = bildpfad;
    }
}
 
