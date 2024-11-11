package hu.unideb.inf.kaloriaszamlalo.data.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "szemely_adat")
public class SzemelyEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "szuletesi_datum")
    private Date szuletesi;
    @Column(name = "email")
    private String email;
    @Column(name = "jelszo")
    private String jelszo;
    @Column(name = "magassag")
    private Integer magassag;
    @Column(name = "nem")
    private String nem;

    @OneToMany(mappedBy = "szemely")
    private List<KaloriaBevitelEntity> kaloriaBevitelek;

    @OneToMany(mappedBy = "szemely")
    private List<TestsulyValtozasEntity> testsulyValtozasok;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jog_id", referencedColumnName = "id")
    private Jogosultsag jogosultsag;

    public SzemelyEntity() {
    }

    public SzemelyEntity(long id, String nev, Date szuletesi, String email, String jelszo, Integer magassag, String nem) {
        this.id = id;
        this.nev = nev;
        this.szuletesi = szuletesi;
        this.email = email;
        this.jelszo = jelszo;
        this.magassag = magassag;
        this.nem = nem;
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

    public List<KaloriaBevitelEntity> getKaloriaBevitelek() {
        return kaloriaBevitelek;
    }

    public void setKaloriaBevitelek(List<KaloriaBevitelEntity> kaloriaBevitelek) {
        this.kaloriaBevitelek = kaloriaBevitelek;
    }

    public List<TestsulyValtozasEntity> getTestsulyValtozasok() {
        return testsulyValtozasok;
    }

    public void setTestsulyValtozasok(List<TestsulyValtozasEntity> testsulyValtozasok) {
        this.testsulyValtozasok = testsulyValtozasok;
    }

    public Jogosultsag getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(Jogosultsag jogosultsag) {
        this.jogosultsag = jogosultsag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SzemelyEntity that = (SzemelyEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(szuletesi, that.szuletesi) && Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo) && Objects.equals(magassag, that.magassag) && Objects.equals(nem, that.nem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, szuletesi, email, jelszo, magassag, nem);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(jogosultsag);
    }

    @Override
    public String getPassword() {
        return jelszo;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
