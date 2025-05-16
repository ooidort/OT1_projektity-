package tietokantahaut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;


public class HuoltoDAO {
    public int lisaaHuolto(HuoltoLuokka huolto) {
        String sql = "INSERT INTO huollot (historia, kohteet, alkupaiva, loppupaiva) VALUES (?, ?, ?, ?);";
        int generatedId = -1;
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            syote.setString(1, huolto.getHistoria());
            syote.setString(2, huolto.getKohteet());
            syote.setTimestamp(3, huolto.getAlkupaiva());
            syote.setTimestamp(4, huolto.getLoppupaiva());
            syote.executeUpdate();

            try (ResultSet rs = syote.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    public HuoltoLuokka getHuolto(int huoltoID) {
        String sql = "SELECT * FROM huollot WHERE HuoltoID = ?;";
        int generatedId = -1;
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

    public HuoltoLuokka haeHuoltoMokkiID(int mokkiID) {
        String sql = "SELECT * FROM huollot WHERE MokkiID = ? ORDER BY alkupaiva DESC LIMIT 1;";
        try (Connection conn = TietokantaYhteys.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mokkiID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new HuoltoLuokka(
                        rs.getInt("HuoltoID"),
                        rs.getInt("MokkiID"),
                        rs.getString("kohteet"),
                        rs.getString("historia"),
                        rs.getTimestamp("alkupaiva"),
                        rs.getTimestamp("loppupaiva")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }

    public List<HuoltoLuokka> haeKaikkiHuollot() {
        List<HuoltoLuokka> huollot = new ArrayList<>();
        String sql = "SELECT * FROM huollot";
        try (Connection conn = TietokantaYhteys.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {HuoltoLuokka huolto = new HuoltoLuokka(
                rs.getInt("HuoltoID"),
                rs.getInt("MokkiID"),
                rs.getString("kohteet"), rs.getString("historia"),
                rs.getTimestamp("alkupaiva"),
                rs.getTimestamp("loppupaiva")
            );
            huollot.add(huolto);
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    return huollot;
    }
}
