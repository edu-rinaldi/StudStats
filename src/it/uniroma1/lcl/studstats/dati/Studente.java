package it.uniroma1.lcl.studstats.dati;

import java.util.Objects;

public class Studente
{
    private Sesso sesso;
    private String nazioneDiNascita;
    private String regioneDiNascita;
    private String provinciaNascita;
    private String titoloDiStudio;
    private String istitutoSuperiore;
    private String comuneIstituto;
    private int voto;
    private int annoDiploma;

    public enum Sesso { M,F }

    public Studente(Sesso sesso, String nazioneDiNascita, String regioneDiNascita, String provinciaNascita,
                    String titoloDiStudio, String istitutoSuperiore, String comuneIstituto, int voto, int annoDiploma)
    {
        this.sesso              = sesso;
        this.nazioneDiNascita   = nazioneDiNascita;
        this.regioneDiNascita   = regioneDiNascita;
        this.provinciaNascita   = provinciaNascita;
        this.titoloDiStudio     = titoloDiStudio;
        this.istitutoSuperiore  = istitutoSuperiore;
        this.comuneIstituto     = comuneIstituto;
        this.voto               = voto;
        this.annoDiploma        = annoDiploma;
    }

    public Sesso getSesso() {return sesso;}

    public String getNazioneDiNascita() {return nazioneDiNascita;}
    public String getRegioneDiNascita() {return regioneDiNascita;}
    public String getProvinciaNascita() {return provinciaNascita;}
    public String getTitoloDiStudio() {return titoloDiStudio;}
    public String getIstitutoSuperiore() {return istitutoSuperiore;}
    public String getComuneIstituto() {return comuneIstituto;}

    public int getVoto() {return voto;}
    public int getAnnoDiploma() {return annoDiploma;}

    @Override
    public int hashCode()
    {
        return Objects.hash(sesso, nazioneDiNascita, regioneDiNascita, provinciaNascita, titoloDiStudio, istitutoSuperiore,
                comuneIstituto, voto, annoDiploma);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;

        Studente s = (Studente)o;

        return sesso == s.sesso && nazioneDiNascita.equals(s.nazioneDiNascita) && regioneDiNascita.equals(s.regioneDiNascita)
                && provinciaNascita.equals(s.provinciaNascita) && titoloDiStudio.equals(s.titoloDiStudio)
                && istitutoSuperiore.equals(s.istitutoSuperiore) && comuneIstituto.equals(s.comuneIstituto)
                && voto == s.voto && annoDiploma == s.annoDiploma;
    }

}
