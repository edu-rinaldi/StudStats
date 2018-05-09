package it.uniroma1.lcl.studstats.dati;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Collection;


@FunctionalInterface
public interface Analizzatore
{
    Rapporto generaRapporto(Collection<Studente> studs);

    default String getTipo() throws Exception
    {
        return this.getClass()
                .getDeclaredMethod("generaRapporto", Collection.class)
                .getDeclaredAnnotation(Tipo.class).tipo();
    }
}
