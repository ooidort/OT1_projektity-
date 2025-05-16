package tietokantahaut;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TietokantaYhteys {

    /**
     * Merkkijonot joita käytetään käyttäjätilin yhdistämiseen mySQL-serveriin
     */
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/";
    private static final String kayttaja = "root";
    private static final String salasana = "testi123"; //67901265

    /**
     * Metodi jolla yhdistetään käyttäjä mySQL-serveriin
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, kayttaja, salasana);
    }
}
