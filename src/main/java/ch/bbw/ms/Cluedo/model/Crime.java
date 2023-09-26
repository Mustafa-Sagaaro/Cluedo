package ch.bbw.ms.Cluedo.model;

public class Crime {
    private String taeter;
    private String tatwaffe;
    private String tatort;

    public Crime() {}

    public Crime(String taeter, String tatwaffe, String tatort) {
        this.taeter = taeter;
        this.tatwaffe = tatwaffe;
        this.tatort = tatort;
    }

    public String getTaeter() {
        return taeter;
    }

    public void setTaeter(String taeter) {
        this.taeter = taeter;
    }

    public String getTatwaffe() {
        return tatwaffe;
    }

    public void setTatwaffe(String tatwaffe) {
        this.tatwaffe = tatwaffe;
    }

    public String getTatort() {
        return tatort;
    }

    public void setTatort(String tatort) {
        this.tatort = tatort;
    }
}
