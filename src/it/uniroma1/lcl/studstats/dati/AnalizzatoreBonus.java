package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author eduardo_rinaldi
 */

/**
 * Dato un comune, restituisce un rapporto su quali sono
 * gli istituti presenti in quel comune, per ciascun istituto fa un'analisi
 * sui voti degli studenti che hanno frequentato quell'istituto.
 */
public class AnalizzatoreBonus implements Analizzatore
{
    private String comune;

    /**
     *
     * @param comune nome del comune su cui fare l'analisi
     *               se questo è una stringa vuota
     *               di default il comune è "ROMA".
     */
    public AnalizzatoreBonus(String comune)
    {
        if(comune.equals("")) this.comune = "ROMA";
        else this.comune = normalizzaComune(comune);
    }

    /**
     * Overload del costruttore con String comune,
     * se non viene passato nessun comune, di default
     * questo è "ROMA"
     */
    public AnalizzatoreBonus() {this("");}

    /**
     * Normalizza la stringa del comune, facendo un UpperCase e un
     * eventuale trim nel caso in cui ci fossero spazi inutili.
     * @param c stringa da normalizzare.
     * @return stringa normalizzata in UpperCase e senza spazi.
     */
    private String normalizzaComune(String c)
    {
        return c.toUpperCase().trim();
    }

    /**
     * Genera un rapporto analizzando la collezione di studenti
     * @param studs una collezione di studenti
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato.
     */
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        return new Rapporto(getTipo(),
                studs.stream()
                        .filter(st->st.get("COMUNE_ISTITUTO").equals(comune))
                        .collect(groupingBy(st->st.get("ISTITUTO_SUPERIORE"), Collectors.toList()))
                        .entrySet()
                        .stream()
                        .collect(Collectors
                                .<Map.Entry<String,List<Studente>>,
                                            String,
                                            HashMap<String, ? extends Number>,
                                            HashMap<String, HashMap<String, ? extends Number>>>
                                toMap(Map.Entry::getKey,
                                 e->new AnalizzatoreVoto().generaMappaInterna(e.getValue()),
                                 (e1,e2)->e1,HashMap::new)));
    }

    /**
     * Restituisce il tipo del rapporto che andrà a generare.
     * @return il tipo del rapporto che genera, ovvero <strong>BONUS</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.BONUS; }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        AnalizzatoreBonus an = (AnalizzatoreBonus)o;
        return comune.equals(an.comune);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {return comune.hashCode();}

    /**
     * Easter egg
     */
    public static void easterEgg()
    {
        System.out.println("+oooooooooooooooooooo++:-`    \n" +
                "osssssssssssssssssssssssss+`  \n" +
                "osssssssssssssssssssssssssss` \n" +
                "ossssssssssssssssso--:ssssss: \n" +
                "osssssso-` `-ossss-   +sssss- \n" +
                "ossssss-     :sssso /osssss:  \n" +
                "osssssso.   `ossss-:sssss/`   \n" +
                "osssssss/`os:.oss+`sssssss+-  \n" +
                "osssssss`+ssso./+./ssssssssso`\n" +
                "ossssss/.sssss/   `osssssssss/\n" +
                "ossss:. .ossss/`  `osssssssss+\n" +
                "osss/    :ssssssoosssssssssss:\n" +
                "ossss/--/sssssssssssssssssss+ \n" +
                "ossssssssssssssssssssssssso-  \n" +
                "+oooooooooooooooooooo+/:-`   " +
                "\n\n----------------------\n");
    }


}
