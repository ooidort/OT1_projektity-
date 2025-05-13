package tietokantahaut;

public class HuoltoLuokka {

    private int huoltoID;
    private String historia;
    private String kohteet;

    HuoltoLuokka(int huoltoID, String historia, String kohteet) {
        this.huoltoID = huoltoID;
        this.historia = historia;
        this.kohteet = kohteet;
    }

    /**
     * Asettaa huoltohistorian merkkijonona
     * @param historia
     */
    public void setHistoria(String historia) {
        this.historia = historia;
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

    /**
     * Hakee huoltohistorian
     * @return
     */
    public String getHistoria() {
        return historia;
    }

    /**
     * Hakee huoltokohteet
     * @return
     */
    public String getKohteet() {
        return kohteet;
    }
}
