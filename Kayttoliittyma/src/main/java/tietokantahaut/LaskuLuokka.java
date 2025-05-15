package tietokantahaut;

import java.sql.Timestamp;

public class LaskuLuokka {

    private int laskuID;
    private Timestamp erapaiva_alku;
    private Timestamp erapaiva_loppu;
    private Double summa;

    public LaskuLuokka(int laskuID, Timestamp erapaiva_alku, Timestamp erapaiva_loppu, Double summa) {
        this.laskuID = laskuID;
        this.erapaiva_alku = erapaiva_alku;
        this.erapaiva_loppu = erapaiva_loppu;
        this.summa = summa;
    }

    /**
     * Asettaa laskun eräpäivän alkupäivämäärän
     * @param erapaiva_alku
     */
    public void setErapaiva_alku(Timestamp erapaiva_alku) {
        this.erapaiva_alku = erapaiva_alku;
    }

    /**
     * Asettaa viimeisen eräpäivän
     * @param erapaiva_loppu
     */
    public void setErapaiva_loppu(Timestamp erapaiva_loppu) {
        this.erapaiva_loppu = erapaiva_loppu;
    }

    /**
     * Asettaa laskun pääavaimen
     * @param laskuID
     */
    public void setLaskuID(int laskuID) {
        this.laskuID = laskuID;
    }

    /**
     * Asettaa laskun summan
     * @param summa
     */
    public void setSumma(Double summa) {
        this.summa = summa;
    }

    /**
     * Hakee laskun summan
     * @return
     */
    public Double getSumma() {
        return summa;
    }

    /**
     * Hakee laskun pääavaimen
     * @return
     */
    public int getLaskuID() {
        return laskuID;
    }

    /**
     * Hakee laskun laskuttamiserän alkupäivämäärän
     * @return
     */
    public Timestamp getErapaiva_alku() {
        return erapaiva_alku;
    }

    /**
     * Hakee laskun erääntymispäivän
     * @return
     */
    public Timestamp getErapaiva_loppu() {
        return erapaiva_loppu;
    }

    @Override
    public String toString() {
        return "Lasku " + laskuID + " (" + summa + " €)";
    }
}
