package tietokantahaut;

public class AsiakasLuokka {
    private int asiakasID;
    private String nimi;
    private String sahkoposti;
    private String osoite;
    private String puhelinnumero;

    public AsiakasLuokka(int asiakasID, String nimi, String sahkoposti, String osoite,
                         String puhelinnumero) {
        this.asiakasID = asiakasID;
        this.nimi = nimi;
        this.sahkoposti = sahkoposti;
        this.osoite = osoite;
        this.puhelinnumero = puhelinnumero;
    }

    /**
     * Asettaa asiakkaan osoitteen
     * @param osoite
     */
    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    /**
     * Asettaa asiakkaan pääavaimen
     * @param asiakasID
     */
    public void setAsiakasID(int asiakasID) {
        this.asiakasID = asiakasID;
    }

    /**
     * Asettaa asiakkaan nimen
     * @param nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Asettaa asiakkaan puhelinnumeron
     * @param puhelinnumero
     */
    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    /**
     * Asettaa asiakkaan sähköpostin
     * @param sahkoposti
     */
    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    /**
     * Hakee asiakkaan pääavaimen
     * @return
     */
    public int getAsiakasID() {
        return asiakasID;
    }

    /**
     * Hakee asiakkaan nimen
     * @return
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Hakee asiakkaan osoitteen
     * @return
     */
    public String getOsoite() {
        return osoite;
    }

    /**
     * Hakee asiakkaan puhelinnumeron
     * @return
     */
    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    /**
     * Hakee asiakkaan sähköpostin
     * @return
     */
    public String getSahkoposti() {
        return sahkoposti;
    }

    @Override
    public String toString() {
        return nimi;
    }
}


