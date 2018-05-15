package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.Collection;
import java.util.HashMap;

public class AnalizzatoreSesso extends AnalizzatoreBasic implements Analizzatore
{

    @Override
    public Rapporto<String, HashMap<String,Long>> generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, HashMap<String,Long>> mappa = new HashMap<>();
        mappa.put("SESSO", generaMappaInterna(studs, "SESSO"));
        return new Rapporto<>(getTipo(), mappa);
    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.SESSO; }
}
