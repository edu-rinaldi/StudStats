package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;

/**
 * Descrive i metodi principali che DEVONO essere
 * implementati da ogni Analizzatore base
 */
public interface Analizzatore
{
    /**
     *
     * @param studs una collezione di studenti
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    Rapporto generaRapporto(Collection<Studente> studs);

    /**
     *
     * @return il tipo del rapporto che genera
     */
    TipoRapporto getTipo();
}
