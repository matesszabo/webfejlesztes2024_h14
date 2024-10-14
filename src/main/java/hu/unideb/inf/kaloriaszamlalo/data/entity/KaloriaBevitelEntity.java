package hu.unideb.inf.kaloriaszamlalo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="kaloriabevitel")
public class KaloriaBevitelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "suly", nullable = false)
    private Float suly;
    @Column(name = "elfogyasztva")
    private Date datum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etel_id", referencedColumnName = "id")
    private EtelEntity etel;

    public KaloriaBevitelEntity() {
    }

    public KaloriaBevitelEntity(long id, Float suly, Date datum, EtelEntity etel) {
        this.id = id;
        this.suly = suly;
        this.datum = datum;
        this.etel = etel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getSuly() {
        return suly;
    }

    public void setSuly(Float suly) {
        this.suly = suly;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public EtelEntity getEtel() {
        return etel;
    }

    public void setEtel(EtelEntity etel) {
        this.etel = etel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KaloriaBevitelEntity that = (KaloriaBevitelEntity) o;
        return id == that.id && Objects.equals(suly, that.suly) && Objects.equals(datum, that.datum) && Objects.equals(etel, that.etel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, suly, datum, etel);
    }
}
