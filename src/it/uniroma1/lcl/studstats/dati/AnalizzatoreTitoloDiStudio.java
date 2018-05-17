package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.analizzatori.AnalizzatoreBasic;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class AnalizzatoreTitoloDiStudio extends AnalizzatoreBasic implements Analizzatore
{
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, LinkedHashMap<String,Long>> mappa = new HashMap<>();
        mappa.put("TITOLO", generaMappaInternaOrdinata(studs, "TITOLO_DI_STUDIO"));
        return new Rapporto(getTipo(), mappa);
    }

    @Override
    public TipoRapporto getTipo()
    {
        return RapportoBase.TITOLO;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        return !(o == null || o.getClass() != this.getClass());
    }

    @Override
    public int hashCode() {return Objects.hash(this.getClass()); }
}