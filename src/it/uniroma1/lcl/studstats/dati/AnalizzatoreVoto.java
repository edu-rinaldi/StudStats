package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Analizza gli studenti in base al voto, calcolando:
 * <ul>
 *     <li>voto medio</li>
 *     <li>voto mediano</li>
 *     <li>voto minimo</li>
 *     <li>voto massimo</li>
 * </ul>
 */
public class AnalizzatoreVoto implements Analizzatore
{
    /**
     * Metodo protected di utilità per calcolare il voto medio,
     * per rendere più chiara la semantica del codice e per
     * permettere un riuso del codice da sottoclassi di AnalizzatoreVoto.
     * @param studs una collezione di studenti
     * @param streamVoti uno stream ordinato in modo crescente su tutti i voti
     * @return la media degli studenti
     */
    protected static double mediaStudenti(Collection<Studente> studs, Supplier<IntStream> streamVoti)
    {
        return Double.parseDouble(
                new DecimalFormat("0.00")
                        .format((double)streamVoti.get().sum()/studs.size()));
    }

    /**
     * Metodo protected di utilità per calcolare il voto mediano,
     * per rendere più chiara la semantica del codice e per
     * permettere un riuso del codice da sottoclassi di AnalizzatoreVoto.
     * @param studs una collezione di studenti
     * @param streamVoti uno stream ordinato in modo crescente su tutti i voti
     * @return il voto mediano o 0 se lo stream in fase terminale mi dà
     * un optional che contiene un null
     */
    protected int mediana(Collection<Studente> studs, Supplier<IntStream> streamVoti)
    {
        return (int)(studs.size()%2==1 ? streamVoti.get().skip(studs.size()/2).findFirst().orElse(0):
                streamVoti.get().skip((studs.size()/2)-1).limit(2).average().orElse(0));
    }

    /**
     * Metodo protected di utilità, per calcolare il voto minimo,
     * per rendere più chiara la semantica del codice e per
     * permettere un riuso del codice da sottoclassi di AnalizzatoreVoto.
     * @param streamVoti uno stream ordinato in modo crescente su tutti i voti
     * @return il voto minimo o 0 se lo stream in fase terminale mi dà
     * un optional che contiene un null
     */
    protected int votoMin(Supplier<IntStream> streamVoti)
    {
        return streamVoti.get().min().orElse(0);
    }

    /**
     * Metodo protected di utilità, per calcolare il voto max,
     * per rendere più chiara la semantica del codice e per
     * permettere un riuso del codice da sottoclassi di AnalizzatoreVoto.
     * @param streamVoti uno stream ordinato in modo crescente su tutti i voti
     * @return il voto minimo o 0 se lo stream in fase terminale mi dà
     * un optional che contiene un null
     */
    private int votoMax(Supplier<IntStream> streamVoti)
    {
        return streamVoti.get().max().orElse(0);
    }

    /**
     * Genera un Rapporto analizzando la collezione di studenti.
     * @param studs una collezione di studenti
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, HashMap<String, ? extends Number>> mappa =
                new HashMap<>(Map.of("VOTO", generaMappaInterna(studs)));
        return new Rapporto(getTipo(), mappa);
    }

    /**
     * Genera la "mappaInterna" ovvero la mappa che per ogni collezione
     * di studente che viene data in input contiene informazioni
     * riguardo:
     * <ul>
     *     <li>Voto medio</li>
     *     <li>Voto mediano</li>
     *     <li>Voto minimo</li>
     *     <li>Voto massimo</li>
     * </ul>
     * @param studs collezione di studenti
     * @return la mappa più interna all'interno di un rapporto
     */
    public HashMap<String, ? extends Number> generaMappaInterna(Collection<Studente> studs)
    {
        Supplier<IntStream> streamVoti = ()-> studs
                .stream()
                .mapToInt(studente -> Integer.parseInt(studente.get("MaxDiVOTO")))
                .sorted();

        double media = mediaStudenti(studs, streamVoti);
        int mediana  = mediana(studs, streamVoti);
        int votoMin  = votoMin(streamVoti);
        int votoMax  = votoMax(streamVoti);
        return new HashMap<>(Map.of("VOTO_MEDIO", media, "VOTO_MAX", votoMax,
                        "VOTO_MIN", votoMin, "VOTO_MEDIANO", mediana));
    }
    /**
     * Restituisce il tipo del rapporto che andrà a generare.
     * @return il tipo del rapporto che genera, ovvero <strong>VOTO</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.VOTO; }

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
