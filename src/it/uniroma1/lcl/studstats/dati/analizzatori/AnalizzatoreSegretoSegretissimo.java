package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.util.Collection;

public class AnalizzatoreSegretoSegretissimo implements Analizzatore
{
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        return null;
    }

    @Override
    public TipoRapporto getTipo()
    {
        return null;
    }
}
