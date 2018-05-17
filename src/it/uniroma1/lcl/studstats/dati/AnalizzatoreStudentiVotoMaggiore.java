package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import java.util.Collection;
import java.util.Objects;
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
    public TipoRapporto getTipo() {return RapportoBase.VOTO_MAGGIORE; }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        AnalizzatoreStudentiVotoMaggiore an = (AnalizzatoreStudentiVotoMaggiore)o;
        return votoMinimo == an.votoMinimo && analizzatore.equals(an.analizzatore);
    }

    @Override
    public int hashCode() {return Objects.hash(votoMinimo, analizzatore); }
}
