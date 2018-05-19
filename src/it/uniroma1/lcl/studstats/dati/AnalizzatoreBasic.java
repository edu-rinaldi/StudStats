package it.uniroma1.lcl.studstats.dati;


import java.util.*;
import static java.util.stream.Collectors.*;

/**
 * Classe astratta che definisce come AnalizzatoreBasic
 * ogni analizzatore che deve generare un rapporto basato
 * sulla quantità di certi elementi, non sugli elementi in sè,
 * andando a raggrupparli per una certa chiave, per poi contarli.
 */
public abstract class AnalizzatoreBasic
{
    /**
     *
     * @param studs una collezione di studenti
     * @param key chiave di ricerca che identifica il campo da controllare su ogni studente
     * @return un {@code HashMap<String,Long>} che contiene le informazioni calcolate
     * sugli studenti per la chiave specificata
     */
    protected HashMap<String,Long> generaMappaInterna(Collection<Studente> studs, String key)
    {
        return studs.stream().collect(groupingBy(x -> x.get(key), HashMap::new, counting()));
    }

    /**
     *
     * @param studs una collezione di studenti
     * @param key chiave di ricerca che identifica il campo da controllare su ogni studente
     * @return un {@code HashMap<String,Long>}che contiene le informazioni calcolate
     * sugli studenti per la chiave specificata, ma ordinata per valori.
     */
    protected LinkedHashMap<String,Long> generaMappaInternaOrdinataSuValori(Collection<Studente> studs, String key)
    {
        return generaMappaInterna(studs, key)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
    }

}
