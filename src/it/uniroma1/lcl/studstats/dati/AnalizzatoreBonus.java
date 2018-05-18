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
 * gli istituti presenti in quel comune, per ciascun istituto dà
 * una media dei voti
 */
public class AnalizzatoreBonus implements Analizzatore
{
    private String comune;

    /**
     *
     * @param comune nome del comune su cui fare l'analisi
     */
    public AnalizzatoreBonus(String comune) {this.comune = comune;}

    /**
     *
     * @param studs una collezione di studenti
     * @return un oggetto Rapporto contenente tutte le info sul rapporto generato,
     * se il comune non è presente, verrà restituita una mappa vuota.
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
     *
     * @return il tipo del rapporto che genera, ovvero <strong>BONUS</strong>
     */
    @Override
    public TipoRapporto getTipo() {return RapportoBase.BONUS; }

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
