package hu.unideb.inf.kaloriaszamlalo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Sulyvaltozasok")
public class TestsulyValtozasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "dátum", nullable = false)
    private Date datum;
    @Column(name = "suly", nullable = false)
    private Float suly;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "szemely_id", referencedColumnName = "id")
    private SzemelyEntity szemely;

    public TestsulyValtozasEntity() {
    }

    public TestsulyValtozasEntity(long id, Date datum, Float suly, SzemelyEntity szemely) {
        this.id = id;
        this.datum = datum;
        this.suly = suly;
        this.szemely = szemely;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Float getSuly() {
        return suly;
    }

    public void setSuly(Float suly) {
        this.suly = suly;
    }

    public SzemelyEntity getSzemely() {
        return szemely;
    }

    public void setSzemely(SzemelyEntity szemely) {
        this.szemely = szemely;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestsulyValtozasEntity that = (TestsulyValtozasEntity) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(suly, that.suly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, suly);
    }
}
