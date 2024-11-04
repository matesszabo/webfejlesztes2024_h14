package hu.unideb.inf.kaloriaszamlalo.service.dto;

import java.util.Objects;

//Dto - Data transfer object
//POJO - plain old java object
public class EtelDto {

    private Long id;
    private String nev;
    private Float suly;
    private Integer kaloria;
    private String tipus;
    private Integer zsir;
    private Integer szenhidrat;
    private Integer feherje;

    public EtelDto() {
    }

    public EtelDto(Long id, String nev, Float suly, Integer kaloria, String tipus, Integer zsir, Integer szenhidrat, Integer feherje) {
        this.id = id;
        this.nev = nev;
        this.suly = suly;
        this.kaloria = kaloria;
        this.tipus = tipus;
        this.zsir = zsir;
        this.szenhidrat = szenhidrat;
        this.feherje = feherje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        EtelDto etelDto = (EtelDto) o;
        return Objects.equals(id, etelDto.id) && Objects.equals(nev, etelDto.nev) && Objects.equals(suly, etelDto.suly) && Objects.equals(kaloria, etelDto.kaloria) && Objects.equals(tipus, etelDto.tipus) && Objects.equals(zsir, etelDto.zsir) && Objects.equals(szenhidrat, etelDto.szenhidrat) && Objects.equals(feherje, etelDto.feherje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, suly, kaloria, tipus, zsir, szenhidrat, feherje);
    }
}
