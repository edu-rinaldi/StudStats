package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;


public class AnalizzatoreIstituti extends AnalizzatoreBasic implements Analizzatore
{

    @Override
    public Rapporto<String, LinkedHashMap<String, Long>> generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, LinkedHashMap<String, Long>> mappa = new HashMap<>();
        mappa.put("ISTITUTI", generaMappaInternaOrdinata(studs,"ISTITUTO_SUPERIORE"));
        return new Rapporto<>(getTipo(), mappa);
    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.ISTITUTI; }
}
