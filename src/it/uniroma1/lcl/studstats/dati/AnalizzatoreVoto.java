package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class AnalizzatoreVoto implements Analizzatore
{
    private double mediaStudenti(Collection<Studente> studs, Supplier<IntStream> streamVoti)
    {
        return (double)Math.round(((double)streamVoti.get().sum()/studs.size())*100)/100;
    }

    private int mediana(Collection<Studente> studs, Supplier<IntStream> streamVoti)
    {
        return (int)(studs.size()%2==1 ? streamVoti.get().skip(studs.size()/2).findFirst().orElse(0):
                streamVoti.get().skip((studs.size()/2)-1).limit(2).average().orElse(0));
    }

    private int votoMin(Supplier<IntStream> streamVoti)
    {
        return streamVoti.get().min().orElse(0);
    }

    private int votoMax(Supplier<IntStream> streamVoti)
    {
        return streamVoti.get().max().orElse(0);
    }

    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        Supplier<IntStream> streamVoti = ()-> studs
            .stream()
            .mapToInt(studente -> Integer.parseInt(studente.get("MaxDiVOTO")))
            .sorted();

        double media = mediaStudenti(studs, streamVoti);
        int mediana  = mediana(studs, streamVoti);
        int votoMin  = votoMin(streamVoti);
        int votoMax  = votoMax(streamVoti);

        HashMap<String, ? extends Number> mappaInterna =
                new HashMap<>(Map.of("VOTO_MEDIO", media, "VOTO_MAX", votoMax,
                        "VOTO_MIN", votoMin, "VOTO_MEDIANO", mediana));

        HashMap<String, HashMap<String, ? extends Number>> mappa =
                new HashMap<>(Map.of("VOTO",mappaInterna));
        return new Rapporto(getTipo(), mappa);
    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.VOTO; }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        return !(o == null || o.getClass() != this.getClass());
    }

    @Override
    public int hashCode() {return Objects.hash(this.getClass()); }



}
