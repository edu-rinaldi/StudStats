package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.Tipo;

import java.util.*;


public class AnalizzatoreIstituti implements Analizzatore
{
    @Tipo(tipo="ISTITUTI")
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, TreeMap<String, Integer>> mappa = new HashMap<>();
        TreeMap<String, Integer> mappaInterna = new TreeMap<>();


        for(Studente st: studs)
        {
            String info = st.getInfo().get("ISTITUTO_SUPERIORE");
            if(mappaInterna.containsKey(info)) mappaInterna.merge(info, 1, (x,y)->x+y);
            else mappaInterna.put(info,1);
        }

        mappa.put("ISTITUTO_SUPERIORE", mappaInterna);
        return new Rapporto(Rapporto.RapportoSemplice.ISTITUTI, mappa);
    }
}
