package it.uniroma1.lcl.studstats.dati;

import java.util.HashMap;

public class Rapporto<K,V>
{
    private TipoRapporto tipoRapporto;
    private HashMap<K,V> rapporto;

    public Rapporto(TipoRapporto tipoRapporto, HashMap<K,V> rapporto)
    {
        this.tipoRapporto = tipoRapporto;
        this.rapporto = rapporto;
    }

    @Override
    public String toString() {return rapporto.toString();}

    public HashMap<K,V> getRapporto() {return rapporto;}
    public TipoRapporto getTipoRapporto() {return tipoRapporto;}
}
