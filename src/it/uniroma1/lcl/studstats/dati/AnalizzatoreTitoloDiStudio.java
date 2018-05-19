package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Analizza gli studenti in base al titolo di studio
 */
public class AnalizzatoreTitoloDiStudio extends AnalizzatoreBasic implements Analizzatore
{
    /**
     *
     * @param studs una collezione di studenti.
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, LinkedHashMap<String,Long>> mappa = new HashMap<>();
        mappa.put("TITOLO", generaMappaInternaOrdinataSuValori(studs, "TITOLO_DI_STUDIO"));
        return new Rapporto(getTipo(), mappa);
    }

    /**
     *
     * @return il tipo del rapporto che genera, ovvero <strong>TITOLO</strong>
     */
    @Override
    public TipoRapporto getTipo()
    {
        return RapportoBase.TITOLO;
    }

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
