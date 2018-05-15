package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;

public interface Analizzatore
{
    Rapporto generaRapporto(Collection<Studente> studs);
    TipoRapporto getTipo();
}
