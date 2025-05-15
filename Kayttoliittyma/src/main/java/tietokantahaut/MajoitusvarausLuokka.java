package tietokantahaut;

import java.time.LocalDateTime;

public class MajoitusvarausLuokka {
    private int mokkiID;
    private int asiakasID;
    private LocalDateTime varauksenAlku;
    private LocalDateTime varauksenLoppu;
    private int hinta;
    private String lisatiedot;

    public MajoitusvarausLuokka(int mokkiID, int asiakasID, LocalDateTime varauksenAlku, LocalDateTime varauksenLoppu, int hinta, String lisatiedot) {
        this.mokkiID = mokkiID;
        this.asiakasID = asiakasID;
        this.varauksenAlku = varauksenAlku;
        this.varauksenLoppu = varauksenLoppu;
        this.hinta = hinta;
        this.lisatiedot = lisatiedot;
    }

    // Getterit ja setterit

    public int getMokkiID() {
        return mokkiID; }

    public void setMokkiID(int mokkiID) {
        this.mokkiID = mokkiID; }

    public int getAsiakasID() {
        return asiakasID; }

    public void setAsiakasID(int asiakasID) {
        this.asiakasID = asiakasID; }

    public LocalDateTime getVarauksenAlku() {
        return varauksenAlku; }

    public void setVarauksenAlku(LocalDateTime varauksenAlku) {
        this.varauksenAlku = varauksenAlku; }

    public LocalDateTime getVarauksenLoppu() {
        return varauksenLoppu; }

    public void setVarauksenLoppu(LocalDateTime varauksenLoppu) {
        this.varauksenLoppu = varauksenLoppu; }

    public int getHinta() {
        return hinta; }

    public void setHinta(int hinta) {
        this.hinta = hinta; }

    public String getLisatiedot() {
        return lisatiedot; }

    public void setLisatiedot(String lisatiedot) {
        this.lisatiedot = lisatiedot; }
}


