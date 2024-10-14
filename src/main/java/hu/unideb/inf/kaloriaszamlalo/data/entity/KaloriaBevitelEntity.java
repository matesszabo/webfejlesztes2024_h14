package hu.unideb.inf.kaloriaszamlalo.data.entity;

import jakarta.persistence.*;

import java.util.Date;

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
    private EtelEntity etel;

}
