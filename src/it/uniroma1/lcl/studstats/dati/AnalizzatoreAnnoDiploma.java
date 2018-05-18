package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.analizzatori.AnalizzatoreBasic;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.*;
/**
 * Analizza gli studenti in base all'anno in cui si sono diplomati.
 */
public class AnalizzatoreAnnoDiploma extends AnalizzatoreBasic implements Analizzatore
{
    /**
     *
     * @param studs una collezione di studenti.
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        TreeMap<String, Long> mappaInterna = new TreeMap<>((s1,s2)->-s1.compareTo(s2));
        mappaInterna.putAll(generaMappaInterna(studs, "ANNO_DIPLOMA"));
        return new Rapporto(getTipo(), new HashMap<>(Map.of("ANNI_DIPLOMA",mappaInterna)));
    }

    /**
     *
     * @return il tipo del rapporto che genera, ovvero <strong>ANNO_DIPLOMA</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.ANNO_DIPLOMA; }

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
