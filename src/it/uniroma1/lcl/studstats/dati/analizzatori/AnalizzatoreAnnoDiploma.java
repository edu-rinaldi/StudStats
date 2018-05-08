package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalizzatoreAnnoDiploma implements Analizzatore
{
    public final TipoRapporto tipoRapportoGenerato;

    public AnalizzatoreAnnoDiploma() { this.tipoRapportoGenerato = Rapporto.RapportoSemplice.ANNO_DIPLOMA;}

    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, TreeMap<String, Integer>> mappa = new HashMap<>();
        TreeMap<String, Integer> mappaInterna = new TreeMap<>();
        for(Studente st: studs)
        {
            String info = st.getInfo().get("ANNO_DIPLOMA");
            if(mappaInterna.containsKey(info)) mappaInterna.merge(info, 1, (x,y)->x+y);
            else mappaInterna.put(info,1);
        }
        mappa.put("ANNO_DIPLOMA", mappaInterna);
        return new Rapporto(Rapporto.RapportoSemplice.ANNO_DIPLOMA, mappa);
    }

    public TipoRapporto getTipoRapportoGenerato() {return tipoRapportoGenerato;}

}
