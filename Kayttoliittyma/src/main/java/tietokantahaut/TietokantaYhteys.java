package tietokantahaut;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TietokantaYhteys {

    /**
     * Merkkijonot joita käytetään käyttäjätilin yhdistämiseen mySQL-serveriin
     */
    private static final String URL = "jdbc:mysql://localhost:3306/mokki";
    private static final String kayttaja = "sinunKäyttäjätunnus";
    private static final String salasana = "sinunSalasana";

    /**
     * Metodi jolla yhdistetään käyttäjä mySQL-serveriin
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, kayttaja, salasana);
    }

}
