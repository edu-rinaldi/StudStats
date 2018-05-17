package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Studente;
import java.util.*;
import static java.util.stream.Collectors.*;


public abstract class AnalizzatoreBasic
{
    protected HashMap<String,Long> generaMappaInterna(Collection<Studente> studs, String key)
    {
        return studs.stream().collect(groupingBy(x -> x.get(key), HashMap::new, counting()));
    }

    protected LinkedHashMap<String,Long> generaMappaInternaOrdinata(Collection<Studente> studs, String tipo)
    {
        return generaMappaInterna(studs, tipo)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
    }
}
