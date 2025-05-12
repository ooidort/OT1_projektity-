package tietokantahaut;

import java.sql.Timestamp;

public class MokkiLuokka {

    private int mokkiID;
    private String osoite;
    private Timestamp varauksenAlku;
    private Timestamp varauksenLoppu;
    private int hinta;
    private int kayttoaste;

    public MokkiLuokka(int mokkiID, String osoite, Timestamp varauksenAlku, Timestamp varauksenLoppu,
                       int hinta, int kayttoaste) {
        this.mokkiID = mokkiID;
        this.osoite = osoite;
        this.varauksenAlku = varauksenAlku;
        this.varauksenLoppu = varauksenLoppu;
        this.hinta = hinta;
        this.kayttoaste = kayttoaste;
    }

    /**
     * Palauttaa mökin hinnan
     * @return
     */
    public int getHinta() {
        return hinta;
    }

    /**
     * Palauttaa mökin käyttöasteen
     * @return
     */
    public int getKayttoaste() {
        return kayttoaste;
    }

    /**
     * Palauttaa mökin tietokannan pääavaimen
     * @return
     */
    public int getMokkiID() {
        return mokkiID;
    }

    /**
     * Palauttaa mökin osoitteen
     * @return
     */
    public int getOsoite() {
        return osoite;
    }

    /**
     * Palauttaa mökin varauksen alkupäivän
     * @return
     */
    public Timestamp getVarauksenAlku() {
        return varauksenAlku;
    }

    /**
     * Palauttaa mökin varauksen lopupäivän
     * @return
     */
    public Timestamp getVarauksenLoppu() {
        return varauksenLoppu;
    }

    /**
     * Asettaa mökille hinnan
     * @param hinta
     */
    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    /**
     * Asettaa mökille käyttöasteen
     * @param kayttoaste
     */
    public void setKayttoaste(int kayttoaste) {
        this.kayttoaste = kayttoaste;
    }

    /**
     * Asettaa mökille pääavaimen
     * @param mokkiID
     */
    public void setMokkiID(int mokkiID) {
        this.mokkiID = mokkiID;
    }

    /**
     * Asettaa mökille osoitteen
     * @param osoite
     */
    public void setOsoite(int osoite) {
        this.osoite = osoite;
    }

    /**
     * Asettaa mökin varauksen alkupäivän
     * @param varauksenAlku
     */
    public void setVarauksenAlku(Timestamp varauksenAlku) {
        this.varauksenAlku = varauksenAlku;
    }

    /**
     * Asettaa mökin varauksen loppupäivän
     * @param varauksenLoppu
     */
    public void setVarauksenLoppu(Timestamp varauksenLoppu) {
        this.varauksenLoppu = varauksenLoppu;
    }
}
