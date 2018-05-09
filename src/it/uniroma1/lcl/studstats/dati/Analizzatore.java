package it.uniroma1.lcl.studstats.dati;

import java.lang.reflect.Method;
import java.util.Collection;

@FunctionalInterface
public @interface Analizzatore
{
    Rapporto generaRapporto(Collection<Studente> studs);

    /*default TipoRapporto getReturnType() throws NoSuchMethodException {
        Method method = this.getClass().getMethod("generaRapporto");
        return method.getReturnType();
    }
    */
}
