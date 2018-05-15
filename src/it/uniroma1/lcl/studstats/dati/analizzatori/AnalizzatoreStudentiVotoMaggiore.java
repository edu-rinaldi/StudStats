package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

import java.util.Collection;
import java.util.stream.Collectors;

public class AnalizzatoreStudentiVotoMaggiore implements Analizzatore
{
    private int votoMinimo;
    private Analizzatore analizzatore;

    public AnalizzatoreStudentiVotoMaggiore(int votoMinimo, Analizzatore analizzatore)
    {
        this.votoMinimo = votoMinimo;
        this.analizzatore = analizzatore;
    }

    public AnalizzatoreStudentiVotoMaggiore(int votoMinimo)
    {
        this(votoMinimo, new AnalizzatoreSesso());
    }

    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        return analizzatore.generaRapporto(
                studs.stream()
                .filter(studente -> Integer.parseInt(studente.get("MaxDiVOTO"))>=votoMinimo)
                .collect(Collectors.toList()));
    }

    @Override
    public TipoRapporto getTipo()
    {
        return null;
    }
}
