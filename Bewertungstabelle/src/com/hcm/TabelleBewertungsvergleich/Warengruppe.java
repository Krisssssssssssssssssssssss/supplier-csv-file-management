package com.hcm.TabelleBewertungsvergleich;

//Could be used for the suggestion given in the README
//Also could be a base for a future database entity
public class Warengruppe {
    private String WGID;
    private String WarengruppenTitel;

    public Warengruppe(String WGID, String WarengruppenTitel) {
        this.WGID = WGID;
        this.WarengruppenTitel = WarengruppenTitel;
    }

    public String getWGID() {
        return WGID;
    }

    public void setWGID(String WGID) {
        this.WGID = WGID;
    }

    public String getWarengruppenTitel() {
        return WarengruppenTitel;
    }

    public void setWarengruppenTitel(String WarengruppenTitel) {
        this.WarengruppenTitel = WarengruppenTitel;
    }
}