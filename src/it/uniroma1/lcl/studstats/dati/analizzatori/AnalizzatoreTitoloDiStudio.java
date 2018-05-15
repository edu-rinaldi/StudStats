package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AnalizzatoreTitoloDiStudio extends AnalizzatoreBasic implements Analizzatore
{
    @Override
    public Rapporto<String,LinkedHashMap<String,Long>> generaRapporto(Collection<Studente> studs)
    {
        HashMap<String, LinkedHashMap<String,Long>> mappa = new HashMap<>();
        mappa.put("TITOLO_DI_STUDIO", generaMappaInternaOrdinata(studs, "TITOLO_DI_STUDIO"));
        return new Rapporto<>(getTipo(), mappa);
    }

    @Override
    public TipoRapporto getTipo()
    {
        return null;
    }
}
