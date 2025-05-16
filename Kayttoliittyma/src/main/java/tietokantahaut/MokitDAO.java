package tietokantahaut;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MokitDAO {
    public void lisaaMokki(MokkiLuokka mokki) {
        String sql = "INSERT INTO mokit (MokkiID, osoite, varauksen_alku, varauksen_loppu, hinta, kayttoaste) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql)) {
            syote.setInt(1, mokki.getMokkiID());
            syote.setString(2, mokki.getOsoite());
            syote.setTimestamp(3, mokki.getVarauksenAlku());
            syote.setTimestamp(4, mokki.getVarauksenLoppu());
            syote.setInt(5, mokki.getHinta());
            syote.setInt(6, mokki.getKayttoaste());
            syote.setInt(7, mokki.getHuoneet());
            syote.setInt(8, mokki.getKapasiteetti());
            syote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MokkiLuokka getMokki(int mokkiID) {
        String sql = "SELECT * FROM mokit WHERE MokkiID = ?";
        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement syote = conn.prepareStatement(sql)) {
            syote.setInt(1, mokkiID);
            ResultSet rs = syote.executeQuery();
            if (rs.next()) {
                return new MokkiLuokka(
                        rs.getInt("MokkiID"),
                        rs.getString("osoite"),
                        rs.getTimestamp("varauksen_alku"),
                        rs.getTimestamp("varauksen_loppu"),
                        rs.getInt("hinta"),
                        rs.getInt("kayttoaste"),
                        rs.getInt("huoneet"),
                        rs.getInt("kapasiteetti")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<MokkiLuokka> haeKaikkiMokit() {
        ObservableList<MokkiLuokka> mokit = FXCollections.observableArrayList();
        String sql = "SELECT * FROM mokit";

        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MokkiLuokka mokki = new MokkiLuokka(
                        rs.getInt("MokkiID"),
                        rs.getString("osoite"),
                        rs.getTimestamp("varauksen_alku"),
                        rs.getTimestamp("varauksen_loppu"),
                        rs.getInt("hinta"),
                        rs.getInt("kayttoaste"),
                        0,
                        0
                );
                mokit.add(mokki);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mokit;
    }
}