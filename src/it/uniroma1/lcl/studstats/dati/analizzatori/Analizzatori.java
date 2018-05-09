package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.Tipo;


import java.util.HashMap;
import java.util.TreeMap;


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
    };

    public static void main(String[] args)
    {
        System.out.println(Analizzatori.AnalizzatoreAnnoDiploma.getClass().getDeclaredMethods()[0].getAnnotation(Tipo.class));
    }

}
