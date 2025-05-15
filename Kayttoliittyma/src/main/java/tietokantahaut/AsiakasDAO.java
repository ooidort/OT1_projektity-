package tietokantahaut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsiakasDAO {
    public void lisaaAsiakas(AsiakasLuokka asiakas) {
        String sql = "INSERT INTO asiakas (AsiakasID, nimi, sahkoposti, osoite, puhelinnumero) VALUES (?, ?, ?, ?, ?)";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql)) {
            syote.setInt(1, asiakas.getAsiakasID());
            syote.setString(2, asiakas.getNimi());
            syote.setString(3, asiakas.getSahkoposti());
            syote.setString(4, asiakas.getOsoite());
            syote.setString(5, asiakas.getPuhelinnumero());
            syote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AsiakasLuokka getAsiakas(int asiakasID) {
        String sql = "SELECT * FROM asiakas WHERE AsiakasID = ?";
        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement syote = conn.prepareStatement(sql)) {
            syote.setInt(1, asiakasID);
            ResultSet rs = syote.executeQuery();
            if (rs.next()) {
                return new AsiakasLuokka(
                        rs.getInt("AsiakasID"),
                        rs.getString("nimi"),
                        rs.getString("sahkoposti"),
                        rs.getString("osoite"),
                        rs.getString("puhelinnumero")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

