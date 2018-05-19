package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Analizza gli studenti in base all'istituto superiore che hanno frequentato,
 * contando per ogni istituto il numero di studenti.
 */
public class AnalizzatoreIstituti extends AnalizzatoreBasic implements Analizzatore
{

    /**
     * Genera un rapporto analizzando la collezione di studenti
     * @param studs una collezione di studenti.
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, LinkedHashMap<String, Long>> mappa = new HashMap<>();
        mappa.put("ISTITUTI", generaMappaInternaOrdinataSuValori(studs,"ISTITUTO_SUPERIORE"));
        return new Rapporto(getTipo(), mappa);
    }

    /**
     * Restituisce il tipo del rapporto che andrà a generare.
     * @return il tipo del rapporto che genera, ovvero <strong>ISTITUTI</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.ISTITUTI; }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        return !(o == null || o.getClass() != this.getClass());
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {return Objects.hash(this.getClass()); }
}
