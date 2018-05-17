package it.uniroma1.lcl.studstats.dati;

import java.util.AbstractMap;
import java.util.HashMap;

public class Rapporto
{
    private TipoRapporto tipoRapporto;
    private HashMap<String, ? extends AbstractMap<String, ? extends Number>> rapporto;

    public Rapporto(TipoRapporto tipoRapporto, HashMap<String,
                    ? extends AbstractMap<String, ? extends Number>> rapporto)
    {
        this.tipoRapporto = tipoRapporto;
        this.rapporto = rapporto;
    }

    @Override
    public String toString() {return rapporto.toString();}

    public HashMap<String,? extends AbstractMap<String, ? extends Number>> getRapporto() {return rapporto;}
    public TipoRapporto getTipoRapporto() {return tipoRapporto;}
}
