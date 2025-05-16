package tietokantahaut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HuoltoDAO {
    public void lisaaHuolto(HuoltoLuokka huolto) {
        String sql = "INSERT INTO huollot (HuoltoID, MokkiID, historia, kohteet, alkupaiva, loppupaiva) VALUES (?, ?, ?, ?, ?)";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql)) {
            syote.setInt(1, huolto.getHuoltoID());
            syote.setInt(2, huolto.getMokkiID());
            syote.setString(2, huolto.getHistoria());
            syote.setString(3, huolto.getKohteet());
            syote.setTimestamp(4, huolto.getAlkupaiva());
            syote.setTimestamp(5, huolto.getLoppupaiva());
            syote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HuoltoLuokka getHuolto(int huoltoID) {
        String sql = "SELECT * FROM huollot WHERE HuoltoID = ?";
        try (Connection conn = TietokantaYhteys.getConnection();
             PreparedStatement syote = conn.prepareStatement(sql)) {
            syote.setInt(1, huoltoID);
            ResultSet rs = syote.executeQuery();
            if (rs.next()) {
                return new HuoltoLuokka(
                        rs.getInt("HuoltoID"),
                        rs.getInt("MokkiID"),
                        rs.getString("historia"),
                        rs.getString("kohteet"),
                        rs.getTimestamp("alkupaiva"),
                        rs.getTimestamp("loppupaiva")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
