package tietokantahaut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VarausDAO {
    /**
     * lisää varaus
     * @param varaus
     * @throws SQLException
     */
    public void lisaaVaraus(MajoitusvarausLuokka varaus) throws SQLException {
        String sql = "INSERT INTO varaukset (AsiakasID, MokkiID, varauksen_alku, varauksen_loppu) VALUES (?, ?, ?, ?)";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql)) {

            syote.setInt(1, varaus.getAsiakasID());
            syote.setInt(2, varaus.getMokkiID());
            syote.setTimestamp(3, Timestamp.valueOf(varaus.getVarauksenAlku()));
            syote.setTimestamp(4, Timestamp.valueOf(varaus.getVarauksenLoppu()));

            syote.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * hae kaikki varaukset
     * @return
     */
    public List<MajoitusvarausLuokka> haeKaikkiVaraukset(){
        List<MajoitusvarausLuokka> varaukset = new ArrayList<>();
        String sql = "SELECT * FROM varaukset";
        try (Connection yhteys = TietokantaYhteys.getConnection();
             PreparedStatement syote = yhteys.prepareStatement(sql);
             ResultSet tulokset = syote.executeQuery()) {

            while (tulokset.next()) {
                int mokkiID = tulokset.getInt("MokkiID");
                int asiakasID = tulokset.getInt("AsiakasID");
                Timestamp alku = tulokset.getTimestamp("varauksen_alku");
                Timestamp loppu = tulokset.getTimestamp("varauksen_loppu");

                // Lisätään oletusarvot lisätiedoille ja hinnalle
                MajoitusvarausLuokka varaus = new MajoitusvarausLuokka(
                        mokkiID,
                        asiakasID,
                        alku.toLocalDateTime(),
                        loppu.toLocalDateTime(),
                        0                // Hinta ei ole varaukset-taulussa

                );
                varaukset.add(varaus);

        }
    } catch (SQLException e) {
            e.printStackTrace();
        }
        return varaukset;
        }

    /**
     * poista kaikki varaukset
     * @param varausID
     */
    public void poistaVaraus(int varausID){
            String sql = "DELETE FROM varaukset WHERE VarausID = ?"; // ? = korvataan poistettavan varauksen ID-numerolla
            try (Connection yhteys = TietokantaYhteys.getConnection();
                 PreparedStatement syote = yhteys.prepareStatement(sql)) {
                syote.setInt(1, varausID);
                syote.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        }