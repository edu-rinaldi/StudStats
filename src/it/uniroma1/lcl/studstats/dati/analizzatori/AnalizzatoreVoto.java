package it.uniroma1.lcl.studstats.dati.analizzatori;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.Studente;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.rapporti.RapportoBase;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class AnalizzatoreVoto implements Analizzatore
{
    @Override
    public Rapporto generaRapporto(Collection<Studente> studs)
    {
        Supplier<IntStream> streamVoti = ()-> studs
            .stream()
            .mapToInt(studente -> Integer.parseInt(studente.get("MaxDiVOTO")))
            .sorted();

        double media = streamVoti.get().sum()/studs.size();
        int votoMin = streamVoti.get().min().orElse(0);
        int votoMax = streamVoti.get().max().orElse(0);
        double mediana = studs.size()%2==1 ? streamVoti.get().skip(studs.size()/2).findFirst().orElse(0):
                                            streamVoti.get().skip((studs.size()/2)-1).limit(2).average().orElse(0);


        return new Rapporto<>(getTipo(),
                new HashMap<String,Number>(Map.of("VOTO_MEDIO",media,"VOTO_MAX", votoMax,
                                                   "VOTO_MIN",votoMin,"VOTO_MEDIANO",mediana)));
    }

    @Override
    public TipoRapporto getTipo() {return RapportoBase.VOTO; }


}
