package it.uniroma1.lcl.studstats.dati;

import java.util.HashMap;

public class Rapporto
{
    private TipoRapporto tipoRapporto;
    private HashMap rapporto;

    public enum RapportoSemplice implements TipoRapporto
    {
        ANNI_DIPLOMA,
        ISTITUTI,
        SESSO,
        TITOLO,
        VOTO,
        VOTO_MAGGIORE
    }

    public enum RapportoComplesso implements TipoRapporto
    {

    }

    public Rapporto(TipoRapporto tipoRapporto, HashMap rapporto)
    {
        this.tipoRapporto = tipoRapporto;
        this.rapporto = rapporto;
    }


}
