package tietokantahaut;

import java.sql.Timestamp;

public class MajoitusvarausLuokka {
    private int VarausID;
    private int AsiakasID;
    private int MokkiID;
    private Timestamp varauksenAlku;
    private Timestamp varauksenLoppu;
    private String lisatiedot;

    public MajoitusvarausLuokka(int varausID, int asiakasID, int mokkiID, Timestamp varauksenAlku, Timestamp varauksenLoppu, String lisatiedot){

        VarausID = varausID;
        AsiakasID = asiakasID;
        MokkiID = mokkiID;
        this.varauksenAlku = varauksenAlku;
        this.varauksenLoppu = varauksenLoppu;
        this.lisatiedot = lisatiedot;
    }
    /**
     * Luodaan get- ja set metodit kaikille
     */

    /**
     * palauttaa varaus -taulun pääavaimen
     * @return
     */
    public int getVarausID() {
        return VarausID;
    }
    /**
     * palauttaa asiakas -taulun pääavaimen
     * @return
     */
    public int getAsiakasID(){
        return AsiakasID;
    }
    /**
     * palauttaa mökki -taulun pääavaimen
     * @return
     */
    public int getMokkiID() {
        return MokkiID;
    }
    /**
     * palauttaa varauksen alkupäivän
     * @return
     */
    public Timestamp getVarauksenAlku() {
        return varauksenAlku;
    }
    /**
     * palauttaa varauksen loppupäivän
     * @return
     */
    public Timestamp getVarauksenLoppu() {
        return varauksenLoppu;
    }
    /**
     * palauttaa lisätiedot
     * @return
     */
    public String getLisatiedot() {
        return lisatiedot;
    }

    /**
     * asettaa varaukselle pääavaimen
     * @param varausID
     */
    public void setVarausID(int varausID){
        this.VarausID = varausID;
    }

    /**
     * asettaa asiakkaalle pääavaimen
     * @param asiakasID
     */
    public void setAsiakasID(int asiakasID) {
        AsiakasID = asiakasID;
    }

    /**
     * asettaa mökille pääavaimen
     * @param mokkiID
     */
    public void setMokkiID(int mokkiID) {
        MokkiID = mokkiID;
    }

    /**
     * asettaa varauksella alkupäivämäärän
     * @param varauksenAlku
     */
    public void setVarauksenAlku(Timestamp varauksenAlku) {
        this.varauksenAlku = varauksenAlku;
    }

    /**
     * asettaa varaukselle loppupäivämäärän
     * @param varauksenLoppu
     */
    public void setVarauksenLoppu(Timestamp varauksenLoppu) {
        this.varauksenLoppu = varauksenLoppu;
    }

    /**
     * asettaa lisätiedot
     * @param lisatiedot
     */
    public void setLisatiedot(String lisatiedot) {
        this.lisatiedot = lisatiedot;
    }
}

