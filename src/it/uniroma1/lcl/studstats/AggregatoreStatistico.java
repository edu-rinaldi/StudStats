package it.uniroma1.lcl.studstats;

import java.util.List;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

public interface AggregatoreStatistico
{
    /**
     * Aggiunge uno studente per l'analisi
     * @param s studente da aggiungere
     */
    void add(Studente s);

    /**
     * Aggiunge un analizzatore all'aggregatore
     * @param an analizzatore da aggiungere
     */
    void add(Analizzatore an);

    /**
     * Genera i rapporti dei tipi specificati
     * (tutti i tipi se non viene specificato nessun tipo)
     * @param tipiRapporto i tipi di cui si vogliono i rapporti
     * @return la lista dei rapporti generati
     */
    List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto);

    /**
     * @return il numero di analizzatori aggiunti all'aggregatore statistico
     */
    int numeroAnalizzatori();

    /**
     * Aggiunge tutti gli analizzatori passati come parametro al set di analizzatori
     * @param analizzatori un numero variabile di analizzatori
     */
    default void addAll(Analizzatore... analizzatori)
    {
        for (Analizzatore a : analizzatori) add(a);
    }

}
