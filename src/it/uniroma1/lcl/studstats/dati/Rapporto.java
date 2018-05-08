package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.HashMap;

public class Rapporto
{
    private TipoRapporto tipoRapporto;
    private HashMap rapporto;

    public enum RapportoSemplice implements TipoRapporto
    {
        ANNO_DIPLOMA,
        ISTITUTI,
        SESSO,
        TITOLO,
        VOTO,
        VOTO_MAGGIORE;

    }



    public Rapporto(TipoRapporto tipoRapporto, HashMap rapporto)
    {
        this.tipoRapporto = tipoRapporto;
        this.rapporto = rapporto;
    }

    @Override
    public String toString() {return rapporto.toString();}

    public HashMap getRapporto() {return rapporto;}
    public TipoRapporto getTipoRapporto() {return tipoRapporto;}
}
