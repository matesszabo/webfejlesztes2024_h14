package hu.unideb.inf.kaloriaszamlalo.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Etel")
public class EtelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev", nullable = false)
    private String nev;
    @Column(name = "suly")
    private Float suly;
    @Column(name ="kaloria")
    private Integer kaloria;
    @Column(name = "tipus")
    private String tipus;
    @Column(name = "zsir")
    private Integer zsir;
    @Column(name = "szenhidrat")
    private Integer szenhidrat;
    @Column(name = "feherje")
    private Integer feherje;

    public EtelEntity() {
    }

    public EtelEntity(long id, String nev, Float suly, Integer kaloria, String tipus, Integer zsir, Integer szenhidrat, Integer feherje) {
        this.id = id;
        this.nev = nev;
        this.suly = suly;
        this.kaloria = kaloria;
        this.tipus = tipus;
        this.zsir = zsir;
        this.szenhidrat = szenhidrat;
        this.feherje = feherje;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Float getSuly() {
        return suly;
    }

    public void setSuly(Float suly) {
        this.suly = suly;
    }

    public Integer getKaloria() {
        return kaloria;
    }

    public void setKaloria(Integer kaloria) {
        this.kaloria = kaloria;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Integer getZsir() {
        return zsir;
    }

    public void setZsir(Integer zsir) {
        this.zsir = zsir;
    }

    public Integer getSzenhidrat() {
        return szenhidrat;
    }

    public void setSzenhidrat(Integer szenhidrat) {
        this.szenhidrat = szenhidrat;
    }

    public Integer getFeherje() {
        return feherje;
    }

    public void setFeherje(Integer feherje) {
        this.feherje = feherje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtelEntity that = (EtelEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(suly, that.suly) && Objects.equals(kaloria, that.kaloria) && Objects.equals(tipus, that.tipus) && Objects.equals(zsir, that.zsir) && Objects.equals(szenhidrat, that.szenhidrat) && Objects.equals(feherje, that.feherje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, suly, kaloria, tipus, zsir, szenhidrat, feherje);
    }
}
