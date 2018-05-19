package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Analizza gli studenti sfruttando un altro Analizzatore, andando
 * a fare un'analisi solo sugli studenti che hanno un voto {@code >=} votoMinimo
 */
public class AnalizzatoreStudentiVotoMaggiore implements Analizzatore
{
    private int votoMinimo;
    private Analizzatore analizzatore;

    /**
     * Costruisce un oggetto a partire da un votoMinimo e un altro analizzatore.
     * @param votoMinimo parametro usato per filtrare gli studenti che hanno
     *                   voto {@code >=} votoMinimo.
     * @param analizzatore analizzatore che viene utilizzato.
     */
    public AnalizzatoreStudentiVotoMaggiore(int votoMinimo, Analizzatore analizzatore)
    {
        this.votoMinimo = votoMinimo;
        this.analizzatore = analizzatore;
    }

    /**
     * Overload del costruttore, quando non viene passato un analizzatore,
     * di default al campo analizzatore viene assegnato un'istanza dell'analizzatoreSesso
     * @param votoMinimo parametro usato per filtrare gli studenti che hanno
     *                   voto {@code >=} votoMinimo
     */
    public AnalizzatoreStudentiVotoMaggiore(int votoMinimo)
    {
        this(votoMinimo, new AnalizzatoreSesso());
    }

    /**
     * Genera un Rapporto analizzando la collezione di studenti
     * @param studs una collezione di studenti.
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        return analizzatore.generaRapporto(
                studs.stream()
                .filter(studente -> Integer.parseInt(studente.get("MaxDiVOTO"))>=votoMinimo)
                .collect(Collectors.toList()));
    }

    /**
     * Restituisce il tipo del rapporto che andrà a generare.
     * @return il tipo del rapporto che genera, ovvero <strong>ISTITUTI</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.VOTO_MAGGIORE; }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        AnalizzatoreStudentiVotoMaggiore an = (AnalizzatoreStudentiVotoMaggiore)o;
        return votoMinimo == an.votoMinimo && analizzatore.equals(an.analizzatore);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {return Objects.hash(votoMinimo, analizzatore); }
}
