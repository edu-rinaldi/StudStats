package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.*;
import java.util.function.Function;

public class AnalizzatoreAnnoDiploma extends AnalizzatoreBasic implements Analizzatore
{
    //TODO: Riduci righe
    @Override
    public Rapporto<String,TreeMap<String,Long>> generaRapporto(Collection<Studente> studs)
    {
        TreeMap<String, Long> mappaInterna = new TreeMap<>((s1,s2)->-s1.compareTo(s2));
        mappaInterna.putAll(generaMappaInterna(studs, "ANNO_DIPLOMA"));
        return new Rapporto<>(getTipo(), new HashMap<>(Map.of("ANNO_DIPLOMA",mappaInterna)));
    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.ANNO_DIPLOMA; }

}
