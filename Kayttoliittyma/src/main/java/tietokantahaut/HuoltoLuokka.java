package tietokantahaut;

import java.sql.Timestamp;
import java.time.LocalDate;

public class HuoltoLuokka {

    private int huoltoID;
    private int mokkiID;
    private String historia;
    private String kohteet;
    private Timestamp alkupaiva;
    private Timestamp loppupaiva;

    public HuoltoLuokka(int mokkiID, int huoltoID, String kohteet, String historia, Timestamp alkupaiva, Timestamp loppupaiva) {
        this.huoltoID = huoltoID;
        this.mokkiID = mokkiID;
        this.historia = historia;
        this.kohteet = kohteet;
        this.alkupaiva = alkupaiva;
        this.loppupaiva = loppupaiva;
    }

    /**
     * Asettaa huoltohistorian merkkijonona
     * @param historia
     */
    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setMokkiID(int mokkiID) {
        this.mokkiID = mokkiID;
    }

    public void setAlkupaiva(Timestamp alkupaiva) {
        this.alkupaiva = alkupaiva;
    }

    public void setLoppupaiva(Timestamp loppupaiva) {
        this.loppupaiva = loppupaiva;
    }

    /**
     * Asettaa huollolle pääavaimen
     * @param huoltoID
     */
    public void setHuoltoID(int huoltoID) {
        this.huoltoID = huoltoID;
    }

    /**
     * Asettaa huollolle kohteen
     * @param kohteet
     */
    public void setKohteet(String kohteet) {
        this.kohteet = kohteet;
    }

    /**
     * Hakee huollon pääavaimen
     * @return
     */
    public int getHuoltoID() {
        return huoltoID;
    }

    public int getMokkiID() {
        return mokkiID;
    }

    /**
     * Hakee huoltohistorian
     * @return
     */
    public String getHistoria() {
        return historia;
    }

    public Timestamp getAlkupaiva() {
        return alkupaiva;
    }

    public Timestamp getLoppupaiva() {
        return loppupaiva;
    }

    /**
     * Hakee huoltokohteet
     * @return
     */
    public String getKohteet() {
        return kohteet;
    }
}
