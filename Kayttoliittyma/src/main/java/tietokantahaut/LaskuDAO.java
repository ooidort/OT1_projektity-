package tietokantahaut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaskuDAO {
    public void lisaaLasku(LaskuLuokka lasku) {
        String sql = "INSERT INTO laskut (LaskuID, erapaiva_alku, erapaiva_loppu, summa) VALUES (?, ?, ?, ?)";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql)) {
            syote.setInt(1, lasku.getLaskuID());
            syote.setTimestamp(2, lasku.getErapaiva_alku());
            syote.setTimestamp(3, lasku.getErapaiva_loppu());
            syote.setDouble(4, lasku.getSumma());
            syote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LaskuLuokka getLasku(int LaskuID) {
        String sql = "SELECT * FROM laskut WHERE LaskuID = ?";
        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement syote = conn.prepareStatement(sql)) {
            syote.setInt(1, LaskuID);
            ResultSet rs = syote.executeQuery();
            if (rs.next()) {
                return new LaskuLuokka(
                        rs.getInt("LaskuID"),
                        rs.getTimestamp("erapaiva_alku"),
                        rs.getTimestamp("erapaiva_loppu"),
                        rs.getDouble("summa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
