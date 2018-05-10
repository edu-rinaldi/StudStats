package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.Tipo;


import java.util.*;


public class Analizzatori
{

    @Tipo(tipo="ANNO_DIPLOMA")
    public static final Analizzatore AnalizzatoreAnnoDiploma = studs ->
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
    };

    @Tipo(tipo = "ISTITUTI")
    public static final Analizzatore analizzatoreIstituti = studs ->
    {
        HashMap<String, LinkedHashMap<String, Integer>> mappa = new HashMap<>();
        LinkedHashMap<String, Integer> mappaInterna = new LinkedHashMap<>();

        for(Studente st: studs)
        {
            String info = st.getInfo().get("ISTITUTO_SUPERIORE");
            if(mappaInterna.containsKey(info)) mappaInterna.merge(info, 1, (x,y)->x+y);
            else mappaInterna.put(info,1);
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(mappaInterna.entrySet());
        mappaInterna.clear();

        entryList.stream()
                .sorted((e1,e2)-> -e1.getValue().compareTo(e2.getValue()))
                .forEach(e-> mappaInterna.put(e.getKey(),e.getValue()));

        mappa.put("ISTITUTO_SUPERIORE", mappaInterna);
        return new Rapporto(Rapporto.RapportoSemplice.ISTITUTI, mappa);
    };
}
