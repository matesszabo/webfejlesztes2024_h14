package hu.unideb.inf.kaloriaszamlalo.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class RegisztracioDto {
    private String nev;
    private Date szuletesi;
    private String email;
    private String jelszo;
    private Integer magassag;
    private String nem;

    public RegisztracioDto() {
    }

    public RegisztracioDto(String nev, Date szuletesi, String email, String jelszo, Integer magassag, String nem) {
        this.nev = nev;
        this.szuletesi = szuletesi;
        this.email = email;
        this.jelszo = jelszo;
        this.magassag = magassag;
        this.nem = nem;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuletesi() {
        return szuletesi;
    }

    public void setSzuletesi(Date szuletesi) {
        this.szuletesi = szuletesi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public Integer getMagassag() {
        return magassag;
    }

    public void setMagassag(Integer magassag) {
        this.magassag = magassag;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisztracioDto that = (RegisztracioDto) o;
        return Objects.equals(nev, that.nev) && Objects.equals(szuletesi, that.szuletesi) && Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo) && Objects.equals(magassag, that.magassag) && Objects.equals(nem, that.nem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, szuletesi, email, jelszo, magassag, nem);
    }
}