package tietokantahaut;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
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

    public ObservableList<LaskuLuokka> haeLaskutAsiakkaalle(int asiakasId) {
        ObservableList<LaskuLuokka> laskut = FXCollections.observableArrayList();
        String sql = "SELECT * FROM laskut WHERE AsiakasID = ?";

        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, asiakasId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LaskuLuokka lasku = new LaskuLuokka(
                        rs.getInt("LaskuID"),
                        rs.getTimestamp("erapaiva_alku"),
                        rs.getTimestamp("erapaiva_loppu"),
                        rs.getDouble("summa")
                );
                laskut.add(lasku);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laskut;
    }
    public void lisaaLasku(Timestamp paivamaara, Timestamp erapaiva, int asiakasID, int mokkiID,
                           int summa, boolean loppusiivous) {
        String sql = "INSERT INTO lasku (paivamaara, erapaiva, asiakas_id, mokki_id, summa, loppusiivous) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, paivamaara);
            stmt.setTimestamp(2, erapaiva);
            stmt.setInt(3, asiakasID);
            stmt.setInt(4, mokkiID);
            stmt.setInt(5, summa);
            stmt.setBoolean(6, loppusiivous);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
