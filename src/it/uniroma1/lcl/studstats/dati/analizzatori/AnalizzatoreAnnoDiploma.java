/*
package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

@Tipo(tipo= Rapporto.RapportoSemplice.ANNO_DIPLOMA)
public class AnalizzatoreAnnoDiploma implements Analizzatore
{
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, TreeMap<Integer, Integer>> mappa = new HashMap<>();
        TreeMap<Integer, Integer> mappaInterna = new TreeMap<>((x,y)->-x.compareTo(y));


        for(Studente st: studs)
        {
            int info = Integer.parseInt(st.getInfo().get("ANNO_DIPLOMA"));
            if(mappaInterna.containsKey(info)) mappaInterna.merge(info, 1, (x,y)->x+y);
            else mappaInterna.put(info,1);
        }

        mappa.put("ANNO_DIPLOMA", mappaInterna);
        return new Rapporto(Rapporto.RapportoSemplice.ANNO_DIPLOMA, mappa);
    }

}
*/
